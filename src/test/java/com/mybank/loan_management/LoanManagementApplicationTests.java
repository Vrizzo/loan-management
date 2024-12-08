package com.mybank.loan_management;

import com.mybank.loan_management.dto.LoanRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoanManagementApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Controller controller;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Test
    void whenWeAskForALoanWeGetOk() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoanRequest> request =
                new HttpEntity<>(new LoanRequest(), headers);
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/v1/loan", request.toString(),  String.class)).contains("Hello, World");
        ResponseEntity<String> actual = this.restTemplate.postForEntity("http://localhost:" + port + "/api/v1/loan", request.toString(),
                String.class);
        assertThat(actual).toString().contains("Hello, World");
    }
}
