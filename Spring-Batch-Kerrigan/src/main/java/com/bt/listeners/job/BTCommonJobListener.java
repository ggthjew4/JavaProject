package com.bt.listeners.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.bt.exception.TokenNotMappingException;
import com.bt.service.IBTJobValidateService;
import com.bt.utils.MessagesUtils;

public class BTCommonJobListener implements JobExecutionListener {
	private static final Log		logger	= LogFactory.getLog(BTCommonJobListener.class);
	@Autowired
	private JobOperator				jobOperator;
	@Autowired
	private IBTJobValidateService	validateService;
	private Resource				srcFile;
	private Resource				tokenFile;

	public void beforeJob(JobExecution jobExecution) {
		try {
			logger.error(MessagesUtils.getMessage("springbatch.message.batch.start", jobExecution.getJobInstance().getJobName()));
			validateService.checkFileTokenStatus(srcFile, tokenFile);
		}
		catch (TokenNotMappingException e) {
			logger.error(e.getMessage(), e);
			try {
				jobOperator.stop(jobExecution.getId());
			}
			catch (NoSuchJobExecutionException e1) {
				logger.error(e1.getMessage(), e1);
			}
			catch (JobExecutionNotRunningException e1) {
				logger.error(e1.getMessage(), e1);
			}
		}
	}

	public void setSrcFile(Resource srcFile) {
		this.srcFile = srcFile;
	}

	public void setTokenFile(Resource tokenFile) {
		this.tokenFile = tokenFile;
	}

	public void afterJob(JobExecution jobExecution) {
		logger.info(MessagesUtils.getMessage("springbatch.message.batch.end", jobExecution.getJobInstance().getJobName()));
	}
}
