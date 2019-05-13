package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbAccountLoanPaymentsPOJO;
import com.lifebank.lbpaymentssvc.pojo.database.LbAccountLoanPaymentsPOJOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountsPayLoansRepository extends JpaRepository<LbAccountLoanPaymentsPOJO, LbAccountLoanPaymentsPOJOPK> {
    @Query(value = "SELECT t from LbAccountLoanPaymentsPOJO t where alp_acc_id = (:productId)")
    List<LbAccountLoanPaymentsPOJO> findTransaccionesOfProduct(@Param("productId") String productId);

    @Query(value = "SELECT t from LbAccountLoanPaymentsPOJO t where alp_loa_id = (:loanId)")
    List<LbAccountLoanPaymentsPOJO> findPaymentsByLoanId(@Param("loanId") String loanId);
}
