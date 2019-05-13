package com.lifebank.lbpaymentssvc.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_loans", schema = "lb_bank", catalog = "postgres")
public class LbLoansPOJO {
    private Integer loaId;
    private Timestamp loaStartDate;
    private Double loaTotalAmount;
    private Double loaDebt;
    private Double loaInterestRate;
    private Double loaInterestAmount;
    private Integer loaCliId;
    private Collection<LbAccountLoanPaymentsPOJO> lbAccountLoanPaymentsByLoaId;
    private LbClientPOJO lbClientByLoaCliId;

    @Id
    @Column(name = "loa_id", nullable = false)
    public Integer getLoaId() {
        return loaId;
    }

    public void setLoaId(Integer loaId) {
        this.loaId = loaId;
    }

    @Basic
    @Column(name = "loa_start_date", nullable = false)
    public Timestamp getLoaStartDate() {
        return loaStartDate;
    }

    public void setLoaStartDate(Timestamp loaStartDate) {
        this.loaStartDate = loaStartDate;
    }

    @Basic
    @Column(name = "loa_total_amount", nullable = false, precision = 0)
    public Double getLoaTotalAmount() {
        return loaTotalAmount;
    }

    public void setLoaTotalAmount(Double loaTotalAmount) {
        this.loaTotalAmount = loaTotalAmount;
    }

    @Basic
    @Column(name = "loa_debt", nullable = false, precision = 0)
    public Double getLoaDebt() {
        return loaDebt;
    }

    public void setLoaDebt(Double loaDebt) {
        this.loaDebt = loaDebt;
    }

    @Basic
    @Column(name = "loa_interest_rate", nullable = false, precision = 0)
    public Double getLoaInterestRate() {
        return loaInterestRate;
    }

    public void setLoaInterestRate(Double loaInterestRate) {
        this.loaInterestRate = loaInterestRate;
    }

    @Basic
    @Column(name = "loa_interest_amount", nullable = false, precision = 0)
    public Double getLoaInterestAmount() {
        return loaInterestAmount;
    }

    public void setLoaInterestAmount(Double loaInterestAmount) {
        this.loaInterestAmount = loaInterestAmount;
    }

    @Basic
    @Column(name = "loa_cli_id", nullable = false)
    public Integer getLoaCliId() {
        return loaCliId;
    }

    public void setLoaCliId(Integer loaCliId) {
        this.loaCliId = loaCliId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbLoansPOJO that = (LbLoansPOJO) o;
        return Objects.equals(loaId, that.loaId) &&
                Objects.equals(loaStartDate, that.loaStartDate) &&
                Objects.equals(loaTotalAmount, that.loaTotalAmount) &&
                Objects.equals(loaDebt, that.loaDebt) &&
                Objects.equals(loaInterestRate, that.loaInterestRate) &&
                Objects.equals(loaInterestAmount, that.loaInterestAmount) &&
                Objects.equals(loaCliId, that.loaCliId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loaId, loaStartDate, loaTotalAmount, loaDebt, loaInterestRate, loaInterestAmount, loaCliId);
    }

    @OneToMany(mappedBy = "lbLoansByAlpLoaId")
    public Collection<LbAccountLoanPaymentsPOJO> getLbAccountLoanPaymentsByLoaId() {
        return lbAccountLoanPaymentsByLoaId;
    }

    public void setLbAccountLoanPaymentsByLoaId(Collection<LbAccountLoanPaymentsPOJO> lbAccountLoanPaymentsByLoaId) {
        this.lbAccountLoanPaymentsByLoaId = lbAccountLoanPaymentsByLoaId;
    }

    @ManyToOne
    @JoinColumn(name = "loa_cli_id", referencedColumnName = "cli_id", nullable = false, insertable = false, updatable = false)
    public LbClientPOJO getLbClientByLoaCliId() {
        return lbClientByLoaCliId;
    }

    public void setLbClientByLoaCliId(LbClientPOJO lbClientByLoaCliId) {
        this.lbClientByLoaCliId = lbClientByLoaCliId;
    }
}
