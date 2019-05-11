package com.lifebank.transaction.factory.response;

import com.lifebank.transaction.pojo.database.LbBankAccountPOJO;
import com.lifebank.transaction.pojo.database.LbLoansPOJO;
import com.lifebank.transaction.pojo.response.transactions.IResponse;
import com.lifebank.transaction.pojo.response.transactions.LoanResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class LoanResponseFactory implements IResponseFactory {
    private IResponse response;

    public void setData(JpaRepository productRepository, String productId, String startDate, String endDate, List<Transaction> transactions){
        JpaRepository bankAccountsRepository = productRepository;
        Optional<LbLoansPOJO> oLoan = bankAccountsRepository.findById(productId);
        if(oLoan.isPresent()){
            LbLoansPOJO loan = oLoan.get();
            LoanResponse loanResponse = new LoanResponse();
            loanResponse.setId(productId);
            loanResponse.setStartDate(startDate);
            loanResponse.setEndDate(endDate);
            loanResponse.setTransactions(transactions);
            loanResponse.setDebt(loan.getLoaDebt());
            loanResponse.setInterestAmount(loan.getLoaInterestAmount());
            loanResponse.setInterestRate(loan.getLoaInterestRate());
            loanResponse.setTotal(loan.getLoaTotalAmount());
            response = loanResponse;
        }
    }
    @Override
    public IResponse getResponse() {
        return response;
    }
}
