package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbLoansPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LbLoansPOJO, Integer> {
}
