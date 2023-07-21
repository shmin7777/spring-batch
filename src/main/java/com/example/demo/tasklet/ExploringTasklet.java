package com.example.demo.tasklet;

import java.util.List;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExploringTasklet implements Tasklet {

    private final JobExplorer explorer;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {
        String jobName = chunkContext.getStepContext().getJobName();

        List<JobInstance> jobInstances = explorer.getJobInstances(jobName, 0, Integer.MAX_VALUE);

        System.out.println(String.format("There are %d job instances for the job %s",
                jobInstances.size(), jobName));

        System.out.println("*****************************");

        for (JobInstance instance : jobInstances) {
            List<JobExecution> jobExecutions = this.explorer.getJobExecutions(instance);

            System.out.println(String.format("Instance %d had %d executions",
                    instance.getInstanceId(), jobExecutions.size()));

            for (JobExecution execution : jobExecutions) {
                System.out.println(String.format("\tExecution %d resulted in Exit Status %s",
                        execution.getId(), execution.getExitStatus()));

            }
        }

        return RepeatStatus.FINISHED;
    }


}
