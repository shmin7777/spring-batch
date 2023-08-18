package com.example.demo.ch07;


import java.util.Date;
import lombok.Data;

@Data
public class Transaction {
    private String accountNumber;
    private Date transactionDate;
    private Double amount;
}
