package com.lifebank.lbpaymentssvc.payment;

import org.springframework.http.ResponseEntity;

public interface TransactionFactory {
    ResponseEntity makeTransaction(String origin, String destination, Double amount, Integer clientId, String ip);
}
