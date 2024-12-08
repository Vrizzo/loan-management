package com.mybank.loan_management.core.repository;

import com.mybank.loan_management.core.model.Loan.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


public interface LoanRepository {
    void save(Loan loan);

    Loan getById(String personalId);
}
