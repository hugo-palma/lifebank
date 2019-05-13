package com.lifebank.lbpaymentssvc.pojo.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LbAccountLoanPaymentsPOJOPK implements Serializable {
    private String alpAccId;
    private Integer alpLoaId;
    private Integer alpLpdId;

    @Column(name = "alp_acc_id", nullable = false, length = 10)
    @Id
    public String getAlpAccId() {
        return alpAccId;
    }

    public void setAlpAccId(String alpAccId) {
        this.alpAccId = alpAccId;
    }

    @Column(name = "alp_loa_id", nullable = false)
    @Id
    public Integer getAlpLoaId() {
        return alpLoaId;
    }

    public void setAlpLoaId(Integer alpLoaId) {
        this.alpLoaId = alpLoaId;
    }

    @Column(name = "alp_lpd_id", nullable = false)
    @Id
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
        LbAccountLoanPaymentsPOJOPK that = (LbAccountLoanPaymentsPOJOPK) o;
        return Objects.equals(alpAccId, that.alpAccId) &&
                Objects.equals(alpLoaId, that.alpLoaId) &&
                Objects.equals(alpLpdId, that.alpLpdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alpAccId, alpLoaId, alpLpdId);
    }
}
