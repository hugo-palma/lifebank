package com.lifebank.lbproductssvc.repository;

import com.lifebank.lbproductssvc.pojo.LbCreditCardsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<LbCreditCardsPOJO, Integer> {
    public List<LbCreditCardsPOJO> findAllByCreCliId(Integer creCliId);
}
