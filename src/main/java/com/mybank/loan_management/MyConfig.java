package com.mybank.loan_management;

import com.mybank.loan_management.core.features.CreateLoan;
import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class MyConfig {
    @Bean
    public CreateLoan createLoan(LoanRepository loanRepository) {
        return new CreateLoan(loanRepository);
    }

    @Bean
    public LoanRepository loanRepository() {
        return new InMemoryLoanRepository();
    }

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
}
