package com.lifebank.lbpaymentssvc.repository;

import com.lifebank.lbpaymentssvc.pojo.database.LbTransferencesDetailPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenceDetailsRepository extends JpaRepository<LbTransferencesDetailPOJO, Integer> {
}
