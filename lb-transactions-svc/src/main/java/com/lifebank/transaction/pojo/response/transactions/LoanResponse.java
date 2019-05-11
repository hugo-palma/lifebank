package com.lifebank.transaction.pojo.response.transactions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "startDate",
        "endDate",
        "total",
        "debt",
        "interestRate",
        "interestAmount",
        "transactions"
})
public class LoanResponse implements IResponse{

    @JsonProperty("id")
    private String id;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("debt")
    private Double debt;
    @JsonProperty("interestRate")
    private Double interestRate;
    @JsonProperty("interestAmount")
    private Double interestAmount;
    @JsonProperty("transactions")
    private List<Transaction> transactions = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonProperty("debt")
    public Double getDebt() {
        return debt;
    }

    @JsonProperty("debt")
    public void setDebt(Double debt) {
        this.debt = debt;
    }

    @JsonProperty("interestRate")
    public Double getInterestRate() {
        return interestRate;
    }

    @JsonProperty("interestRate")
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @JsonProperty("interestAmount")
    public Double getInterestAmount() {
        return interestAmount;
    }

    @JsonProperty("interestAmount")
    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }

    @JsonProperty("transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
