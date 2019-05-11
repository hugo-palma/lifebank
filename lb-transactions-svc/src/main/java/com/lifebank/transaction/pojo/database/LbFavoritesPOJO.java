package com.lifebank.transaction.pojo.database;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "lb_favorites", schema = "lb_bank", catalog = "postgres")
public class LbFavoritesPOJO {
    private Integer favId;
    private byte[] favCreationDate;
    private String favState;
    private Integer favCliId;
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
    public byte[] getFavCreationDate() {
        return favCreationDate;
    }

    public void setFavCreationDate(byte[] favCreationDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbFavoritesPOJO that = (LbFavoritesPOJO) o;
        return Objects.equals(favId, that.favId) &&
                Arrays.equals(favCreationDate, that.favCreationDate) &&
                Objects.equals(favState, that.favState) &&
                Objects.equals(favCliId, that.favCliId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(favId, favState, favCliId);
        result = 31 * result + Arrays.hashCode(favCreationDate);
        return result;
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
