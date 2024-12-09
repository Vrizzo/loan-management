package com.mybank.loan_management.core.model;

import java.math.BigDecimal;
import java.util.List;

public class Loan {
    private final BigDecimal loanAmount;
    private final Integer term;
    private final String fullName;

    public Loan(BigDecimal loanAmount, Integer term, String fullName, String personalId, List<MonthlyFee> monthlyFees) {
        this.loanAmount = loanAmount;
        this.term = term;
        this.fullName = fullName;
        this.personalId = personalId;
        this.monthlyFees = monthlyFees;
    }

    private final String personalId;
    private final List<MonthlyFee> monthlyFees;


    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public Integer getTerm() {
        return term;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public List<MonthlyFee> getMonthlyFees() {
        return monthlyFees;
    }
}
