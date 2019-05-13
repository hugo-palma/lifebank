package com.lifebank.lbpaymentssvc.validator;

import com.lifebank.lbpaymentssvc.pojo.database.LbBankAccountPOJO;
import com.lifebank.lbpaymentssvc.pojo.request.RequestBlueprint;
import com.lifebank.lbpaymentssvc.pojo.request.TransferRequest;
import com.lifebank.lbpaymentssvc.repository.BankAccountsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class OwnTransferValidator implements IValidator {
    private BankAccountsRepository productsRepository;

    public OwnTransferValidator(BankAccountsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public ResponseEntity validateParameters(RequestBlueprint paymentRequest, Integer clientId) {
        TransferRequest transferRequest = (TransferRequest) paymentRequest;
        String originAccount = transferRequest.getOriginAccount();
        String destinationAccount = transferRequest.getDestinationAccount();
        if(!validateOwnership(originAccount, destinationAccount, clientId))
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        if(!validateEnoughMoney(originAccount, paymentRequest.getAmount()))
            return new ResponseEntity(HttpStatus.CONFLICT);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    private boolean validateOwnership(String originAccount, String destinationAccount, Integer clientId){
        Optional<LbBankAccountPOJO> oOrigin = productsRepository.findById(originAccount);
        Optional<LbBankAccountPOJO> oDestination = productsRepository.findById(destinationAccount);
        if(oOrigin.isPresent() && oDestination.isPresent())
        {
            if(oOrigin.get().getAccCliId().equals(clientId) &&
                    oDestination.get().getAccCliId().equals(clientId))
                return true;
        }
        return false;
    }
    private boolean validateEnoughMoney(String originAccount, Double amount){
        Optional<LbBankAccountPOJO> oOrigin = productsRepository.findById(originAccount);
        if(oOrigin.isPresent()){
            if(oOrigin.get().getAccMonto()>= amount){
                return true;
            }
        }
        return false;
    }
}
