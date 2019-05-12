package com.lifebank.lbproductssvc.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lb_bank_account", schema = "lb_bank", catalog = "postgres")
public class LbBankAccountPOJO {
    private String accId;
    private Timestamp accFechaCreacion;
    private Double accMonto;
    private Integer accCliId;
    private LbClientPOJO lbClientByAccCliId;

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

    @Basic
    @Column(name = "acc_cli_id", nullable = false)
    public Integer getAccCliId() {
        return accCliId;
    }

    public void setAccCliId(Integer accCliId) {
        this.accCliId = accCliId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbBankAccountPOJO that = (LbBankAccountPOJO) o;
        return Objects.equals(accId, that.accId) &&
                Objects.equals(accFechaCreacion, that.accFechaCreacion) &&
                Objects.equals(accMonto, that.accMonto) &&
                Objects.equals(accCliId, that.accCliId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, accFechaCreacion, accMonto, accCliId);
    }

    @ManyToOne
    @JoinColumn(name = "acc_cli_id", referencedColumnName = "cli_id", nullable = false, insertable = false, updatable = false)
    public LbClientPOJO getLbClientByAccCliId() {
        return lbClientByAccCliId;
    }

    public void setLbClientByAccCliId(LbClientPOJO lbClientByAccCliId) {
        this.lbClientByAccCliId = lbClientByAccCliId;
    }
}
