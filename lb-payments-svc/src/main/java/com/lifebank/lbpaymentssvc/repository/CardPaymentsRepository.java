package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbCardPaymentsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardPaymentsRepository extends JpaRepository<LbCardPaymentsPOJO, Integer> {
    @Query(value = "SELECT T from LbCardPaymentsPOJO T where cpa_id = (:cardId)")
    public List<LbCardPaymentsPOJO> findPaymentsByCardId(@Param("cardId") Integer cardId);
}
