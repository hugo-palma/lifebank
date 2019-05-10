package com.lifebank.transaction.pojo.database;

import org.springframework.data.annotation.Transient;

public interface ITransaction {
    @Transient
    public String getSender();
    @Transient
    public String getReceiver();
    @Transient
    public String getDetails();
}
