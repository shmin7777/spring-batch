package com.example.demo.jobtransaction;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class TransactionReader implements ItemStreamReader<Transaction> {

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() throws ItemStreamException {
        // TODO Auto-generated method stub

    }

    @Override
    public Transaction read() throws Exception, UnexpectedInputException, ParseException,
            NonTransientResourceException {
        // TODO Auto-generated method stub
        return null;
    }

}
