package com.lifebank.lbfavoritessvc.repository;

import com.lifebank.lbfavoritessvc.pojo.database.LbBankAccountPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountsRepository extends JpaRepository<LbBankAccountPOJO, String> {

}
