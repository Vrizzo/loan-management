package com.mybank.loan_management.core.services;

import com.mybank.loan_management.core.model.MonthlyFee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RatePlanCalculatorTest {
    @Test
    void singleMonthLoanZeroRate() {
        RatePlanCalculator ratePlanCalculator = new RatePlanCalculator(0);
        List<MonthlyFee> monthlyFees = ratePlanCalculator.calculateRatePlan(new BigDecimal(100), 1);
        assertThat(monthlyFees, is(notNullValue()));
        assertThat(monthlyFees.get(0), is(equalTo(new MonthlyFee(new BigDecimal(100), BigDecimal.ZERO))));
    }

    @Test
    void singleMonthLoan5PercentageInterestRate() {
        RatePlanCalculator ratePlanCalculator = new RatePlanCalculator(5);
        List<MonthlyFee> monthlyFees = ratePlanCalculator.calculateRatePlan(new BigDecimal(100), 1);
        assertThat(monthlyFees, is(notNullValue()));
        assertThat(monthlyFees.get(0), is(equalTo(new MonthlyFee(new BigDecimal(105), new BigDecimal(5)))));
        assertThat(monthlyFees.get(0).getCapitalQuote(), is(equalTo(new BigDecimal(100))));
    }

    @Test
    void multipleMonthsLoan5PercentageInterestRate() {
        RatePlanCalculator ratePlanCalculator = new RatePlanCalculator(5);
        int term = 3;
        List<MonthlyFee> monthlyFees = ratePlanCalculator.calculateRatePlan(new BigDecimal(300), term);
        assertThat(monthlyFees, is(notNullValue()));
        assertThat(monthlyFees.size(), is(equalTo(term)));
        assertThat(monthlyFees.get(0), is(equalTo(new MonthlyFee(new BigDecimal(105), new BigDecimal(5)))));
        assertThat(monthlyFees.get(1), is(equalTo(new MonthlyFee(new BigDecimal(105), new BigDecimal(5)))));
        assertThat(monthlyFees.get(2), is(equalTo(new MonthlyFee(new BigDecimal(105), new BigDecimal(5)))));
    }
}