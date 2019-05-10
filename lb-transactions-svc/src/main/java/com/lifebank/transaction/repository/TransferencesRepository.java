package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbTransferencesI;
import com.lifebank.transaction.pojo.database.LbTransferencesPOJOPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferencesRepository extends TransaccionesRepository<LbTransferencesI, LbTransferencesPOJOPK> {
    @Override
    @Query(value = "SELECT * from lb_transferences t where tra_emitter_account = (:productId)", nativeQuery = true)
    List<LbTransferencesI> findTransaccionesOfProduct(@Param("productId") String productId);
}
