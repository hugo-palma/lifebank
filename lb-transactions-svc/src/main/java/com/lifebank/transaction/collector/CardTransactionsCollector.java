package com.lifebank.transaction.collector;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.repository.CardPaymentsRepository;

import java.util.List;

public class CardTransactionsCollector implements ITransactionCollector {
    private CardPaymentsRepository cardPaymentsRepository;
    public CardTransactionsCollector(CardPaymentsRepository cardPaymentsRepository){
        this.cardPaymentsRepository = cardPaymentsRepository;
    }
    @Override
    public List<ITransaction> getTransactions(String productId) {
        Integer cardId = Integer.parseInt(productId);
        cardPaymentsRepository.findPaymentsByCardId(cardId);
        return cardPaymentsRepository.findPaymentsByCardId(cardId);
    }
}
