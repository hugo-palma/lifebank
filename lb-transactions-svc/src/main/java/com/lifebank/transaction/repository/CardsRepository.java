package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbCreditCardsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<LbCreditCardsPOJO, Integer> {
}
