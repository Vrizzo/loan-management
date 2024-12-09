package com.mybank.loan_management.core.features;

import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.model.MonthlyFee;
import com.mybank.loan_management.core.repository.LoanRepository;
import com.mybank.loan_management.core.services.RatePlanCalculator;
import com.mybank.loan_management.dto.LoanRequest;
import com.mybank.loan_management.dto.LoanResponse;

import java.util.List;

public class CreateLoan {

    private final LoanRepository loanRepository;
    private final RatePlanCalculator ratePlanCalculator;

    public CreateLoan(LoanRepository loanRepository, RatePlanCalculator ratePlanCalculator) {
        this.loanRepository = loanRepository;
        this.ratePlanCalculator = ratePlanCalculator;
    }

    public LoanResponse crate(LoanRequest loanRequest) {

        List<MonthlyFee> monthlyFees = ratePlanCalculator.calculateRatePlan(loanRequest.getLoanAmount(), loanRequest.getTerm());
        Loan loan = toLoan(loanRequest, monthlyFees);
        loanRepository.save(loan);
        return new LoanResponse(loan);
    }

    private Loan toLoan(LoanRequest loanRequest, List<MonthlyFee> monthlyFees) {
        return new Loan(loanRequest.getLoanAmount(), loanRequest.getTerm(), loanRequest.getFullName(), loanRequest.getPersonalId(), monthlyFees);
    }
}
