package com.lifebank.lbproductssvc.controller;

import com.lifebank.lbproductssvc.factory.BankAccountFactory;
import com.lifebank.lbproductssvc.factory.CreditCardAccountFactory;
import com.lifebank.lbproductssvc.factory.LoanAccountFactory;
import com.lifebank.lbproductssvc.process.ProductsProcess;
import com.lifebank.lbproductssvc.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${request-mapping.lb-products-svc}")
public class ProductsController {
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private LoanRepository loanRepository;
    private AccountCatalogRepository accountCatalogRepository;
    private BankAccountFactory bankAccountFactory;
    private LoanAccountFactory loanAccountFactory;
    private CreditCardAccountFactory creditCardAccountFactory;

    public ProductsController(ClientRepository clientRepository, AccountRepository accountRepository, CardRepository cardRepository, LoanRepository loanRepository, AccountCatalogRepository accountCatalogRepository) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.loanRepository = loanRepository;
        this.accountCatalogRepository = accountCatalogRepository;
    }

    @GetMapping("${request-mapping.get-products}")
    public ResponseEntity getClientProducts(@PathVariable("clientId") Integer clientId){
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        CreditCardAccountFactory creditCardAccountFactory = new CreditCardAccountFactory();
        LoanAccountFactory loanAccountFactory = new LoanAccountFactory();
        ProductsProcess productsProcess = new ProductsProcess(clientRepository, accountRepository, cardRepository, loanRepository, accountCatalogRepository, bankAccountFactory, loanAccountFactory, creditCardAccountFactory);
        return productsProcess.process(clientId);
    }
}
