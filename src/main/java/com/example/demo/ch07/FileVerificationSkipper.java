package com.example.demo.ch07;

import java.io.FileNotFoundException;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.ParseException;

public class FileVerificationSkipper implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable ex, int skipCount) throws SkipLimitExceededException {
        if (ex instanceof FileNotFoundException) {
            return false;
        } else if (ex instanceof ParseException && skipCount <= 10) {
            return true;
        }
        return false;
    }

}
