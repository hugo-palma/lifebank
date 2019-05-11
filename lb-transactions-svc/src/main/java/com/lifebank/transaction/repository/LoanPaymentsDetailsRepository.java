package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbAccountLoanPaymentsPOJOPK;
import com.lifebank.transaction.pojo.database.LbLoanPaymentsDetailsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanPaymentsDetailsRepository extends JpaRepository<LbLoanPaymentsDetailsPOJO, Integer> {
}
