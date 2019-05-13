package com.lifebank.transaction.filter;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.List;

public class NoFilter implements IFilter {
    @Override
    public List<Transaction> filter(List<ITransaction> transacciones, List<Transaction> detalleTransacciones, String emitterCount) {
        return detalleTransacciones;
    }
}
