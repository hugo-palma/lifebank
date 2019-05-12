package com.lifebank.lbfavoritessvc.repository;

import com.lifebank.lbfavoritessvc.pojo.database.LbLoansPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LbLoansPOJO, Integer> {
}
