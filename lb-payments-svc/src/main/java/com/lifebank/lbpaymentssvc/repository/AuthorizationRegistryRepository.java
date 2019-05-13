package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.LbAuthorizationRegistryPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRegistryRepository extends JpaRepository<LbAuthorizationRegistryPOJO, Integer> {
}
