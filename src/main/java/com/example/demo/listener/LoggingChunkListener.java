package com.example.demo.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.scope.context.ChunkContext;

public class LoggingChunkListener implements ChunkListener{

    @Override
    public void beforeChunk(ChunkContext context) {
        System.out.println("비포 청크!!!!!!!!!!!!!!!!!");
        
    }

    @Override
    public void afterChunk(ChunkContext context) {
        // TODO Auto-generated method stub
        System.out.println("에프터 청ㅇ크!!!!!!!!!!!!!!");
        
    }

    @Override
    public void afterChunkError(ChunkContext context) {
        // TODO Auto-generated method stub
        System.out.println("청크 에러!!!!!!!!!!!!");
    }
    
}
