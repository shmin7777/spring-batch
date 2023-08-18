package com.example.demo.ch07;

import org.springframework.batch.core.annotation.OnReadError;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerItemListener {

    @OnReadError
    public void onReadError(Exception e) {
        if (e instanceof FlatFileParseException) {
            FlatFileParseException flatFileParseException = (FlatFileParseException) e;

            log.error(
                    "an error occured while processing the {} line of the file . below was the fault input\n :: error: {}",
                    flatFileParseException.getLineNumber(), e);
        } else {
            log.error("error occured :: {}", e);
        }
    }
}
