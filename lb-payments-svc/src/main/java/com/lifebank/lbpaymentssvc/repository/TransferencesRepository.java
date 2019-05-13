package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbTransferencesPOJO;
import com.lifebank.lbpaymentssvc.pojo.database.LbTransferencesPOJOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferencesRepository extends JpaRepository<LbTransferencesPOJO, LbTransferencesPOJOPK> {
    @Query(value = "SELECT t from LbTransferencesPOJO t where tra_emitter_account = (:productId)")
    List<LbTransferencesPOJO> findTransaccionesOfProduct(@Param("productId") String productId);
}
