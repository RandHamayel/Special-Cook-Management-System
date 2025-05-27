package org.example;

import java.util.List;

public class Chef {
    private String name;

    public Chef(String name) {
        this.name = name;
    }

    public static void setReviewedIngredients(List<String> reviewedRecipe) {
    }

    public void viewCustomerProfile(Customer customer) {
        // Simulate viewing profile
        System.out.println("Viewing profile of " + customer);
    }
}

