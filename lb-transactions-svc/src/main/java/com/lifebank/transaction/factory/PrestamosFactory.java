package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.response.transactions.ProductDetailsResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import com.lifebank.transaction.pojo.response.transactions.TransferenceTransaction;

import java.util.ArrayList;
import java.util.List;

public class PrestamosFactory implements IFactory {
    public List<Transaction> getTransactionsDetails(){
        ArrayList<Transaction> misTransacciones = new ArrayList<>();
        misTransacciones.add(new TransferenceTransaction());
        return null;
    }
}
