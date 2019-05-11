package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbTransferencesPOJO;
import com.lifebank.transaction.pojo.database.LbTransferencesPOJOPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferencesRepository extends TransaccionesRepository<LbTransferencesPOJO, LbTransferencesPOJOPK> {
    @Override
    @Query(value = "SELECT * from lb_transferences t where tra_emitter_account = (:productId)", nativeQuery = true)
    List<LbTransferencesPOJO> findTransaccionesOfProduct(@Param("productId") String productId);
}
