package com.example.demo.tasklet;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloTasklet implements Tasklet {
    private static final String HELLO_WORLD = "Hello, %s";

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {
        String name = contribution.getStepExecution().getJobParameters().getString("name");

        ExecutionContext jobContext = chunkContext.getStepContext().getStepExecution()
                .getJobExecution().getExecutionContext();
        
        ExecutionContext stepContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
        
        jobContext.put("user.name", name);
        stepContext.put("user.name2", name);
        
        
        System.out.println(String.format(HELLO_WORLD, name));

        return RepeatStatus.FINISHED;
    }

}
