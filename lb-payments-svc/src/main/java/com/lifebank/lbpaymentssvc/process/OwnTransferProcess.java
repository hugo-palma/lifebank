package com.lifebank.lbpaymentssvc.process;

import com.lifebank.lbpaymentssvc.payment.TransactionFactory;
import com.lifebank.lbpaymentssvc.pojo.request.RequestBlueprint;
import com.lifebank.lbpaymentssvc.validator.IValidator;
import org.springframework.http.ResponseEntity;

public class OwnTransferProcess {
    IValidator validator;
    TransactionFactory transactionFactory;


    public OwnTransferProcess(IValidator validator, TransactionFactory transactionFactory) {
        this.validator = validator;
        this.transactionFactory = transactionFactory;
    }

    public ResponseEntity process(RequestBlueprint requestBlueprint, Integer clientId, String ip){
        ResponseEntity validationResponse = validator.validateParameters(requestBlueprint, clientId);
        if(!validationResponse.getStatusCode().is2xxSuccessful())
        {
            //si la validacion no es exitosa response codigo de error personalizado
            return validationResponse;
        }
        return transactionFactory.makeTransaction(requestBlueprint.getOriginAccount(), requestBlueprint.getDestinationAccount(), requestBlueprint.getAmount(), clientId, ip);
    }

}
