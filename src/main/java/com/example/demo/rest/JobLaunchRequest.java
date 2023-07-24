package com.example.demo.rest;

import java.util.Properties;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import lombok.Getter;
import lombok.Setter;

public class JobLaunchRequest {

    @Setter
    @Getter
    private String name;

    private Properties jobParameters;

    public Properties getJobParamsProperties() {
        return jobParameters;
    }

    public void setJobParamsProperties(Properties properties) {
        this.jobParameters = properties;
    }

    public JobParameters getJobParameters() {
        Properties properties = new Properties();
        properties.putAll(this.jobParameters);
        return new JobParametersBuilder(properties).toJobParameters();
    }
}
