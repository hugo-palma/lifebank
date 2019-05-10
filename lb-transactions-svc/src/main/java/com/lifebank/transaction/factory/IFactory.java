package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.response.transactions.ProductDetailsResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.List;

public interface IFactory {
    public List<Transaction> getTransactionsDetails();
}
