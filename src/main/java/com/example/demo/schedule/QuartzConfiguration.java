//package com.example.demo.schedule;
//
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfiguration {
//
//    @Bean
//    public JobDetail quartzJobDetail() {
//        return JobBuilder.newJob(BatchScheduledJob.class).withDescription("description").withIdentity("test job key2", "test group").usingJobData("key1", "value1").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger jobTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(5)
//                .withRepeatCount(4);
//
//        return TriggerBuilder.newTrigger().forJob(quartzJobDetail()).withSchedule(scheduleBuilder)
//                .build();
//
//    }
//}
