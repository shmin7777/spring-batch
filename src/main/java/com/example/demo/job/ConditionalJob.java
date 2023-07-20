package com.example.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ConditionalJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet passTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Pass!!!!");
//            throw new RuntimeException();
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet successTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Success!!!!");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Tasklet failTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("Fail!!!!!");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Job job() {
        System.out.println("잡 등록");
//        return this.jobBuilderFactory.get("conditionalJob")
//                .start(firstStep()).on("FAILED").to(failureStep())
//                .from(firstStep()).on("*").to(successStep())
//                .end()
//                .incrementer(new RunIdIncrementer())
//                .build();
        return this.jobBuilderFactory.get("conditionalJob")
                .start(firstStep())
                .next(decider())
//                .from(decider()).on("FAILED").to(failureStep())
                .from(decider()).on("FAILED").stopAndRestart(successStep())
                .from(decider()).on("*").to(successStep())
                .end()
//                .incrementer(new RunIdIncrementer())
                .build();
    }
    
    @Bean
    public JobExecutionDecider decider() {
       return new RandomDecider(); 
    }

    @Bean
    public Step firstStep() {
        return this.stepBuilderFactory.get("firstStep")
                .tasklet(passTasklet())
                .build();
    }


    @Bean
    public Step successStep() {
        return this.stepBuilderFactory.get("successStep")
                .tasklet(successTasklet())
                .build();
    }



    @Bean
    public Step failureStep() {
        return this.stepBuilderFactory.get("failureStep")
                .tasklet(failTasklet())
                .build();
    }

}
