package com.lifebank.lbproductssvc.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "accounts"
})
public class ProductsResponse {

    @JsonProperty("accounts")
    private Accounts accounts;

    @JsonProperty("accounts")
    public Accounts getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

}
