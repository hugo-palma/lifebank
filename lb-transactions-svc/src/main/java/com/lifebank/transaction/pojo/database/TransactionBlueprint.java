package com.lifebank.transaction.pojo.database;

import org.springframework.data.annotation.Transient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class TransactionBlueprint {
    @Transient
    public String getSender(){throw new NotImplementedException();}
    @Transient
    public String getReceiver(){throw new NotImplementedException();}
    @Transient
    public String getDetails(){throw new NotImplementedException();}
}
