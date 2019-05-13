package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbTransferencesPOJO;
import com.lifebank.transaction.pojo.database.LbTransferencesPOJOPK;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferencesRepository extends TransaccionesRepository<LbTransferencesPOJO, LbTransferencesPOJOPK> {
    @Override
    @Query(value = "SELECT t from LbTransferencesPOJO t where tra_emitter_account = (:productId) or tra_receiver_account = (:productId)")
    List<ITransaction> findTransaccionesOfProduct(@Param("productId") String productId);
}
