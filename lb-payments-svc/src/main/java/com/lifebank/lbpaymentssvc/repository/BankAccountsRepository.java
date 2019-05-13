package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbBankAccountPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountsRepository extends JpaRepository<LbBankAccountPOJO, String> {

}
