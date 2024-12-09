package com.mybank.loan_management.core.repository;

import com.mybank.loan_management.core.model.Loan;


public interface LoanRepository {
    void save(Loan loan);

    Loan getById(String personalId);
}
