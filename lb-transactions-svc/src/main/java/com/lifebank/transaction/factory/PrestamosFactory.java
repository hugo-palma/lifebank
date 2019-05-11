package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbLoanPaymentsDetailsPOJO;
import com.lifebank.transaction.pojo.response.transactions.PrestamoTransaction;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import com.lifebank.transaction.repository.LoanPaymentsDetailsRepository;

import java.util.ArrayList;
import java.util.List;

public class PrestamosFactory implements IFactory {
    private LoanPaymentsDetailsRepository loanPaymentsDetailsRepository;
    public PrestamosFactory(LoanPaymentsDetailsRepository loanPaymentsDetailsRepository) {
        this.loanPaymentsDetailsRepository = loanPaymentsDetailsRepository;
    }

    public List<Transaction> getTransactionsDetails(List<ITransaction> transactions){

        List<Integer> detailsIdList = new ArrayList<>();
        for(ITransaction transaction : transactions){
            Integer id = Integer.parseInt(transaction.getDetails());
            detailsIdList.add(id);
        }
        List<LbLoanPaymentsDetailsPOJO> paymentsPOJOList = loanPaymentsDetailsRepository.findAllById(detailsIdList);
        return createTransactionsDetails(paymentsPOJOList);
    }
    private List<Transaction> createTransactionsDetails(List<LbLoanPaymentsDetailsPOJO> detailPOJOList){
        List<Transaction> transactionList = new ArrayList<>();
        for(LbLoanPaymentsDetailsPOJO detailPOJO: detailPOJOList){
            PrestamoTransaction prestamoTransaction = new PrestamoTransaction();
            prestamoTransaction.setId(detailPOJO.getLpdAuthorizationNumber());
            prestamoTransaction.setAmount(detailPOJO.getLpdPaymentAmount());
            prestamoTransaction.setDate(detailPOJO.getLpdPaymentDate().toString());
            prestamoTransaction.setDescription(detailPOJO.getLpdDescription());
            transactionList.add(prestamoTransaction);
        }
        return transactionList;
    }
}
