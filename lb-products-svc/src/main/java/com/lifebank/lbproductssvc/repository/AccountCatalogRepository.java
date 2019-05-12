package com.lifebank.lbproductssvc.repository;

import com.lifebank.lbproductssvc.pojo.LbAccountCatalogPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCatalogRepository extends JpaRepository<LbAccountCatalogPOJO, Integer> {
}
