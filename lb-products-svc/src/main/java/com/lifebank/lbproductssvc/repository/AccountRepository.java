package com.lifebank.lbproductssvc.repository;

import com.lifebank.lbproductssvc.pojo.LbBankAccountPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<LbBankAccountPOJO, String> {
    public List<LbBankAccountPOJO> findAllByAccCliId(Integer accCliId);
}
