package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lb_account_creditcard_payments", schema = "lb_bank", catalog = "postgres")
@IdClass(LbAccountCreditcardPaymentsPOJOPK.class)
public class LbAccountCreditcardPaymentsPOJO extends TransactionBlueprint implements ITransaction {
    private String acpAccId;
    private Integer acpCreId;
    private Integer acpCpdId;
    private LbBankAccountPOJO lbBankAccountByAcpAccId;
    private LbCreditCardsPOJO lbCreditCardsByAcpCreId;
    private LbCreditcardPaymentsDetailsPOJO lbCreditcardPaymentsDetailsByAcpCpdId;

    @Id
    @Column(name = "acp_acc_id", nullable = false, length = 10)
    public String getAcpAccId() {
        return acpAccId;
    }

    public void setAcpAccId(String acpAccId) {
        this.acpAccId = acpAccId;
    }

    @Id
    @Column(name = "acp_cre_id", nullable = false)
    public Integer getAcpCreId() {
        return acpCreId;
    }

    public void setAcpCreId(Integer acpCreId) {
        this.acpCreId = acpCreId;
    }

    @Id
    @Column(name = "acp_cpd_id", nullable = false)
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
        LbAccountCreditcardPaymentsPOJO that = (LbAccountCreditcardPaymentsPOJO) o;
        return Objects.equals(acpAccId, that.acpAccId) &&
                Objects.equals(acpCreId, that.acpCreId) &&
                Objects.equals(acpCpdId, that.acpCpdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acpAccId, acpCreId, acpCpdId);
    }

    @ManyToOne
    @JoinColumn(name = "acp_acc_id", referencedColumnName = "acc_id", nullable = false, insertable = false, updatable = false)
    public LbBankAccountPOJO getLbBankAccountByAcpAccId() {
        return lbBankAccountByAcpAccId;
    }

    public void setLbBankAccountByAcpAccId(LbBankAccountPOJO lbBankAccountByAcpAccId) {
        this.lbBankAccountByAcpAccId = lbBankAccountByAcpAccId;
    }

    @ManyToOne
    @JoinColumn(name = "acp_cre_id", referencedColumnName = "cre_id", nullable = false, insertable = false, updatable = false)
    public LbCreditCardsPOJO getLbCreditCardsByAcpCreId() {
        return lbCreditCardsByAcpCreId;
    }

    public void setLbCreditCardsByAcpCreId(LbCreditCardsPOJO lbCreditCardsByAcpCreId) {
        this.lbCreditCardsByAcpCreId = lbCreditCardsByAcpCreId;
    }

    @ManyToOne
    @JoinColumn(name = "acp_cpd_id", referencedColumnName = "cpd_id", nullable = false, insertable = false, updatable = false)
    public LbCreditcardPaymentsDetailsPOJO getLbCreditcardPaymentsDetailsByAcpCpdId() {
        return lbCreditcardPaymentsDetailsByAcpCpdId;
    }

    public void setLbCreditcardPaymentsDetailsByAcpCpdId(LbCreditcardPaymentsDetailsPOJO lbCreditcardPaymentsDetailsByAcpCpdId) {
        this.lbCreditcardPaymentsDetailsByAcpCpdId = lbCreditcardPaymentsDetailsByAcpCpdId;
    }
    @Transient
    @Override
    public String getSender() {
        return acpAccId;
    }
    @Transient
    @Override
    public String getReceiver() {
        return acpCreId.toString();
    }
    @Transient
    @Override
    public String getDetails() {
        return acpCpdId.toString();
    }
}
