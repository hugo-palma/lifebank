package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountsPayLoansRepository extends TransaccionesRepository<LbAccountLoanPaymentsPOJO, LbAccountLoanPaymentsPOJOPK>{
    @Override
    @Query(value = "SELECT t from LbAccountLoanPaymentsPOJO t where alp_acc_id = (:productId)")
    List<ITransaction> findTransaccionesOfProduct(@Param("productId") String productId);

    @Query(value = "SELECT t from LbAccountLoanPaymentsPOJO t where alp_loa_id = (:loanId)")
    List<ITransaction> findPaymentsByLoanId(@Param("loanId")String loanId);
}
