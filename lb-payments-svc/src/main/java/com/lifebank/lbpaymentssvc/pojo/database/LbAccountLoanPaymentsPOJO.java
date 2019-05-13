package com.lifebank.lbpaymentssvc.pojo.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lb_account_loan_payments", schema = "lb_bank", catalog = "postgres")
@IdClass(LbAccountLoanPaymentsPOJOPK.class)
public class LbAccountLoanPaymentsPOJO {
    private String alpAccId;
    private Integer alpLoaId;
    private Integer alpLpdId;
    private LbBankAccountPOJO lbBankAccountByAlpAccId;
    private LbLoansPOJO lbLoansByAlpLoaId;
    private LbLoanPaymentsDetailsPOJO lbLoanPaymentsDetailsByAlpLpdId;

    @Id
    @Column(name = "alp_acc_id", nullable = false, length = 10)
    public String getAlpAccId() {
        return alpAccId;
    }

    public void setAlpAccId(String alpAccId) {
        this.alpAccId = alpAccId;
    }

    @Id
    @Column(name = "alp_loa_id", nullable = false)
    public Integer getAlpLoaId() {
        return alpLoaId;
    }

    public void setAlpLoaId(Integer alpLoaId) {
        this.alpLoaId = alpLoaId;
    }

    @Id
    @Column(name = "alp_lpd_id", nullable = false)
    public Integer getAlpLpdId() {
        return alpLpdId;
    }

    public void setAlpLpdId(Integer alpLpdId) {
        this.alpLpdId = alpLpdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbAccountLoanPaymentsPOJO that = (LbAccountLoanPaymentsPOJO) o;
        return Objects.equals(alpAccId, that.alpAccId) &&
                Objects.equals(alpLoaId, that.alpLoaId) &&
                Objects.equals(alpLpdId, that.alpLpdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alpAccId, alpLoaId, alpLpdId);
    }

    @ManyToOne
    @JoinColumn(name = "alp_acc_id", referencedColumnName = "acc_id", nullable = false, insertable = false, updatable = false)
    public LbBankAccountPOJO getLbBankAccountByAlpAccId() {
        return lbBankAccountByAlpAccId;
    }

    public void setLbBankAccountByAlpAccId(LbBankAccountPOJO lbBankAccountByAlpAccId) {
        this.lbBankAccountByAlpAccId = lbBankAccountByAlpAccId;
    }

    @ManyToOne
    @JoinColumn(name = "alp_loa_id", referencedColumnName = "loa_id", nullable = false, insertable = false, updatable = false)
    public LbLoansPOJO getLbLoansByAlpLoaId() {
        return lbLoansByAlpLoaId;
    }

    public void setLbLoansByAlpLoaId(LbLoansPOJO lbLoansByAlpLoaId) {
        this.lbLoansByAlpLoaId = lbLoansByAlpLoaId;
    }

    @ManyToOne
    @JoinColumn(name = "alp_lpd_id", referencedColumnName = "lpd_id", nullable = false, insertable = false, updatable = false)
    public LbLoanPaymentsDetailsPOJO getLbLoanPaymentsDetailsByAlpLpdId() {
        return lbLoanPaymentsDetailsByAlpLpdId;
    }

    public void setLbLoanPaymentsDetailsByAlpLpdId(LbLoanPaymentsDetailsPOJO lbLoanPaymentsDetailsByAlpLpdId) {
        this.lbLoanPaymentsDetailsByAlpLpdId = lbLoanPaymentsDetailsByAlpLpdId;
    }
}
