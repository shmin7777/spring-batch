package com.example.demo.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomService {

    public void serviceMethod() {
        log.info("Service method was called");
    }
}
