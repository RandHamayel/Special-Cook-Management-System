package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String dietaryPreference;
    private List<String> allergies = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();
    private List<String> dietaryRestrictions = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }
    public void setAllergies(String allergy) {
        allergies.add(allergy);
        System.out.println("Allergy added.");
    }

    public List<String> getAllergies() {
        return allergies;
    }
    public void setDietaryPreference(String preference) {
        this.dietaryPreference = preference;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public void setOrderHistory(List<Order> orders) {
        this.orderHistory = orders;
    }


    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setDietaryRestrictions(List<String> restrictions) {
        this.dietaryRestrictions = restrictions;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }
}

