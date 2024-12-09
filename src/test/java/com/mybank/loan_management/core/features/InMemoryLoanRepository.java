package com.mybank.loan_management.core.features;

import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;

import java.util.HashMap;

public class InMemoryLoanRepository implements LoanRepository {
    HashMap<String, Loan> loans = new HashMap<>();

    @Override
    public void save(Loan loan) {
        loans.put(loan.getPersonalId(), loan);
    }

    @Override
    public Loan getById(String personalId) {
        return loans.get(personalId);
    }
}
