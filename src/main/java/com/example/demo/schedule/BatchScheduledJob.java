//package com.example.demo.schedule;
//
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.explore.JobExplorer;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class BatchScheduledJob extends QuartzJobBean {
//
//    @Autowired
//    private Job job;
//
//    @Autowired
//    private JobExplorer jobExplorer;
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        JobParameters jobParameters = new JobParametersBuilder(this.jobExplorer)
//                .getNextJobParameters(job).toJobParameters();
//
//        log.info("batch job 실행!!!!");
//        try {
//            this.jobLauncher.run(job, jobParameters);
//        } catch (JobExecutionAlreadyRunningException | JobRestartException
//                | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
