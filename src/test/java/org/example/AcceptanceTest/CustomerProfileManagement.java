package org.example.AcceptanceTest;

public class feature {
    private String name;
    private String dietaryPreferences;
    private String allergies;

    // Constructor
    public feature(String name, String dietaryPreferences, String allergies) {
        this.name = name;
        this.dietaryPreferences = dietaryPreferences;
        this.allergies = allergies;
    }

    // Getters and setters
    public String getDietaryPreferences() { return dietaryPreferences; }
    public String getAllergies() { return allergies; }
    public String getName() { return name; }
}
