package com.lifebank.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TransaccionesRepository <T, ID> extends JpaRepository<T, ID> {
    public List<T> findTransaccionesOfProduct(String productId);
}
