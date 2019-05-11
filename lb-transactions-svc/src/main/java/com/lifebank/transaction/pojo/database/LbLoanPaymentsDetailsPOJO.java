package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_loan_payments_details", schema = "lb_bank", catalog = "postgres")
public class LbLoanPaymentsDetailsPOJO {
    private Integer lpdId;
    private Timestamp lpdPaymentDate;
    private Double lpdPaymentAmount;
    private String lpdAuthorizationNumber;
    private String lpdDescription;
    private Collection<LbAccountLoanPaymentsPOJO> lbAccountLoanPaymentsByLpdId;

    @Id
    @Column(name = "lpd_id", nullable = false)
    public Integer getLpdId() {
        return lpdId;
    }

    public void setLpdId(Integer lpdId) {
        this.lpdId = lpdId;
    }

    @Basic
    @Column(name = "lpd_payment_date", nullable = false)
    public Timestamp getLpdPaymentDate() {
        return lpdPaymentDate;
    }

    public void setLpdPaymentDate(Timestamp lpdPaymentDate) {
        this.lpdPaymentDate = lpdPaymentDate;
    }

    @Basic
    @Column(name = "lpd_payment_amount", nullable = false, precision = 0)
    public Double getLpdPaymentAmount() {
        return lpdPaymentAmount;
    }

    public void setLpdPaymentAmount(Double lpdPaymentAmount) {
        this.lpdPaymentAmount = lpdPaymentAmount;
    }

    @Basic
    @Column(name = "lpd_authorization_number", nullable = false, length = 50)
    public String getLpdAuthorizationNumber() {
        return lpdAuthorizationNumber;
    }

    public void setLpdAuthorizationNumber(String lpdAuthorizationNumber) {
        this.lpdAuthorizationNumber = lpdAuthorizationNumber;
    }

    @Basic
    @Column(name = "lpd_description", nullable = false, length = 50)
    public String getLpdDescription() {
        return lpdDescription;
    }

    public void setLpdDescription(String lpdDescription) {
        this.lpdDescription = lpdDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbLoanPaymentsDetailsPOJO that = (LbLoanPaymentsDetailsPOJO) o;
        return Objects.equals(lpdId, that.lpdId) &&
                Objects.equals(lpdPaymentDate, that.lpdPaymentDate) &&
                Objects.equals(lpdPaymentAmount, that.lpdPaymentAmount) &&
                Objects.equals(lpdAuthorizationNumber, that.lpdAuthorizationNumber) &&
                Objects.equals(lpdDescription, that.lpdDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lpdId, lpdPaymentDate, lpdPaymentAmount, lpdAuthorizationNumber, lpdDescription);
    }

    @OneToMany(mappedBy = "lbLoanPaymentsDetailsByAlpLpdId")
    public Collection<LbAccountLoanPaymentsPOJO> getLbAccountLoanPaymentsByLpdId() {
        return lbAccountLoanPaymentsByLpdId;
    }

    public void setLbAccountLoanPaymentsByLpdId(Collection<LbAccountLoanPaymentsPOJO> lbAccountLoanPaymentsByLpdId) {
        this.lbAccountLoanPaymentsByLpdId = lbAccountLoanPaymentsByLpdId;
    }
}
