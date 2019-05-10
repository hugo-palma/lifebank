package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.response.transactions.ProductDetailsResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.List;

public class CreditCardFactory implements IFactory {
    public List<Transaction> getTransactionsDetails(List<ITransaction> transaction) {
        return null;
    }
}
