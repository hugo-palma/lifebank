package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.LbTransferencesDetailPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenceDetailsRepository extends JpaRepository<LbTransferencesDetailPOJO, Integer> {
}
