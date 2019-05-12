package com.lifebank.lbproductssvc.factory;

import com.lifebank.lbproductssvc.pojo.LbLoansPOJO;
import com.lifebank.lbproductssvc.pojo.response.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanAccountFactory implements IAccountsFactory {
    public List<Loan> getAccounts(List<LbLoansPOJO> LbLoansPOJOList, String accountName){
        List<Loan> responseAccounts = new ArrayList<>();
        for(LbLoansPOJO loansPOJO : LbLoansPOJOList){
            Loan loan = new Loan();
            loan.setId(loansPOJO.getLoaId().toString());
            loan.setName(accountName);
            responseAccounts.add(loan);
        }
        return responseAccounts;
    }
}
