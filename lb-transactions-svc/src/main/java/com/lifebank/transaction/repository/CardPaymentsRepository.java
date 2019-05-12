package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbCardPaymentsPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardPaymentsRepository extends JpaRepository<LbCardPaymentsPOJO, Integer> {
    @Query(value = "SELECT T from LbCardPaymentsPOJO T where cpa_id = (:cardId)")
    public List<ITransaction> findPaymentsByCardId(@Param("cardId") Integer cardId);
}
