package com.mybank.loan_management.core.model;

import java.math.BigDecimal;

public class Loan {
    private final BigDecimal loanAmount;
    private final Integer term;
    private final String fullName;

    public Loan(BigDecimal loanAmount, Integer term, String fullName, String personalId) {
        this.loanAmount = loanAmount;
        this.term = term;
        this.fullName = fullName;
        this.personalId = personalId;
    }

    private final String personalId;


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
}
