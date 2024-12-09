package com.mybank.loan_management.core.features;


import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;
import com.mybank.loan_management.dto.LoanRequest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.hamcrest.MatcherAssert.assertThat;

class CreateLoanTest
{
    @Test
    void crate()
    {
        LoanRepository loanRepository = new InMemoryLoanRepository();
        CreateLoan createLoan = new CreateLoan(loanRepository);
        LoanRequest loanRequest = new LoanRequest(new BigDecimal(100), 36, "John Doe", "123456789");
        createLoan.crate(loanRequest);
        Loan actualLoan = loanRepository.getById(loanRequest.getPersonalId());
        assertThat(actualLoan.getPersonalId(), Is.is(loanRequest.getPersonalId()));
    }

}