package com.lifebank.lbfavoritessvc.repository;

import com.lifebank.lbfavoritessvc.pojo.database.LbClientPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<LbClientPOJO, Integer> {
}
