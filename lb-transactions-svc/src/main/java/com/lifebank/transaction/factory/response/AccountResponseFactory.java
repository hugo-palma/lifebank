package com.lifebank.transaction.factory.response;

import com.lifebank.transaction.pojo.database.LbBankAccountPOJO;
import com.lifebank.transaction.pojo.response.transactions.BankAccountResponse;
import com.lifebank.transaction.pojo.response.transactions.IResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class AccountResponseFactory implements IResponseFactory{
    private IResponse response;

    public void setData(JpaRepository productRepository, String productId, String startDate, String endDate, List<Transaction> transactions){
        JpaRepository bankAccountsRepository = productRepository;
        Optional<LbBankAccountPOJO> oAccount = bankAccountsRepository.findById(productId);
        if(oAccount.isPresent()){
            LbBankAccountPOJO account = oAccount.get();
            BankAccountResponse bankAccountResponse = new BankAccountResponse();
            bankAccountResponse.setId(productId);
            bankAccountResponse.setStartDate(startDate);
            bankAccountResponse.setEndDate(endDate);
            bankAccountResponse.setTransactions(transactions);
            response = bankAccountResponse;
        }
    }
    @Override
    public IResponse getResponse() {
        return response;
    }
}
