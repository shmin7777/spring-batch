//package com.example.demo.schedule;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.TimeZone;
//import org.quartz.CronScheduleBuilder;
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
//        return JobBuilder.newJob(BatchScheduledJob.class).withDescription("description")
//                .withIdentity("test job key2", "test group").usingJobData("key1", "value1")
//                .storeDurably().build();
//    }
//
//    @Bean
//    public Trigger jobTrigger() throws ParseException {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(5)
//                .withRepeatCount(10);
//        System.out.println(new Date());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//        
//        CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
//
//        
//        Date start = sdf.parse("2023-08-07 11:29:00");
//        Date end = sdf.parse("2023-08-07 11:29:30");
//
//        return TriggerBuilder.newTrigger().forJob(quartzJobDetail()).withSchedule(scheduleBuilder)
//                .startAt(new Date())
//                .endAt(null)
//                .build();
//
//    }
//}
