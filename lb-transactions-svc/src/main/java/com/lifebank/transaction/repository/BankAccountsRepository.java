package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbBankAccountPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountsRepository extends JpaRepository<LbBankAccountPOJO, String> {

}
