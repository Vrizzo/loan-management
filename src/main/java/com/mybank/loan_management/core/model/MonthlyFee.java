package com.mybank.loan_management.core.model;

import java.math.BigDecimal;
import java.util.Objects;

public class MonthlyFee {
    private final BigDecimal amount;
    private final BigDecimal interestQuotaAmount;

    public MonthlyFee(BigDecimal amount, BigDecimal interestQuotaAmount) {
        this.amount = amount;
        this.interestQuotaAmount = interestQuotaAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getInterestQuotaAmount() {
        return interestQuotaAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MonthlyFee that = (MonthlyFee) o;
        return Objects.equals(amount, that.amount) && Objects.equals(interestQuotaAmount, that.interestQuotaAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, interestQuotaAmount);
    }

    public BigDecimal getCapitalQuote() {
        return amount.subtract(interestQuotaAmount);
    }

    @Override
    public String toString() {
        return "MonthlyFee{" +
                "amount=" + amount +
                ", interestQuotaAmount=" + interestQuotaAmount +
                '}';
    }
}
