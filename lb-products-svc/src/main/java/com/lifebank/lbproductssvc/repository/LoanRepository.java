package com.lifebank.lbproductssvc.repository;

import com.lifebank.lbproductssvc.pojo.LbLoansPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LbLoansPOJO, Integer> {
    List<LbLoansPOJO> findAllByLoaCliId(Integer loaCliId);
}
