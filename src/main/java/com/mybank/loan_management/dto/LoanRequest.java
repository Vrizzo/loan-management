package com.mybank.loan_management.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanRequest implements Serializable {
    private final BigDecimal loanAmount;
    private final Integer term;
    private final String fullName;
    private final String personalId;

    public LoanRequest(BigDecimal loanAmount, Integer term, String fullName, String personalId) {
        this.loanAmount = loanAmount;
        this.term = term;
        this.fullName = fullName;
        this.personalId = personalId;
    }

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
