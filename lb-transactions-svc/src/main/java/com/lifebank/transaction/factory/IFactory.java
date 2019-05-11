package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.List;

public interface IFactory {
    public List<Transaction> getTransactionsDetails(List<ITransaction> transaction);
}
