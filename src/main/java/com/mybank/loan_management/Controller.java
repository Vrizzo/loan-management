package com.mybank.loan_management;

import com.mybank.loan_management.core.features.CreateLoan;
import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.core.repository.LoanRepository;
import com.mybank.loan_management.dto.LoanRequest;
import com.mybank.loan_management.dto.LoanResponse;
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
    public LoanResponse createLoan(@RequestBody LoanRequest loanRequest) {
        return createLoan.crate(loanRequest);
    }

    @GetMapping("/{personalId}")
    public String getLoan(@PathVariable String personalId) {

        Loan loan = loanRepository.getById(personalId);
        return String.format("1 Loan by %s", loan.getFullName());
    }
}
