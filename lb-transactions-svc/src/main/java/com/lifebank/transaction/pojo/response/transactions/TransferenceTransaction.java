package com.lifebank.transaction.pojo.response.transactions;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "date",
        "description",
        "amount"
})
public class TransferenceTransaction extends Transaction {


}
