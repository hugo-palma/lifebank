package com.lifebank.transaction.factory.response;

import com.lifebank.transaction.pojo.response.transactions.IResponse;
import com.lifebank.transaction.pojo.response.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IResponseFactory {
    public void setData(JpaRepository productRepository, String productId, String startDate, String endDate, List<Transaction> transactions);
    public IResponse getResponse();
}
