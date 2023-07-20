package com.example.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

//public class JobLoggerListener implements JobExecutionListener {
//
//    private static String START_MESSAGE = "%s is beginning execution";
//    private static String END_MESSAGE = "%s has completed with the status %s";
//
//
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//        System.out
//                .println(String.format(START_MESSAGE, jobExecution.getJobInstance().getJobName()));
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        System.out.println(String.format(END_MESSAGE, jobExecution.getJobInstance().getJobName(),
//                jobExecution.getStatus()));
//    }
//
//}

/**
 * JobExecutionListener를 구현하지 않고 Anotation으로 동일한 기능 구현 가능 
 * 
 * @author shmin
 *
 */
public class JobLoggerListener  {

    private static String START_MESSAGE = "%s is beginning execution";
    private static String END_MESSAGE = "%s has completed with the status %s";


    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        System.out
                .println(String.format(START_MESSAGE, jobExecution.getJobInstance().getJobName()));
    }

    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        System.out.println(String.format(END_MESSAGE, jobExecution.getJobInstance().getJobName(),
                jobExecution.getStatus()));
    }

}
