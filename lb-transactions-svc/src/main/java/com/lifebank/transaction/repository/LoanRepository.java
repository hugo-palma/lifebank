package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbLoansPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LbLoansPOJO, Integer> {
}
