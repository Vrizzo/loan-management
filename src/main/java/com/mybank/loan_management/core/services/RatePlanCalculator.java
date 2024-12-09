package com.mybank.loan_management.core.services;

import com.mybank.loan_management.core.model.MonthlyFee;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class RatePlanCalculator {
    private final int interestRate;

    public RatePlanCalculator(int interestRate) {
        this.interestRate = interestRate;
    }

    public List<MonthlyFee> calculateRatePlan(BigDecimal loanAmount, int term) {
        ArrayList<MonthlyFee> monthlyFees = new ArrayList<>();

        BigDecimal loanTotalInterest = loanAmount.divide(new BigDecimal(100), MathContext.DECIMAL32).multiply(new BigDecimal(interestRate));
        BigDecimal loanTotalAmount = loanAmount.add(loanTotalInterest);

        BigDecimal monthlyAmount = loanTotalAmount.divide(new BigDecimal(term), MathContext.DECIMAL32);
        BigDecimal monthlyInterest = loanTotalInterest.divide(new BigDecimal(term), MathContext.DECIMAL32);

        BigDecimal residualAmount = new BigDecimal(loanTotalAmount.toString());
        while (residualAmount.compareTo(BigDecimal.ZERO) > 0) {
            monthlyFees.add(new MonthlyFee(monthlyAmount, monthlyInterest));
            residualAmount = residualAmount.subtract(monthlyAmount);
        }

        return monthlyFees;
    }
}
