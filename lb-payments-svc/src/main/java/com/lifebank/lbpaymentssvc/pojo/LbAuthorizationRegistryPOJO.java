package com.lifebank.lbpaymentssvc.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lb_authorization_registry", schema = "lb_bank", catalog = "postgres")
public class LbAuthorizationRegistryPOJO {
    private Integer areId;
    private String areClientId;
    private String areClientIp;
    private Timestamp areCreationDate;

    @Id
    @Column(name = "are_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getAreId() {
        return areId;
    }

    public void setAreId(Integer areId) {
        this.areId = areId;
    }

    @Basic
    @Column(name = "are_client_id", nullable = false, length = 100)
    public String getAreClientId() {
        return areClientId;
    }

    public void setAreClientId(String areClientId) {
        this.areClientId = areClientId;
    }

    @Basic
    @Column(name = "are_client_ip", nullable = false, length = 100)
    public String getAreClientIp() {
        return areClientIp;
    }

    public void setAreClientIp(String areClientIp) {
        this.areClientIp = areClientIp;
    }

    @Basic
    @Column(name = "are_creation_date", nullable = false)
    public Timestamp getAreCreationDate() {
        return areCreationDate;
    }

    public void setAreCreationDate(Timestamp areCreationDate) {
        this.areCreationDate = areCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbAuthorizationRegistryPOJO that = (LbAuthorizationRegistryPOJO) o;
        return Objects.equals(areId, that.areId) &&
                Objects.equals(areClientId, that.areClientId) &&
                Objects.equals(areClientIp, that.areClientIp) &&
                Objects.equals(areCreationDate, that.areCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areId, areClientId, areClientIp, areCreationDate);
    }
}
