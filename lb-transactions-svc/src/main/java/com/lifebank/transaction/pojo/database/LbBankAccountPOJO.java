package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lb_bank_account", schema = "lb_bank", catalog = "postgres")
public class LbBankAccountPOJO {
    private String accId;
    private Timestamp accFechaCreacion;
    private Double accMonto;
    private Collection<LbTransferencesI> lbTransferencesByAccId;
    private Collection<LbTransferencesI> lbTransferencesByAccId_0;

    @Id
    @Column(name = "acc_id", nullable = false, length = 10)
    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    @Basic
    @Column(name = "acc_fecha_creacion", nullable = false)
    public Timestamp getAccFechaCreacion() {
        return accFechaCreacion;
    }

    public void setAccFechaCreacion(Timestamp accFechaCreacion) {
        this.accFechaCreacion = accFechaCreacion;
    }

    @Basic
    @Column(name = "acc_monto", nullable = false, precision = 0)
    public Double getAccMonto() {
        return accMonto;
    }

    public void setAccMonto(Double accMonto) {
        this.accMonto = accMonto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbBankAccountPOJO that = (LbBankAccountPOJO) o;
        return Objects.equals(accId, that.accId) &&
                Objects.equals(accFechaCreacion, that.accFechaCreacion) &&
                Objects.equals(accMonto, that.accMonto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, accFechaCreacion, accMonto);
    }

    @OneToMany(mappedBy = "lbBankAccountByTraEmitterAccount")
    public Collection<LbTransferencesI> getLbTransferencesByAccId() {
        return lbTransferencesByAccId;
    }

    public void setLbTransferencesByAccId(Collection<LbTransferencesI> lbTransferencesByAccId) {
        this.lbTransferencesByAccId = lbTransferencesByAccId;
    }

    @OneToMany(mappedBy = "lbBankAccountByTraReceiverAccount")
    public Collection<LbTransferencesI> getLbTransferencesByAccId_0() {
        return lbTransferencesByAccId_0;
    }

    public void setLbTransferencesByAccId_0(Collection<LbTransferencesI> lbTransferencesByAccId_0) {
        this.lbTransferencesByAccId_0 = lbTransferencesByAccId_0;
    }
}
