package com.bt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-application.xml" })
public class JobMainUnitTest implements ApplicationContextAware {
	private static final Log	LOG	= LogFactory.getLog(JobMainUnitTest.class);
	ApplicationContext			applicationContext;
	@Autowired
	JobLauncher					jobLauncher;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void test() {
		/*
		       測試相關事項:
		 1.匯入BT公司成員資料job並檢核token job
		   job:btEmployeeJob 和No.1的job相同也但會檢查token，可修改token檔案進行驗證
		 2.匯入BT部門資料job
		   job:btDepartmentJob
		 3.匯入BT公司成員資料並使用多執行續方式備份於backup job
		   job:btMemberBackupJob 同步執行上述job並同步備份於backup table
		 4.token相關檔案路徑設定於batch.properties，需要配合建立
		 5.測試No.3狀況如成功驗證會顯示i18n中文錯誤訊息"檢查token和file資料列數不符 , token : ? 筆  file : ? 筆"，並停止job
		 6.每次測試都會清空Employee,Department資料，但springbatch資料不清空
		 
		 */
		final Job job = (Job) applicationContext.getBean("btMemberBackupJob");
		final JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addLong("time", System.nanoTime());
		try {
			jobLauncher.run(job, jobParametersBuilder.toJobParameters());
		}
		catch (JobExecutionAlreadyRunningException e) {
			printError(e);
		}
		catch (JobRestartException e) {
			printError(e);
		}
		catch (JobInstanceAlreadyCompleteException e) {
			printError(e);
		}
		catch (JobParametersInvalidException e) {
			printError(e);
		}
	}

	private void printError(final Exception e) {
		LOG.error(e.getMessage(), e);
	}
}
