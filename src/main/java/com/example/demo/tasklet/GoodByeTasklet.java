package com.example.demo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class GoodByeTasklet implements Tasklet{

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {
        String name = (String) chunkContext.getStepContext().getJobParameters().get("name");
        System.out.println("Good bye "+name);
        return RepeatStatus.FINISHED;
    }

}
