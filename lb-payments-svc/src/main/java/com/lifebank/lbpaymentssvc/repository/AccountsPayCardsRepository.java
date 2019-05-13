package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbAccountCreditcardPaymentsPOJO;
import com.lifebank.lbpaymentssvc.pojo.database.LbAccountCreditcardPaymentsPOJOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountsPayCardsRepository extends JpaRepository<LbAccountCreditcardPaymentsPOJO, LbAccountCreditcardPaymentsPOJOPK> {
    @Query(value = "SELECT t from LbAccountCreditcardPaymentsPOJO t where acp_acc_id = (:productId)")
    List<LbAccountCreditcardPaymentsPOJO> findTransaccionesOfProduct(@Param("productId") String productId);
}
