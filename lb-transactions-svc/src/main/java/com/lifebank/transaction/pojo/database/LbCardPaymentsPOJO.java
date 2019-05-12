package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lb_card_payments", schema = "lb_bank", catalog = "postgres")
public class LbCardPaymentsPOJO implements ITransaction{
    private Integer cpaId;
    private Integer cpaCreId;
    private Double cpaPaymentAmount;
    private String cpaPaymentDescription;
    private Timestamp cpaPaymentDate;
    private String cpaAuthorizationNumber;
    private LbCreditCardsPOJO lbCreditCardsByCpaCreId;

    @Id
    @Column(name = "cpa_id", nullable = false)
    public Integer getCpaId() {
        return cpaId;
    }

    public void setCpaId(Integer cpaId) {
        this.cpaId = cpaId;
    }

    @Basic
    @Column(name = "cpa_cre_id", nullable = false)
    public Integer getCpaCreId() {
        return cpaCreId;
    }

    public void setCpaCreId(Integer cpaCreId) {
        this.cpaCreId = cpaCreId;
    }

    @Basic
    @Column(name = "cpa_payment_amount", nullable = false, precision = 0)
    public Double getCpaPaymentAmount() {
        return cpaPaymentAmount;
    }

    public void setCpaPaymentAmount(Double cpaPaymentAmount) {
        this.cpaPaymentAmount = cpaPaymentAmount;
    }

    @Basic
    @Column(name = "cpa_payment_description", nullable = false, length = 50)
    public String getCpaPaymentDescription() {
        return cpaPaymentDescription;
    }

    public void setCpaPaymentDescription(String cpaPaymentDescription) {
        this.cpaPaymentDescription = cpaPaymentDescription;
    }

    @Basic
    @Column(name = "cpa_payment_date", nullable = false)
    public Timestamp getCpaPaymentDate() {
        return cpaPaymentDate;
    }

    public void setCpaPaymentDate(Timestamp cpaPaymentDate) {
        this.cpaPaymentDate = cpaPaymentDate;
    }

    @Basic
    @Column(name = "cpa_authorization_number", nullable = false, length = 50)
    public String getCpaAuthorizationNumber() {
        return cpaAuthorizationNumber;
    }

    public void setCpaAuthorizationNumber(String cpaAuthorizationNumber) {
        this.cpaAuthorizationNumber = cpaAuthorizationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbCardPaymentsPOJO that = (LbCardPaymentsPOJO) o;
        return Objects.equals(cpaId, that.cpaId) &&
                Objects.equals(cpaCreId, that.cpaCreId) &&
                Objects.equals(cpaPaymentAmount, that.cpaPaymentAmount) &&
                Objects.equals(cpaPaymentDescription, that.cpaPaymentDescription) &&
                Objects.equals(cpaPaymentDate, that.cpaPaymentDate) &&
                Objects.equals(cpaAuthorizationNumber, that.cpaAuthorizationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpaId, cpaCreId, cpaPaymentAmount, cpaPaymentDescription, cpaPaymentDate, cpaAuthorizationNumber);
    }

    @ManyToOne
    @JoinColumn(name = "cpa_cre_id", referencedColumnName = "cre_id", nullable = false, insertable = false, updatable = false)
    public LbCreditCardsPOJO getLbCreditCardsByCpaCreId() {
        return lbCreditCardsByCpaCreId;
    }

    public void setLbCreditCardsByCpaCreId(LbCreditCardsPOJO lbCreditCardsByCpaCreId) {
        this.lbCreditCardsByCpaCreId = lbCreditCardsByCpaCreId;
    }

    @Override
    @Transient
    public String getSender() {
        return cpaCreId.toString();
    }

    @Override
    @Transient
    public String getReceiver() {
        return null;
    }

    @Override
    @Transient
    public String getDetails() {
        return cpaId.toString();
    }
}
