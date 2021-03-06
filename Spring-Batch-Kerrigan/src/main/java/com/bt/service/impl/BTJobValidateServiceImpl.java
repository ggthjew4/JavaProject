package com.bt.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bt.exception.TokenNotMappingException;
import com.bt.service.IBTJobValidateService;
import com.bt.utils.MessagesUtils;

@Service
public class BTJobValidateServiceImpl implements IBTJobValidateService {
	private static final Log	logger					= LogFactory.getLog(BTJobValidateServiceImpl.class);
	private static final String	DEFAULT_CHARSET_NAME	= "UTF-8";
	private static final String	DELIMITER_COMMA			= "|";
	private static final String	TOKEN_KEY				= "999";

	public void checkFileTokenStatus(final Resource srcFile, final Resource tokenFile) throws TokenNotMappingException {
		try {
			BufferedReader srcFileReader = getResourceBufferedReader(srcFile);
			BufferedReader tokenFileReader = getResourceBufferedReader(tokenFile);
			int srcCount = getSrcFileCount(srcFileReader);
			int tokenCount = getTokenCount(tokenFileReader);
			if (!checkTokenAvailable(srcCount, tokenCount)) {
				throw new TokenNotMappingException(MessagesUtils.getMessage("springbatch.message.batch.validate.count.error", String.valueOf(srcCount), String.valueOf(tokenCount)));
			}
		}
		catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
		catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private Integer getSrcFileCount(final BufferedReader bufferedReader) throws IOException {
		Assert.notNull(bufferedReader, "bufferedReader must be require.");
		int fileSize = 0;
		final BufferedReader br = bufferedReader;
		while ((br.readLine()) != null) {
			fileSize++;
		}
		logger.debug("getSrcFileCount count :" + fileSize);
		return fileSize;
	}

	private Integer getTokenCount(final BufferedReader bufferedReader) {
		Assert.notNull(bufferedReader, "bufferedReader must be require.");
		final BufferedReader br = bufferedReader;
		String line = StringUtils.EMPTY;
		Integer count = 0;
		try {
			while ((line = br.readLine()) != null) {
				String[] strArray = StringUtils.split(line, DELIMITER_COMMA);
				if (strArray[0].equals(TOKEN_KEY)) {
					count = Integer.valueOf(strArray[strArray.length - 1]);
					break;
				}
			}
		}
		catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
		}
		catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		finally {
			try {
				bufferedReader.close();
			}
			catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		logger.debug("getTokenCount count :" + count);
		return count;
	}

	private BufferedReader getResourceBufferedReader(final Resource resource) throws UnsupportedEncodingException, IOException {
		Assert.notNull(resource, "resource must be require.");
		return new BufferedReader(new InputStreamReader(resource.getInputStream(), DEFAULT_CHARSET_NAME));
	}

	private boolean checkTokenAvailable(final Integer srcCount, final Integer tokenCount) {
		Assert.notNull(srcCount, "srcCount must be require.");
		Assert.notNull(tokenCount, "tokenCount must be require.");
		return srcCount == tokenCount;
	}
	
	public final static void main(String[] arg){
		String a = "gg";
		String b = a;
		String c= b.substring(0,1);
		System.out.println(c);
			
	}
}
