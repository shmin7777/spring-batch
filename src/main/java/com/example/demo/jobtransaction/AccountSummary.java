package com.example.demo.jobtransaction;

import lombok.Data;

@Data
public class AccountSummary {
    private int id;
    private String accountNumber;
    private Double currentBalance;
}
