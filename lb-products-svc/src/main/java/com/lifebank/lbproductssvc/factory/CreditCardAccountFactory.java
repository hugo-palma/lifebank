package com.lifebank.lbproductssvc.factory;

import com.lifebank.lbproductssvc.pojo.LbCreditCardsPOJO;
import com.lifebank.lbproductssvc.pojo.response.CreditCard;
import com.lifebank.lbproductssvc.repository.AccountCatalogRepository;

import java.util.ArrayList;
import java.util.List;

public class CreditCardAccountFactory implements IAccountsFactory {


    public List<CreditCard> getAccounts(List<LbCreditCardsPOJO> creditCardsPOJOList, String accountName){
        List<CreditCard> responseAccounts = new ArrayList<>();
        for(LbCreditCardsPOJO creditCardsPOJO : creditCardsPOJOList){
            CreditCard creditCard = new CreditCard();
            creditCard.setId(creditCardsPOJO.getCreId().toString());
            creditCard.setName(accountName);
            responseAccounts.add(creditCard);
        }
        return responseAccounts;
    }
}
