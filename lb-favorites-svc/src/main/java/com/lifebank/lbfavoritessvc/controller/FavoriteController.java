package com.lifebank.lbfavoritessvc.controller;

import com.lifebank.lbfavoritessvc.pojo.database.LbBankAccountPOJO;
import com.lifebank.lbfavoritessvc.pojo.database.LbCreditCardsPOJO;
import com.lifebank.lbfavoritessvc.pojo.database.LbLoansPOJO;
import com.lifebank.lbfavoritessvc.pojo.request.AddFavorite;
import com.lifebank.lbfavoritessvc.pojo.request.UpdateFavoriteEmailOnly;
import com.lifebank.lbfavoritessvc.process.AddFavoriteProcess;
import com.lifebank.lbfavoritessvc.process.UpdateFavoriteProcess;
import com.lifebank.lbfavoritessvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${request-mapping.lb-favorties-svc}")
public class FavoriteController {

    private static final String KEY_CREDIT = "TARJETA_CREDITO";
    private static final String KEY_ACCOUNT = "CUENTA";
    private static final String KEY_LOAN = "PRESTAMOS";

    private FavoriteRepository favoriteRepository;
    private LoanRepository loanRepository;
    private CardsRepository cardsRepository;
    private BankAccountsRepository bankAccountsRepository;
    private ClientRepository clientRepository;
    @Autowired
    public FavoriteController(FavoriteRepository favoriteRepository, LoanRepository loanRepository, CardsRepository cardsRepository, BankAccountsRepository bankAccountsRepository, ClientRepository clientRepository) {
        this.favoriteRepository = favoriteRepository;
        this.loanRepository = loanRepository;
        this.cardsRepository = cardsRepository;
        this.bankAccountsRepository = bankAccountsRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping("${request-mapping.add-favorite}")
    public ResponseEntity addFavorite(@Valid @RequestBody AddFavorite addFavorite, @RequestHeader("clientId") String clientId){
        AddFavoriteProcess addFavoriteProcess;
        switch(addFavorite.getProductType()){
            case KEY_ACCOUNT:
                addFavoriteProcess = new AddFavoriteProcess<LbBankAccountPOJO, Integer>(favoriteRepository, bankAccountsRepository);
                break;
            case KEY_CREDIT:
                addFavoriteProcess = new AddFavoriteProcess<LbCreditCardsPOJO, Integer>(favoriteRepository, cardsRepository);
                break;
            case KEY_LOAN:
                addFavoriteProcess = new AddFavoriteProcess<LbLoansPOJO, Integer>(favoriteRepository, loanRepository);
                break;
            default:
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return addFavoriteProcess.process(addFavorite, clientId);
    }
    @PatchMapping("${request-mapping.update-favorite}")
    public ResponseEntity updateFavorite(@RequestBody UpdateFavoriteEmailOnly updateFavoriteEmailOnly,
                                         @PathVariable("beneficiaryId") String beneficiaryId,
                                         @RequestHeader("clientId")String clientId){
        updateFavoriteEmailOnly.setId(beneficiaryId);
        UpdateFavoriteProcess updateFavoriteProcess = new UpdateFavoriteProcess(favoriteRepository, clientRepository);
        return updateFavoriteProcess.process(updateFavoriteEmailOnly, clientId);
    }

}
