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
        "limit",
        "available",
        "interestRate",
        "interestAmount",
        "MonthlyCut",
        "transactions"
})
public class CreditCardResponse implements IResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("limit")
    private Double limit;
    @JsonProperty("available")
    private Double available;
    @JsonProperty("interestRate")
    private Double interestRate;
    @JsonProperty("interestAmount")
    private Double interestAmount;
    @JsonProperty("MonthlyCut")
    private Integer monthlyCut;
    @JsonProperty("transactions")
    private List<Transaction> transactions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("limit")
    public Double getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @JsonProperty("available")
    public Double getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Double available) {
        this.available = available;
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

    @JsonProperty("MonthlyCut")
    public Integer getMonthlyCut() {
        return monthlyCut;
    }

    @JsonProperty("MonthlyCut")
    public void setMonthlyCut(Integer monthlyCut) {
        this.monthlyCut = monthlyCut;
    }

    @JsonProperty("transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
