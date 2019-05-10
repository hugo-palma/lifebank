package com.lifebank.transaction.controller;

import com.lifebank.transaction.factory.IFactory;
import com.lifebank.transaction.factory.TransferenciasFactory;
import com.lifebank.transaction.pojo.database.LbTransferencesI;
import com.lifebank.transaction.process.DetailsProcess;
import com.lifebank.transaction.repository.BankAccountsRepository;
import com.lifebank.transaction.repository.TransferenceDetailsRepository;
import com.lifebank.transaction.repository.TransferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request-mapping.transactions-svc}")
public class DetailsController {
    @Autowired BankAccountsRepository bankAccountsRepository;
    @Autowired TransferenceDetailsRepository transferenceDetailsRepository;
    @Autowired TransferencesRepository transferencesRepository;
    @Autowired Environment env;

    public static final String KEY_CREDIT = "TARJETA_CREDITO";
    public static final String KEY_TRANSFERENCES = "TRANSFERENCIAS";
    public static final String KEY_LOAN = "PRESTAMOS";


    @GetMapping("${request-mapping.details}")
    public ResponseEntity getProductDetails(@PathVariable("accountID") String accountID,
                                            @RequestParam("start") String startDate,
                                            @RequestParam("end") String endDate,
                                            @RequestParam("prd") String prd){
        DetailsProcess<LbTransferencesI> detailsProcess;
        IFactory factory;
        switch (prd){
            case KEY_CREDIT:
                //TODO:Cambiar repositorio
                factory = new TransferenciasFactory(env, transferenceDetailsRepository);
                detailsProcess = new DetailsProcess<>(env, bankAccountsRepository, transferenceDetailsRepository, transferencesRepository, factory);
                break;
            case KEY_LOAN:
                //TODO:Cambiar repositorio
                factory = new TransferenciasFactory(env, transferenceDetailsRepository);
                detailsProcess = new DetailsProcess<>(env, bankAccountsRepository, transferenceDetailsRepository, transferencesRepository, factory);
                break;
            case KEY_TRANSFERENCES:
                //TODO:Cambiar repositorio
                factory = new TransferenciasFactory(env, transferenceDetailsRepository);
                detailsProcess = new DetailsProcess<>(env, bankAccountsRepository, transferenceDetailsRepository, transferencesRepository, factory);
                break;
            default:
                return new ResponseEntity<>("No existe Producto", HttpStatus.BAD_REQUEST);

        }
        return detailsProcess.process(accountID);
    }
}
