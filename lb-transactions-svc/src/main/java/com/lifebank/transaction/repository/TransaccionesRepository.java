package com.lifebank.transaction.repository;

import com.lifebank.transaction.pojo.database.ITransaction;
import com.lifebank.transaction.pojo.database.TransactionBlueprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TransaccionesRepository <T, ID> extends JpaRepository<T, ID> {
    public List<ITransaction> findTransaccionesOfProduct(String productId);
}
