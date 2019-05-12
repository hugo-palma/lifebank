package com.lifebank.lbproductssvc.factory;

import com.lifebank.lbproductssvc.pojo.LbBankAccountPOJO;
import com.lifebank.lbproductssvc.pojo.response.Personal;

import java.util.ArrayList;
import java.util.List;

public class BankAccountFactory implements IAccountsFactory {
    public List<Personal> getAccounts(List<LbBankAccountPOJO> lbBankAccountPOJOList, String accountName){
        List<Personal> responseAccounts = new ArrayList<>();
        for(LbBankAccountPOJO bankAccountPOJO : lbBankAccountPOJOList){
            Personal personal = new Personal();
            personal.setId(bankAccountPOJO.getAccId());
            personal.setName(accountName);
            responseAccounts.add(personal);
        }
        return responseAccounts;
    }
}
