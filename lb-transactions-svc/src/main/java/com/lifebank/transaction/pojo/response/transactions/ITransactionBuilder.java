package com.lifebank.transaction.pojo.response.transactions;

public interface ITransactionBuilder {
    public void setTransactionDetails(Transaction transaction, String id, String date, String description, String amount);

}
