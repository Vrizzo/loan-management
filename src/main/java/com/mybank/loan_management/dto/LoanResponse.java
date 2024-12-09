package com.mybank.loan_management.dto;

import com.mybank.loan_management.core.model.Loan;

public class LoanResponse {
    private final Loan loan;

    public LoanResponse(Loan loan) {
        this.loan = loan;
    }

    public Loan getLoan() {
        return loan;
    }
}
