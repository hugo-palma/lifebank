package com.lifebank.lbpaymentssvc.controller;

import com.lifebank.lbpaymentssvc.authorization.AuthorizationBean;
import com.lifebank.lbpaymentssvc.payment.OwnTransferFactory;
import com.lifebank.lbpaymentssvc.pojo.request.TransferRequest;
import com.lifebank.lbpaymentssvc.process.OwnTransferProcess;
import com.lifebank.lbpaymentssvc.repository.BankAccountsRepository;
import com.lifebank.lbpaymentssvc.repository.TransferenceDetailsRepository;
import com.lifebank.lbpaymentssvc.repository.TransferencesRepository;
import com.lifebank.lbpaymentssvc.validator.OwnTransferValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request-mapping.lb-payments-svc.own}")
public class PaymentsController {
    private BankAccountsRepository bankAccountsRepository;
    private TransferencesRepository transferencesRepository;
    private TransferenceDetailsRepository transferenceDetailsRepository;
    private AuthorizationBean authorizationBean;

    public PaymentsController(BankAccountsRepository bankAccountsRepository, TransferencesRepository transferencesRepository, TransferenceDetailsRepository transferenceDetailsRepository, AuthorizationBean authorizationBean) {
        this.bankAccountsRepository = bankAccountsRepository;
        this.transferencesRepository = transferencesRepository;
        this.transferenceDetailsRepository = transferenceDetailsRepository;
        this.authorizationBean = authorizationBean;
    }

    @PostMapping("${request-mapping.transfer}")
    public ResponseEntity transferOwn(@RequestBody TransferRequest transferRequest,
                                      @RequestHeader("clientId")Integer clientId,
                                      @RequestHeader("ip") String ip){
        OwnTransferValidator ownTransferValidator = new OwnTransferValidator(bankAccountsRepository);
        OwnTransferFactory ownTransferFactory = new OwnTransferFactory(bankAccountsRepository, transferencesRepository, transferenceDetailsRepository, authorizationBean);
        OwnTransferProcess ownTransferProcess = new OwnTransferProcess(ownTransferValidator, ownTransferFactory);
        return ownTransferProcess.process(transferRequest, clientId, ip);
    }
}
