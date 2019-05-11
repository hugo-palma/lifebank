package com.lifebank.transaction.pojo.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LbAccountCreditcardPaymentsPOJOPK implements Serializable {
    private String acpAccId;
    private Integer acpCreId;
    private Integer acpCpdId;

    @Column(name = "acp_acc_id", nullable = false, length = 10)
    @Id
    public String getAcpAccId() {
        return acpAccId;
    }

    public void setAcpAccId(String acpAccId) {
        this.acpAccId = acpAccId;
    }

    @Column(name = "acp_cre_id", nullable = false)
    @Id
    public Integer getAcpCreId() {
        return acpCreId;
    }

    public void setAcpCreId(Integer acpCreId) {
        this.acpCreId = acpCreId;
    }

    @Column(name = "acp_cpd_id", nullable = false)
    @Id
    public Integer getAcpCpdId() {
        return acpCpdId;
    }

    public void setAcpCpdId(Integer acpCpdId) {
        this.acpCpdId = acpCpdId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbAccountCreditcardPaymentsPOJOPK that = (LbAccountCreditcardPaymentsPOJOPK) o;
        return Objects.equals(acpAccId, that.acpAccId) &&
                Objects.equals(acpCreId, that.acpCreId) &&
                Objects.equals(acpCpdId, that.acpCpdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acpAccId, acpCreId, acpCpdId);
    }
}
