package com.lifebank.lbfavoritessvc.repository;

import com.lifebank.lbfavoritessvc.pojo.database.LbFavoritesPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<LbFavoritesPOJO, Integer> {
    public Optional<LbFavoritesPOJO> findByFavProductCode(String favProductCode);
    public List<LbFavoritesPOJO> findAllByFavCliId(String favCliId);
}
