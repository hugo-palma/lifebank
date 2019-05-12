package com.lifebank.lbfavoritessvc.repository;

import com.lifebank.lbfavoritessvc.pojo.database.LbCreditCardsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<LbCreditCardsPOJO, Integer> {
}
