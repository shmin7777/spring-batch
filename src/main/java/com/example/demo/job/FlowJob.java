//package com.example.demo.job;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.FlowBuilder;
//import org.springframework.batch.core.job.flow.Flow;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//public class FlowJob {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Tasklet loadStockFile() {
//        return (contribution, chunkContext) -> {
//            System.out.println("the stock file has bean loaded!!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Tasklet loadCustomerFile() {
//        return (contribution, chunkContext) -> {
//            System.out.println("the customer file has bean loaded!!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Tasklet updateStart() {
//        return (contribution, chunkContext) -> {
//            System.out.println("the start has bean updated!!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Tasklet runBatchTasklet() {
//        return (contribution, chunkContext) -> {
//            System.out.println("the batch has bean run!!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Flow preProcessingFlow() {
//        return new FlowBuilder<Flow>("preProcessingFlow").start(loadFileStep())
//                .next(loadCustomerStep())
//                .next(updateStartStep())
//                .build();
//    }
//    
//    @Bean
//    public Step initializeBatch() {
//        return this.stepBuilderFactory.get("initalizeBatch")
//                .flow(preProcessingFlow())
//                .build();
//    }
//
//    @Bean
//    public Job conditionalStepLogicJob() {
//        return this.jobBuilderFactory.get("conditionalStepLogicJob")
//                .start(initializeBatch())
//                .next(runBatch())
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }
//
//    @Bean
//    public Step loadFileStep() {
//        return this.stepBuilderFactory.get("loadFileStep")
//                .tasklet(loadStockFile())
//                .build();
//    }
//
//    @Bean
//    public Step loadCustomerStep() {
//        return this.stepBuilderFactory.get("loadCustomerStep")
//                .tasklet(loadCustomerFile())
//                .build();
//    }
//
//    @Bean
//    public Step updateStartStep() {
//        return this.stepBuilderFactory.get("updateStartStep")
//                .tasklet(updateStart())
//                .build();
//    }
//
//    @Bean
//    public Step runBatch() {
//        return this.stepBuilderFactory.get("runBatch")
//                .tasklet(runBatchTasklet())
//                .build();
//    }
//
//}
