package com.mybank.loan_management;

import com.mybank.loan_management.core.model.Loan;
import com.mybank.loan_management.dto.LoanRequest;
import com.mybank.loan_management.dto.LoanResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;


import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanManagementApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Test
    void whenWeAskForALoanWeGetOk() {
        LoanRequest loanRequest = new LoanRequest(new BigDecimal(100), 15, "Paul Gilbert", "939394003");

        HttpEntity<Object> request = getHttpEntityRequest(loanRequest);

        LoanResponse actual = this.restTemplate.postForObject("http://localhost:" + port + "/api/v1/loan", request, LoanResponse.class);
        assertThat (actual, is(notNullValue()));
        assertThat(actual.getLoan().getMonthlyFees(), is(hasSize(15)));
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/loan/" + loanRequest.getPersonalId(), String.class);
        assertThat(response, is(equalTo("1 Loan by Paul Gilbert")));

    }

    private static HttpEntity<Object> getHttpEntityRequest(Object loanRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(loanRequest, headers);
    }
}
