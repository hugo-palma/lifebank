package com.lifebank.transaction.collector;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;

import java.util.List;

public interface ITransactionCollector {
    public List<ITransaction> getTransactions(String productId);
}
