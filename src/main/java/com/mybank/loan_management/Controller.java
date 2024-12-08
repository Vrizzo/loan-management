package com.mybank.loan_management;

import com.mybank.loan_management.dto.LoanRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loan")
public class Controller {

    @PostMapping
    public String createLoan(@RequestBody LoanRequest loanRequest) {
        return String.format("Hello %s", loanRequest.getFullName());
    }
}
