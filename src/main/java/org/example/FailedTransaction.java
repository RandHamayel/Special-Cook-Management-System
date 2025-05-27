package org.example;

public class FailedTransaction {
    private String customerId;
    private double amount;
    private String reason;

    public FailedTransaction(String customerId, double amount, String reason) {
        this.customerId = customerId;
        this.amount = amount;
        this.reason = reason;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
}
}
