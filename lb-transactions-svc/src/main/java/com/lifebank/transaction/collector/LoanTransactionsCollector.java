package com.lifebank.transaction.collector;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import com.lifebank.transaction.repository.AccountsPayLoansRepository;

import java.util.ArrayList;
import java.util.List;

public class LoanTransactionsCollector implements ITransactionCollector {
    private AccountsPayLoansRepository accountsPayLoansRepository;
    public LoanTransactionsCollector(AccountsPayLoansRepository accountsPayLoansRepository){
        this.accountsPayLoansRepository = accountsPayLoansRepository;
    }
    @Override
    public List<ITransaction> getTransactions(String productId) {
        return accountsPayLoansRepository.findPaymentsByLoanId(productId);
    }
}
