package com.mybank.loan_management;

import com.mybank.loan_management.dto.LoanRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.math.BigDecimal;


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

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/v1/loan", request, String.class)).contains("Hello Paul Gilbert");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/loan/" + loanRequest.getPersonalId(), String.class)).contains("1 Loan by Paul Gilbert");

    }

    private static HttpEntity<Object> getHttpEntityRequest(Object loanRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(loanRequest, headers);
    }
}
