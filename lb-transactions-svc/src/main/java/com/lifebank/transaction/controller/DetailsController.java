package com.lifebank.transaction.controller;

import com.lifebank.transaction.collector.AccountTransactionsCollector;
import com.lifebank.transaction.collector.CardTransactionsCollector;
import com.lifebank.transaction.collector.ITransactionCollector;
import com.lifebank.transaction.collector.LoanTransactionsCollector;
import com.lifebank.transaction.factory.CreditCardFactory;
import com.lifebank.transaction.factory.IFactory;
import com.lifebank.transaction.factory.AccountFactory;
import com.lifebank.transaction.factory.PrestamosFactory;
import com.lifebank.transaction.factory.response.AccountResponseFactory;
import com.lifebank.transaction.factory.response.CreditCardResponseFactory;
import com.lifebank.transaction.factory.response.IResponseFactory;
import com.lifebank.transaction.factory.response.LoanResponseFactory;
import com.lifebank.transaction.filter.IFilter;
import com.lifebank.transaction.filter.NoFilter;
import com.lifebank.transaction.filter.TransferencesFilter;
import com.lifebank.transaction.process.DetailsProcess;
import com.lifebank.transaction.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request-mapping.transactions-svc}")
public class DetailsController {
    private BankAccountsRepository bankAccountsRepository;
    private AccountsPayLoansRepository accountsPayLoansRepository;
    private AccountsPayCardsRepository accountsPayCardsRepository;
    private TransferenceDetailsRepository transferenceDetailsRepository;
    private TransferencesRepository transferencesRepository;
    private LoanPaymentsDetailsRepository loanPaymentsDetailsRepository;
    private CardPaymentsRepository cardPaymentsRepository;
    private CardsRepository cardsRepository;
    private LoanRepository loanRepository;
    private Environment env;

    @Autowired
    public DetailsController(BankAccountsRepository bankAccountsRepository,
                             AccountsPayLoansRepository accountsPayLoansRepository,
                             AccountsPayCardsRepository accountsPayCardsRepository,
                             TransferenceDetailsRepository transferenceDetailsRepository,
                             TransferencesRepository transferencesRepository,
                             LoanPaymentsDetailsRepository loanPaymentsDetailsRepository,
                             LoanRepository loanRepository,
                             CardPaymentsRepository cardPaymentsRepository,
                             CardsRepository cardsRepository,
                             Environment env) {
        this.bankAccountsRepository = bankAccountsRepository;
        this.accountsPayLoansRepository = accountsPayLoansRepository;
        this.accountsPayCardsRepository = accountsPayCardsRepository;
        this.transferenceDetailsRepository = transferenceDetailsRepository;
        this.transferencesRepository = transferencesRepository;
        this.loanPaymentsDetailsRepository = loanPaymentsDetailsRepository;
        this.loanRepository = loanRepository;
        this.cardPaymentsRepository = cardPaymentsRepository;
        this.cardsRepository = cardsRepository;
        this.env = env;
    }

    private static final String KEY_CREDIT = "TARJETA_CREDITO";
    private static final String KEY_ACCOUNT = "CUENTA";
    private static final String KEY_LOAN = "PRESTAMOS";


    @GetMapping("${request-mapping.details}")
    public ResponseEntity getProductDetails(@PathVariable("accountID") String accountID,
                                            @RequestParam("start") String startDate,
                                            @RequestParam("end") String endDate,
                                            @RequestParam("prd") String prd){
        DetailsProcess detailsProcess;
        ITransactionCollector iTransactionCollector;
        IFactory factory;
        IResponseFactory responseFactory;
        JpaRepository productRepository;
        IFilter iFilter;
        switch (prd){
            case KEY_CREDIT:
                iTransactionCollector = new CardTransactionsCollector(cardPaymentsRepository);
                factory = new CreditCardFactory();
                responseFactory = new CreditCardResponseFactory();
                productRepository = cardsRepository;
                iFilter = new NoFilter();
                break;
            case KEY_LOAN:
                iTransactionCollector = new LoanTransactionsCollector(accountsPayLoansRepository);
                factory = new PrestamosFactory(loanPaymentsDetailsRepository);
                responseFactory = new LoanResponseFactory();
                productRepository = loanRepository;
                iFilter = new NoFilter();
                break;
            case KEY_ACCOUNT:
                iTransactionCollector = new AccountTransactionsCollector(transferencesRepository, accountsPayLoansRepository, accountsPayCardsRepository);
                factory = new AccountFactory(env, transferenceDetailsRepository);
                responseFactory = new AccountResponseFactory();
                productRepository = bankAccountsRepository;
                iFilter = new TransferencesFilter();
                break;
            default:
                return new ResponseEntity<>("No existe Producto", HttpStatus.BAD_REQUEST);

        }
        detailsProcess = new DetailsProcess(productRepository, iTransactionCollector, factory, responseFactory, iFilter);
        return detailsProcess.process(accountID, startDate, endDate);
    }
}
