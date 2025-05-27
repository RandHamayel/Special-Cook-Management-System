package org.example;



public class OrderInBilling {
    private static String orderType;
    private String customerId;
    private double amount;

    public OrderInBilling(String orderType, String customerId) {
        OrderInBilling.orderType = orderType;
        this.customerId = customerId;
        this.amount = amount;
    }

    public static String getOrderType() {
        return orderType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public static String getPaymentMethod() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setOrderType(String orderType) {
        OrderInBilling.orderType = orderType;
    }

    public void setPaymentMethod(String paymentMethod) {
    }
}
