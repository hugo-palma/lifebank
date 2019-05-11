package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lb_transferences", schema = "lb_bank", catalog = "postgres")
@IdClass(LbTransferencesPOJOPK.class)
public class LbTransferencesPOJO implements ITransaction {
    private String traEmitterAccount;
    private String traReceiverAccount;
    private Integer traDtrId;
    private LbBankAccountPOJO lbBankAccountByTraEmitterAccount;
    private LbBankAccountPOJO lbBankAccountByTraReceiverAccount;
    private LbTransferencesDetailPOJO lbTransferencesDetailByTraDtrId;

    @Id
    @Column(name = "tra_emitter_account", nullable = false, length = 10)
    public String getTraEmitterAccount() {
        return traEmitterAccount;
    }

    public void setTraEmitterAccount(String traEmitterAccount) {
        this.traEmitterAccount = traEmitterAccount;
    }

    @Id
    @Column(name = "tra_receiver_account", nullable = false, length = 10)
    public String getTraReceiverAccount() {
        return traReceiverAccount;
    }

    public void setTraReceiverAccount(String traReceiverAccount) {
        this.traReceiverAccount = traReceiverAccount;
    }

    @Id
    @Column(name = "tra_dtr_id", nullable = false)
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
        LbTransferencesPOJO that = (LbTransferencesPOJO) o;
        return Objects.equals(traEmitterAccount, that.traEmitterAccount) &&
                Objects.equals(traReceiverAccount, that.traReceiverAccount) &&
                Objects.equals(traDtrId, that.traDtrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traEmitterAccount, traReceiverAccount, traDtrId);
    }

    @ManyToOne
    @JoinColumn(name = "tra_emitter_account", referencedColumnName = "acc_id", insertable = false, updatable = false, nullable = false)
    public LbBankAccountPOJO getLbBankAccountByTraEmitterAccount() {
        return lbBankAccountByTraEmitterAccount;
    }

    public void setLbBankAccountByTraEmitterAccount(LbBankAccountPOJO lbBankAccountByTraEmitterAccount) {
        this.lbBankAccountByTraEmitterAccount = lbBankAccountByTraEmitterAccount;
    }

    @ManyToOne
    @JoinColumn(name = "tra_receiver_account", referencedColumnName = "acc_id", insertable = false, updatable = false, nullable = false)
    public LbBankAccountPOJO getLbBankAccountByTraReceiverAccount() {
        return lbBankAccountByTraReceiverAccount;
    }

    public void setLbBankAccountByTraReceiverAccount(LbBankAccountPOJO lbBankAccountByTraReceiverAccount) {
        this.lbBankAccountByTraReceiverAccount = lbBankAccountByTraReceiverAccount;
    }

    @ManyToOne
    @JoinColumn(name = "tra_dtr_id", referencedColumnName = "dtr_id", insertable = false, updatable = false, nullable = false)
    public LbTransferencesDetailPOJO getLbTransferencesDetailByTraDtrId() {
        return lbTransferencesDetailByTraDtrId;
    }

    public void setLbTransferencesDetailByTraDtrId(LbTransferencesDetailPOJO lbTransferencesDetailByTraDtrId) {
        this.lbTransferencesDetailByTraDtrId = lbTransferencesDetailByTraDtrId;
    }

    @Transient
    public String getSender() {
        return traEmitterAccount;
    }
    @Transient
    public String getReceiver() {
        return traReceiverAccount;
    }
    @Transient
    public String getDetails() {
        return traDtrId.toString();
    }
}
