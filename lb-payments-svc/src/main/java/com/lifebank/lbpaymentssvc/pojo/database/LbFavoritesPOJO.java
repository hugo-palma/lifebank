package com.lifebank.lbpaymentssvc.pojo.database;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lb_favorites", schema = "lb_bank", catalog = "postgres")
public class LbFavoritesPOJO {
    private Integer favId;
    private Timestamp favCreationDate;
    private String favState;
    private Integer favCliId;
    private String favProductType;
    private String favProductCode;
    private String favEmail;
    private String favName;
    private LbClientPOJO lbClientByFavCliId;

    @Id
    @Column(name = "fav_id", nullable = false)
    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }

    @Basic
    @Column(name = "fav_creation_date", nullable = false)
    public Timestamp getFavCreationDate() {
        return favCreationDate;
    }

    public void setFavCreationDate(Timestamp favCreationDate) {
        this.favCreationDate = favCreationDate;
    }

    @Basic
    @Column(name = "fav_state", nullable = false, length = 1)
    public String getFavState() {
        return favState;
    }

    public void setFavState(String favState) {
        this.favState = favState;
    }

    @Basic
    @Column(name = "fav_cli_id", nullable = false)
    public Integer getFavCliId() {
        return favCliId;
    }

    public void setFavCliId(Integer favCliId) {
        this.favCliId = favCliId;
    }

    @Basic
    @Column(name = "fav_product_type", nullable = false, length = 20)
    public String getFavProductType() {
        return favProductType;
    }

    public void setFavProductType(String favProductType) {
        this.favProductType = favProductType;
    }

    @Basic
    @Column(name = "fav_product_code", nullable = false, length = 50)
    public String getFavProductCode() {
        return favProductCode;
    }

    public void setFavProductCode(String favProductCode) {
        this.favProductCode = favProductCode;
    }

    @Basic
    @Column(name = "fav_email", nullable = false, length = 50)
    public String getFavEmail() {
        return favEmail;
    }

    public void setFavEmail(String favEmail) {
        this.favEmail = favEmail;
    }

    @Basic
    @Column(name = "fav_name", nullable = false, length = 50)
    public String getFavName() {
        return favName;
    }

    public void setFavName(String favName) {
        this.favName = favName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbFavoritesPOJO that = (LbFavoritesPOJO) o;
        return Objects.equals(favId, that.favId) &&
                Objects.equals(favCreationDate, that.favCreationDate) &&
                Objects.equals(favState, that.favState) &&
                Objects.equals(favCliId, that.favCliId) &&
                Objects.equals(favProductType, that.favProductType) &&
                Objects.equals(favProductCode, that.favProductCode) &&
                Objects.equals(favEmail, that.favEmail) &&
                Objects.equals(favName, that.favName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favId, favCreationDate, favState, favCliId, favProductType, favProductCode, favEmail, favName);
    }

    @ManyToOne
    @JoinColumn(name = "fav_cli_id", referencedColumnName = "cli_id", nullable = false, insertable = false, updatable = false)
    public LbClientPOJO getLbClientByFavCliId() {
        return lbClientByFavCliId;
    }

    public void setLbClientByFavCliId(LbClientPOJO lbClientByFavCliId) {
        this.lbClientByFavCliId = lbClientByFavCliId;
    }
}
