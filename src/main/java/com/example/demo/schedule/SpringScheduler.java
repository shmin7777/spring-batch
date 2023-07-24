package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@EnableAsync
@Component
@Slf4j
public class SpringScheduler {
//    @Async
//    @Scheduled(fixedRate  = 1000) // scheduler 끝나는 시간 기준으로 1000 간격으로 실행
//    public void scheduleFixedDelayTask() throws InterruptedException {
//        Thread.sleep(10000);
//        log.info(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }
}
