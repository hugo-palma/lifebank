package com.lifebank.transaction.factory;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbTransferencesDetailPOJO;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import com.lifebank.transaction.pojo.response.transactions.TransferenceTransaction;
import com.lifebank.transaction.repository.TransferenceDetailsRepository;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

public class AccountFactory implements IFactory {
    private TransferenceDetailsRepository transferenceDetailsRepository;
    private Environment env;

    public AccountFactory(Environment env, TransferenceDetailsRepository transferenceDetailsRepository){
        this.env = env;
        this.transferenceDetailsRepository = transferenceDetailsRepository;
    }

    public List<Transaction> getTransactionsDetails(List<ITransaction> transferenceTransaction){
        List<Integer> idTransactionsList = new ArrayList<>();
        for(ITransaction transaction : transferenceTransaction){
            String idDetalle = transaction.getDetails();
            int idTransferencia = Integer.parseInt(idDetalle);
            idTransactionsList.add(idTransferencia);
        }
        List<LbTransferencesDetailPOJO> detailPOJOList = transferenceDetailsRepository.findAllById(idTransactionsList);
        return createTransactionsDetails(detailPOJOList);
    }
    private List<Transaction> createTransactionsDetails(List<LbTransferencesDetailPOJO> detailPOJOList){
        List<Transaction> transactionList = new ArrayList<>();
        for(LbTransferencesDetailPOJO detailPOJO: detailPOJOList){
            TransferenceTransaction transferenceTransaction = new TransferenceTransaction();
            transferenceTransaction.setId(detailPOJO.getDtrAuthorizationNumber());
            transferenceTransaction.setAmount(detailPOJO.getDtrAmountTransfered());
            transferenceTransaction.setDate(detailPOJO.getDtrTransferDate().toString());
            transferenceTransaction.setDescription(detailPOJO.getDtrDescription());
            transactionList.add(transferenceTransaction);
        }
        return transactionList;
    }
}
