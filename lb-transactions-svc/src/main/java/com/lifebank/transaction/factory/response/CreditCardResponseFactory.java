package com.lifebank.transaction.factory.response;

import com.lifebank.transaction.pojo.database.LbCreditCardsPOJO;
import com.lifebank.transaction.pojo.response.transactions.CreditCardResponse;
import com.lifebank.transaction.pojo.response.transactions.IResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class CreditCardResponseFactory implements IResponseFactory {
    private IResponse response;
    @Override
    public void setData(JpaRepository productRepository, String productId, String startDate, String endDate, List<Transaction> transactions) {
        JpaRepository cardsRepository = productRepository;
        Optional<LbCreditCardsPOJO> oCard = cardsRepository.findById(productId);
        if(oCard.isPresent()){
            LbCreditCardsPOJO card = oCard.get();
            CreditCardResponse bankAccountResponse = new CreditCardResponse();
            bankAccountResponse.setId(productId);
            bankAccountResponse.setStartDate(startDate);
            bankAccountResponse.setEndDate(endDate);
            bankAccountResponse.setTransactions(transactions);
            bankAccountResponse.setAvailable(card.getCreAmountAvailable());
            bankAccountResponse.setInterestAmount(card.getCreInterestAccumulated());
            bankAccountResponse.setLimit(card.getCreAmountLimit());
            bankAccountResponse.setMonthlyCut(card.getCreCutDay());
            response = bankAccountResponse;
        }
    }

    @Override
    public IResponse getResponse() {
        return response;
    }
}
