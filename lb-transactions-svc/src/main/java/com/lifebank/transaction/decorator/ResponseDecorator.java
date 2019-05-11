package com.lifebank.transaction.decorator;

import com.lifebank.transaction.pojo.response.transactions.IResponse;

public interface ResponseDecorator {
    public IResponse getDecoratedResponse();
}
