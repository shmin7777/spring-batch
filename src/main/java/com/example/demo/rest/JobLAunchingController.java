package com.example.demo.rest;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLAunchingController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private JobExplorer jobExplorer;

    @PostMapping("/run")
    public ExitStatus runJob(@RequestBody JobLaunchRequest request)
            throws Exception {
        Job job = this.context.getBean(request.getName(), Job.class);

        if (request.getBeforeName() != null) {
            Job beforeJob = this.context.getBean(request.getBeforeName(), Job.class);

            JobParameters jobParameters =
                    new JobParametersBuilder(request.getJobParameters(), jobExplorer)
//                            .getNextJobParameters(beforeJob)
                            .toJobParameters();

            try {
                jobLauncher.run(beforeJob, jobParameters).getExitStatus();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        JobParameters jobParameters =
                new JobParametersBuilder(request.getJobParameters(), jobExplorer)
//                        .getNextJobParameters(job)
                        .toJobParameters();

        return this.jobLauncher.run(job, jobParameters).getExitStatus();
    }
}
