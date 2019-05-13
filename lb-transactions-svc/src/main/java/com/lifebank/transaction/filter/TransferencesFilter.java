package com.lifebank.transaction.filter;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.response.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransferencesFilter implements IFilter {
    public List<Transaction> filter(List<ITransaction> transacciones, List<Transaction> detalleTransacciones, String emitterCount){
        List<String>idsPropios = new ArrayList<>();
        List<String>idsReceptores = new ArrayList<>();
        for(ITransaction transaction : transacciones){
            if(transaction.getSender().equals(emitterCount)){
                idsPropios.add(transaction.getDetails());
            }
            else{
                idsReceptores.add(transaction.getDetails());
            }
        }
        List<Transaction>resultList = new ArrayList<>();
        for(Transaction detalles : detalleTransacciones){
            if(idsPropios.contains(detalles.getId())){
                if(detalles.getAmount() <= 0){
                    resultList.add(detalles);
                    continue;
                }
            }
            if(idsReceptores.contains(detalles.getId())){
                if(detalles.getAmount() >= 0){
                    resultList.add(detalles);
                    continue;
                }
            }
        }
        return resultList;
    }
}
