package com.mybank.loan_management;

import com.mybank.loan_management.core.features.CreateLoan;
import com.mybank.loan_management.core.model.Loan.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;
import com.mybank.loan_management.dto.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loan")
public class Controller {

    @Autowired
    private CreateLoan createLoan;

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping
    public String createLoan(@RequestBody LoanRequest loanRequest) {

        createLoan.crate(loanRequest);
        return String.format("Hello %s", loanRequest.getFullName());
    }

    @GetMapping("/{personalId}")
    public String getLoan(@PathVariable String personalId) {

        Loan loan = loanRepository.getById(personalId);
        return String.format("1 Loan by %s", loan.getFullName());
    }
}
