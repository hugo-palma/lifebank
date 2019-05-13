package com.lifebank.lbpaymentssvc.pojo;

public class Response {
    private String transactionId;

    public Response(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
