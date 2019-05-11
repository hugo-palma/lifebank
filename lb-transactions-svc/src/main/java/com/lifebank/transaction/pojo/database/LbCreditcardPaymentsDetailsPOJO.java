package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_creditcard_payments_details", schema = "lb_bank", catalog = "postgres")
public class LbCreditcardPaymentsDetailsPOJO {
    private Integer cpdId;
    private Timestamp cpdPaymentDate;
    private Double cpdPaymentAmount;
    private String cpdAuthorizationNumber;
    private String cpdDescription;
    private Collection<LbAccountCreditcardPaymentsPOJO> lbAccountCreditcardPaymentsByCpdId;

    @Id
    @Column(name = "cpd_id", nullable = false)
    public Integer getCpdId() {
        return cpdId;
    }

    public void setCpdId(Integer cpdId) {
        this.cpdId = cpdId;
    }

    @Basic
    @Column(name = "cpd_payment_date", nullable = false)
    public Timestamp getCpdPaymentDate() {
        return cpdPaymentDate;
    }

    public void setCpdPaymentDate(Timestamp cpdPaymentDate) {
        this.cpdPaymentDate = cpdPaymentDate;
    }

    @Basic
    @Column(name = "cpd_payment_amount", nullable = false, precision = 0)
    public Double getCpdPaymentAmount() {
        return cpdPaymentAmount;
    }

    public void setCpdPaymentAmount(Double cpdPaymentAmount) {
        this.cpdPaymentAmount = cpdPaymentAmount;
    }

    @Basic
    @Column(name = "cpd_authorization_number", nullable = false, length = 50)
    public String getCpdAuthorizationNumber() {
        return cpdAuthorizationNumber;
    }

    public void setCpdAuthorizationNumber(String cpdAuthorizationNumber) {
        this.cpdAuthorizationNumber = cpdAuthorizationNumber;
    }

    @Basic
    @Column(name = "cpd_description", nullable = false, length = 50)
    public String getCpdDescription() {
        return cpdDescription;
    }

    public void setCpdDescription(String cpdDescription) {
        this.cpdDescription = cpdDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbCreditcardPaymentsDetailsPOJO that = (LbCreditcardPaymentsDetailsPOJO) o;
        return Objects.equals(cpdId, that.cpdId) &&
                Objects.equals(cpdPaymentDate, that.cpdPaymentDate) &&
                Objects.equals(cpdPaymentAmount, that.cpdPaymentAmount) &&
                Objects.equals(cpdAuthorizationNumber, that.cpdAuthorizationNumber) &&
                Objects.equals(cpdDescription, that.cpdDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpdId, cpdPaymentDate, cpdPaymentAmount, cpdAuthorizationNumber, cpdDescription);
    }

    @OneToMany(mappedBy = "lbCreditcardPaymentsDetailsByAcpCpdId")
    public Collection<LbAccountCreditcardPaymentsPOJO> getLbAccountCreditcardPaymentsByCpdId() {
        return lbAccountCreditcardPaymentsByCpdId;
    }

    public void setLbAccountCreditcardPaymentsByCpdId(Collection<LbAccountCreditcardPaymentsPOJO> lbAccountCreditcardPaymentsByCpdId) {
        this.lbAccountCreditcardPaymentsByCpdId = lbAccountCreditcardPaymentsByCpdId;
    }
}
