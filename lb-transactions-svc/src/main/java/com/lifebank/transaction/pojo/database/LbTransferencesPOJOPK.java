package com.lifebank.transaction.pojo.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LbTransferencesPOJOPK implements Serializable {
    private String traEmitterAccount;
    private String traReceiverAccount;
    private Integer traDtrId;

    @Column(name = "tra_emitter_account", nullable = false, length = 10)
    @Id
    public String getTraEmitterAccount() {
        return traEmitterAccount;
    }

    public void setTraEmitterAccount(String traEmitterAccount) {
        this.traEmitterAccount = traEmitterAccount;
    }

    @Column(name = "tra_receiver_account", nullable = false, length = 10)
    @Id
    public String getTraReceiverAccount() {
        return traReceiverAccount;
    }

    public void setTraReceiverAccount(String traReceiverAccount) {
        this.traReceiverAccount = traReceiverAccount;
    }

    @Column(name = "tra_dtr_id", nullable = false)
    @Id
    public Integer getTraDtrId() {
        return traDtrId;
    }

    public void setTraDtrId(Integer traDtrId) {
        this.traDtrId = traDtrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbTransferencesPOJOPK that = (LbTransferencesPOJOPK) o;
        return Objects.equals(traEmitterAccount, that.traEmitterAccount) &&
                Objects.equals(traReceiverAccount, that.traReceiverAccount) &&
                Objects.equals(traDtrId, that.traDtrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traEmitterAccount, traReceiverAccount, traDtrId);
    }
}
