package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbLoanPaymentsDetailsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanPaymentsDetailsRepository extends JpaRepository<LbLoanPaymentsDetailsPOJO, Integer> {
}
