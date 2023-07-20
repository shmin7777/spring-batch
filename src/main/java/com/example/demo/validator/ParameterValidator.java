package com.example.demo.validator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.util.StringUtils;

public class ParameterValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String name = parameters.getString("fileName");

        if (!StringUtils.hasText(name)) {
            throw new JobParametersInvalidException("filName parameter is missing");
        } else if (!StringUtils.endsWithIgnoreCase(name, "csv")) {
            throw new JobParametersInvalidException(
                    "fileName parameter does not use the csv file extension");
        }


    }

}
