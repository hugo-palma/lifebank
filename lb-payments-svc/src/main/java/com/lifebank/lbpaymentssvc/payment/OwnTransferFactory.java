package com.lifebank.lbpaymentssvc.payment;

import com.lifebank.lbpaymentssvc.authorization.AuthorizationBean;
import com.lifebank.lbpaymentssvc.pojo.Response;
import com.lifebank.lbpaymentssvc.pojo.database.LbBankAccountPOJO;
import com.lifebank.lbpaymentssvc.pojo.database.LbTransferencesDetailPOJO;
import com.lifebank.lbpaymentssvc.pojo.database.LbTransferencesPOJO;
import com.lifebank.lbpaymentssvc.repository.BankAccountsRepository;
import com.lifebank.lbpaymentssvc.repository.TransferenceDetailsRepository;
import com.lifebank.lbpaymentssvc.repository.TransferencesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.Optional;

public class OwnTransferFactory implements TransactionFactory {
    private BankAccountsRepository bankAccountsRepository;
    private TransferencesRepository transferencesRepository;
    private TransferenceDetailsRepository transferenceDetailsRepository;
    private AuthorizationBean authorizationBean;

    public OwnTransferFactory(BankAccountsRepository bankAccountsRepository, TransferencesRepository transferencesRepository, TransferenceDetailsRepository transferenceDetailsRepository, AuthorizationBean authorizationBean) {
        this.bankAccountsRepository = bankAccountsRepository;
        this.transferencesRepository = transferencesRepository;
        this.transferenceDetailsRepository = transferenceDetailsRepository;
        this.authorizationBean = authorizationBean;
    }

    public ResponseEntity makeTransaction(String origin, String destination, Double amount, Integer clientId, String ip){
        Optional<LbBankAccountPOJO> oOrigin = bankAccountsRepository.findById(origin);
        Optional<LbBankAccountPOJO> oDestination = bankAccountsRepository.findById(destination);
        if(oOrigin.isPresent() && oDestination.isPresent()){
            //Moviendo dinero de cuentas
            Double originAmount = oOrigin.get().getAccMonto();
            Double destinationAmount = oDestination.get().getAccMonto();
            originAmount -= amount;
            destinationAmount += amount;
            oOrigin.get().setAccMonto(originAmount);
            oDestination.get().setAccMonto(destinationAmount);
            bankAccountsRepository.save(oOrigin.get());
            bankAccountsRepository.save(oDestination.get());
            //Guardando evidencia en tabla de detalle tener
            LbTransferencesDetailPOJO detailPOJO = new LbTransferencesDetailPOJO();
            detailPOJO.setDtrAmountTransfered(-amount);
            String authorizationNumber = String.valueOf(authorizationBean.getAuthorizationNumber(clientId, ip));
            detailPOJO.setDtrAuthorizationNumber(authorizationNumber);
            detailPOJO.setDtrDescription("Transferencia");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            detailPOJO.setDtrTransferDate(timestamp);
            detailPOJO = transferenceDetailsRepository.save(detailPOJO);
            //Creando detalle de haber
            LbTransferencesDetailPOJO haberDetailPojo = new LbTransferencesDetailPOJO();
            haberDetailPojo.setDtrAmountTransfered(amount);
            haberDetailPojo.setDtrAuthorizationNumber(authorizationNumber);
            haberDetailPojo.setDtrDescription("Transferencia");
            haberDetailPojo.setDtrTransferDate(timestamp);
            haberDetailPojo = transferenceDetailsRepository.save(haberDetailPojo);

            Integer tenerDetalleId = detailPOJO.getDtrId();
            Integer haberDetalleId = haberDetailPojo.getDtrId();

            //guardando evidencia en tabla de transferencias de haber
            LbTransferencesPOJO lbTransferencesPOJO = new LbTransferencesPOJO();
            lbTransferencesPOJO.setTraDtrId(tenerDetalleId);
            lbTransferencesPOJO.setTraEmitterAccount(oOrigin.get().getAccId());
            lbTransferencesPOJO.setTraReceiverAccount(oDestination.get().getAccId());
            transferencesRepository.save(lbTransferencesPOJO);
            //guardando evidencia en tabla de transferencias de tener
            lbTransferencesPOJO = new LbTransferencesPOJO();
            lbTransferencesPOJO.setTraDtrId(haberDetalleId);
            lbTransferencesPOJO.setTraEmitterAccount(oOrigin.get().getAccId());
            lbTransferencesPOJO.setTraReceiverAccount(oDestination.get().getAccId());
            transferencesRepository.save(lbTransferencesPOJO);

            return new ResponseEntity<>(new Response(authorizationNumber), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
