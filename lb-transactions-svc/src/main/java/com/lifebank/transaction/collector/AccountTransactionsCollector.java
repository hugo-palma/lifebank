package com.lifebank.transaction.collector;

import com.lifebank.transaction.pojo.database.*;
import com.lifebank.transaction.repository.AccountsPayCardsRepository;
import com.lifebank.transaction.repository.AccountsPayLoansRepository;
import com.lifebank.transaction.repository.TransaccionesRepository;
import com.lifebank.transaction.repository.TransferencesRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactionsCollector implements ITransactionCollector {
    private TransferencesRepository transferencesRepository;
    private AccountsPayLoansRepository accountsPayLoansRepository;
    private AccountsPayCardsRepository accountsPayCardsRepository;
    public AccountTransactionsCollector(TransferencesRepository transferencesRepository, AccountsPayLoansRepository accountsPayLoansRepository, AccountsPayCardsRepository accountsPayCardsRepository){
        this.transferencesRepository = transferencesRepository;
        this.accountsPayLoansRepository = accountsPayLoansRepository;
        this.accountsPayCardsRepository = accountsPayCardsRepository;
    }
    @Override
    public List<ITransaction> getTransactions(String productId) {
        List<ITransaction> transactionsList = new ArrayList<>();
        TransaccionesRepository<LbTransferencesPOJO, LbTransferencesPOJOPK> transferTransactionsRepository = transferencesRepository;
        transactionsList.addAll(transferTransactionsRepository.findTransaccionesOfProduct(productId));
        TransaccionesRepository<LbAccountLoanPaymentsPOJO ,LbAccountLoanPaymentsPOJOPK> loansTransactionsRepository = accountsPayLoansRepository;
        transactionsList.addAll(loansTransactionsRepository.findTransaccionesOfProduct(productId));
        TransaccionesRepository<LbAccountCreditcardPaymentsPOJO, LbAccountCreditcardPaymentsPOJOPK> cardsTransactionsRepository = accountsPayCardsRepository;
        transactionsList.addAll(cardsTransactionsRepository.findTransaccionesOfProduct(productId));
        return transactionsList;
    }
}
