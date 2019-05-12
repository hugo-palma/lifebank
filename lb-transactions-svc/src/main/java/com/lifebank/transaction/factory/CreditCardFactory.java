package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbCardPaymentsPOJO;
import com.lifebank.transaction.pojo.database.LbLoanPaymentsDetailsPOJO;
import com.lifebank.transaction.pojo.response.transactions.PrestamoTransaction;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CreditCardFactory implements IFactory {
    public List<Transaction> getTransactionsDetails(List<ITransaction> transactions) {
        return createTransactionsDetails(transactions);
    }
    private List<Transaction> createTransactionsDetails(List<ITransaction> detailPOJOList){
        List<LbCardPaymentsPOJO> paymentsList = new ArrayList<>();
        for(ITransaction transaction: detailPOJOList){
            LbCardPaymentsPOJO paymentsPOJO = (LbCardPaymentsPOJO) transaction;
            paymentsList.add(paymentsPOJO);
        }
        List<Transaction> transactionList = new ArrayList<>();
        for(LbCardPaymentsPOJO detailPOJO: paymentsList){
            PrestamoTransaction prestamoTransaction = new PrestamoTransaction();
            prestamoTransaction.setId(detailPOJO.getCpaAuthorizationNumber());
            prestamoTransaction.setAmount(detailPOJO.getCpaPaymentAmount());
            prestamoTransaction.setDate(detailPOJO.getCpaPaymentDate().toString());
            prestamoTransaction.setDescription(detailPOJO.getCpaPaymentDescription());
            transactionList.add(prestamoTransaction);
        }
        return transactionList;
    }
}
