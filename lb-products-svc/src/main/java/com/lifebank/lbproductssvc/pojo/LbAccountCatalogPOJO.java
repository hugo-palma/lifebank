package com.lifebank.lbproductssvc.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lb_account_catalog", schema = "lb_bank", catalog = "postgres")
public class LbAccountCatalogPOJO {
    private Integer acaId;
    private String acaName;

    @Id
    @Column(name = "aca_id", nullable = false)
    public Integer getAcaId() {
        return acaId;
    }

    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    @Basic
    @Column(name = "aca_name", nullable = false, length = 100)
    public String getAcaName() {
        return acaName;
    }

    public void setAcaName(String acaName) {
        this.acaName = acaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbAccountCatalogPOJO that = (LbAccountCatalogPOJO) o;
        return Objects.equals(acaId, that.acaId) &&
                Objects.equals(acaName, that.acaName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acaId, acaName);
    }
}
