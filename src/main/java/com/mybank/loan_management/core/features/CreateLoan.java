package com.mybank.loan_management.core.features;

import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;
import com.mybank.loan_management.dto.LoanRequest;

public class CreateLoan {

    private final LoanRepository loanRepository;

    public CreateLoan(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
    }

    public void crate(LoanRequest loanRequest) {
        loanRepository.save(toLoan(loanRequest));
    }

    private Loan toLoan(LoanRequest loanRequest) {
        return new Loan(loanRequest.getLoanAmount(), loanRequest.getTerm(), loanRequest.getFullName(), loanRequest.getPersonalId());
    }
}
