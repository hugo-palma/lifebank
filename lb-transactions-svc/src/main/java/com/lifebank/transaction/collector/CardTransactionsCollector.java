package com.lifebank.transaction.collector;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CardTransactionsCollector implements ITransactionCollector {
    @Override
    public List<ITransaction> getTransactions(String productId) {
        throw new NotImplementedException();
    }
}
