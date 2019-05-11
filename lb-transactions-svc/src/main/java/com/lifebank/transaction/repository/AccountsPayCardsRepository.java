package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.LbAccountCreditcardPaymentsPOJO;
import com.lifebank.transaction.pojo.database.LbAccountCreditcardPaymentsPOJOPK;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountsPayCardsRepository extends TransaccionesRepository<LbAccountCreditcardPaymentsPOJO, LbAccountCreditcardPaymentsPOJOPK> {
    @Override
    @Query(value = "SELECT t from LbAccountCreditcardPaymentsPOJO t where acp_acc_id = (:productId)")
    List<ITransaction> findTransaccionesOfProduct(@Param("productId") String productId);
}
