package com.lifebank.lbproductssvc.process;

import com.lifebank.lbproductssvc.factory.BankAccountFactory;
import com.lifebank.lbproductssvc.factory.CreditCardAccountFactory;
import com.lifebank.lbproductssvc.factory.LoanAccountFactory;
import com.lifebank.lbproductssvc.pojo.LbAccountCatalogPOJO;
import com.lifebank.lbproductssvc.pojo.LbBankAccountPOJO;
import com.lifebank.lbproductssvc.pojo.LbCreditCardsPOJO;
import com.lifebank.lbproductssvc.pojo.LbLoansPOJO;
import com.lifebank.lbproductssvc.pojo.response.Accounts;
import com.lifebank.lbproductssvc.pojo.response.ProductsResponse;
import com.lifebank.lbproductssvc.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ProductsProcess {
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private LoanRepository loanRepository;
    private AccountCatalogRepository accountCatalogRepository;
    private BankAccountFactory bankAccountFactory;
    private LoanAccountFactory loanAccountFactory;
    private CreditCardAccountFactory creditCardAccountFactory;

    private static final int KEY_CATALOG_BANK = 1;
    private static final int KEY_CATALOG_CREDIT_CARD = 2;
    private static final int KEY_CATALOG_LOAN = 3;

    public ProductsProcess(ClientRepository clientRepository, AccountRepository accountRepository, CardRepository cardRepository, LoanRepository loanRepository, AccountCatalogRepository accountCatalogRepository, BankAccountFactory bankAccountFactory, LoanAccountFactory loanAccountFactory, CreditCardAccountFactory creditCardAccountFactory) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.loanRepository = loanRepository;
        this.accountCatalogRepository = accountCatalogRepository;
        this.bankAccountFactory = bankAccountFactory;
        this.loanAccountFactory = loanAccountFactory;
        this.creditCardAccountFactory = creditCardAccountFactory;
    }

    public ResponseEntity process(Integer clientId){
        //Obteniendo todas la cuentas del cliente
        List<LbBankAccountPOJO> accountPOJOList = accountRepository.findAllByAccCliId(clientId);
        List<LbCreditCardsPOJO> creditCardsPOJOSList = cardRepository.findAllByCreCliId(clientId);
        List<LbLoansPOJO> loansPOJOList = loanRepository.findAllByLoaCliId(clientId);
        //Obteniendo nombres de cuentas desde tabla de catalogos
        Optional<LbAccountCatalogPOJO> accountName;
        accountName = accountCatalogRepository.findById(KEY_CATALOG_BANK);
        String personalAccountName =  accountName.isPresent()?accountName.get().getAcaName() : "";
        accountName = accountCatalogRepository.findById(KEY_CATALOG_CREDIT_CARD);
        String creditCardAccountName = accountName.isPresent()?accountName.get().getAcaName() : "";
        accountName = accountCatalogRepository.findById(KEY_CATALOG_LOAN);
        String loanAccountName = accountName.isPresent()?accountName.get().getAcaName() : "";

        //Creando objeto de respuesta
        ProductsResponse productsResponse = new ProductsResponse();
        Accounts accounts = new Accounts();

        //Creando cuentas de respuesta
        accounts.setPersonal(bankAccountFactory.getAccounts(accountPOJOList, personalAccountName));
        accounts.setCreditCard(creditCardAccountFactory.getAccounts(creditCardsPOJOSList, creditCardAccountName));
        accounts.setLoan(loanAccountFactory.getAccounts(loansPOJOList, loanAccountName));

        productsResponse.setAccounts(accounts);

        return new ResponseEntity<>(productsResponse, HttpStatus.OK);
    }
}
