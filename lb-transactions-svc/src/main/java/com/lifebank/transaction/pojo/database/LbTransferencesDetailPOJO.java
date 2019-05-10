package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_transferences_detail", schema = "lb_bank", catalog = "postgres")
public class LbTransferencesDetailPOJO {
    private Integer dtrId;
    private byte[] dtrTransferDate;
    private Double dtrAmountTransfered;
    private String dtrEmitterSession;
    private String dtrDescription;
    private Collection<LbTransferencesPOJO> lbTransferencesByDtrId;

    @Id
    @Column(name = "dtr_id", nullable = false)
    public Integer getDtrId() {
        return dtrId;
    }

    public void setDtrId(Integer dtrId) {
        this.dtrId = dtrId;
    }

    @Basic
    @Column(name = "dtr_transfer_date", nullable = false)
    public byte[] getDtrTransferDate() {
        return dtrTransferDate;
    }

    public void setDtrTransferDate(byte[] dtrTransferDate) {
        this.dtrTransferDate = dtrTransferDate;
    }

    @Basic
    @Column(name = "dtr_amount_transfered", nullable = false, precision = 0)
    public Double getDtrAmountTransfered() {
        return dtrAmountTransfered;
    }

    public void setDtrAmountTransfered(Double dtrAmountTransfered) {
        this.dtrAmountTransfered = dtrAmountTransfered;
    }

    @Basic
    @Column(name = "dtr_emitter_session", nullable = false, length = 50)
    public String getDtrEmitterSession() {
        return dtrEmitterSession;
    }

    public void setDtrEmitterSession(String dtrEmitterSession) {
        this.dtrEmitterSession = dtrEmitterSession;
    }

    @Basic
    @Column(name = "dtr_description", nullable = false, length = 250)
    public String getDtrDescription() {
        return dtrDescription;
    }

    public void setDtrDescription(String dtrDescription) {
        this.dtrDescription = dtrDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbTransferencesDetailPOJO that = (LbTransferencesDetailPOJO) o;
        return Objects.equals(dtrId, that.dtrId) &&
                Arrays.equals(dtrTransferDate, that.dtrTransferDate) &&
                Objects.equals(dtrAmountTransfered, that.dtrAmountTransfered) &&
                Objects.equals(dtrEmitterSession, that.dtrEmitterSession) &&
                Objects.equals(dtrDescription, that.dtrDescription);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dtrId, dtrAmountTransfered, dtrEmitterSession, dtrDescription);
        result = 31 * result + Arrays.hashCode(dtrTransferDate);
        return result;
    }

    @OneToMany(mappedBy = "lbTransferencesDetailByTraDtrId")
    public Collection<LbTransferencesPOJO> getLbTransferencesByDtrId() {
        return lbTransferencesByDtrId;
    }

    public void setLbTransferencesByDtrId(Collection<LbTransferencesPOJO> lbTransferencesByDtrId) {
        this.lbTransferencesByDtrId = lbTransferencesByDtrId;
    }
}
