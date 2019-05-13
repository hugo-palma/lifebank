package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbCreditCardsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<LbCreditCardsPOJO, Integer> {
}
