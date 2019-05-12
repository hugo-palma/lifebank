package com.lifebank.lbproductssvc.repository;

import com.lifebank.lbproductssvc.pojo.LbClientPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<LbClientPOJO, Integer> {
}
