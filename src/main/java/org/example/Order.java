package org.example;

import java.util.List;

public class Order {
    private String date;
    private List<String> items;
    private double totalPrice;

    public Order(String date, List<String> items, double totalPrice) {
        this.date = date;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}