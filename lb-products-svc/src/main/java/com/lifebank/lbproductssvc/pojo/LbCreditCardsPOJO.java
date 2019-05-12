package com.lifebank.lbproductssvc.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lb_credit_cards", schema = "lb_bank", catalog = "postgres")
public class LbCreditCardsPOJO {
    private Integer creId;
    private Double creAmountLimit;
    private Timestamp creCreationDate;
    private Double creAmountAvailable;
    private Double creInterestRate;
    private Double creInterestAccumulated;
    private Integer creCutDay;
    private Integer creCliId;
    private LbClientPOJO lbClientByCreCliId;

    @Id
    @Column(name = "cre_id", nullable = false)
    public Integer getCreId() {
        return creId;
    }

    public void setCreId(Integer creId) {
        this.creId = creId;
    }

    @Basic
    @Column(name = "cre_amount_limit", nullable = false, precision = 0)
    public Double getCreAmountLimit() {
        return creAmountLimit;
    }

    public void setCreAmountLimit(Double creAmountLimit) {
        this.creAmountLimit = creAmountLimit;
    }

    @Basic
    @Column(name = "cre_creation_date", nullable = false)
    public Timestamp getCreCreationDate() {
        return creCreationDate;
    }

    public void setCreCreationDate(Timestamp creCreationDate) {
        this.creCreationDate = creCreationDate;
    }

    @Basic
    @Column(name = "cre_amount_available", nullable = false, precision = 0)
    public Double getCreAmountAvailable() {
        return creAmountAvailable;
    }

    public void setCreAmountAvailable(Double creAmountAvailable) {
        this.creAmountAvailable = creAmountAvailable;
    }

    @Basic
    @Column(name = "cre_interest_rate", nullable = false, precision = 0)
    public Double getCreInterestRate() {
        return creInterestRate;
    }

    public void setCreInterestRate(Double creInterestRate) {
        this.creInterestRate = creInterestRate;
    }

    @Basic
    @Column(name = "cre_interest_accumulated", nullable = false, precision = 0)
    public Double getCreInterestAccumulated() {
        return creInterestAccumulated;
    }

    public void setCreInterestAccumulated(Double creInterestAccumulated) {
        this.creInterestAccumulated = creInterestAccumulated;
    }

    @Basic
    @Column(name = "cre_cut_day", nullable = false)
    public Integer getCreCutDay() {
        return creCutDay;
    }

    public void setCreCutDay(Integer creCutDay) {
        this.creCutDay = creCutDay;
    }

    @Basic
    @Column(name = "cre_cli_id", nullable = false)
    public Integer getCreCliId() {
        return creCliId;
    }

    public void setCreCliId(Integer creCliId) {
        this.creCliId = creCliId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbCreditCardsPOJO that = (LbCreditCardsPOJO) o;
        return Objects.equals(creId, that.creId) &&
                Objects.equals(creAmountLimit, that.creAmountLimit) &&
                Objects.equals(creCreationDate, that.creCreationDate) &&
                Objects.equals(creAmountAvailable, that.creAmountAvailable) &&
                Objects.equals(creInterestRate, that.creInterestRate) &&
                Objects.equals(creInterestAccumulated, that.creInterestAccumulated) &&
                Objects.equals(creCutDay, that.creCutDay) &&
                Objects.equals(creCliId, that.creCliId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creId, creAmountLimit, creCreationDate, creAmountAvailable, creInterestRate, creInterestAccumulated, creCutDay, creCliId);
    }

    @ManyToOne
    @JoinColumn(name = "cre_cli_id", referencedColumnName = "cli_id", nullable = false, insertable = false, updatable = false)
    public LbClientPOJO getLbClientByCreCliId() {
        return lbClientByCreCliId;
    }

    public void setLbClientByCreCliId(LbClientPOJO lbClientByCreCliId) {
        this.lbClientByCreCliId = lbClientByCreCliId;
    }
}
