package com.bt.service;

import org.springframework.core.io.Resource;

import com.bt.exception.TokenNotMappingException;

public interface IBTJobValidateService {
	
	public void checkFileTokenStatus(final Resource srcFile,Resource tokenFile) throws TokenNotMappingException;
}
