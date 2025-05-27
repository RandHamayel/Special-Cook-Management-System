package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderAndMenuCustomization {

    private String dish;
    private List<String> ingredients = new ArrayList<>();
    private boolean dairyAllergy;
    private Map<String, String> substitutionSuggestions = new HashMap<>();
    private boolean chefApproval;
    private List<String> customerNotifications = new ArrayList<>();

    public OrderAndMenuCustomization(String dish, List<String> initialIngredients) {
        this.dish = dish;
        this.ingredients.addAll(initialIngredients);
        this.chefApproval = false;
        this.dairyAllergy = false;
    }

    public String getDish() {
        return dish;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean isDairyAllergy() {
        return dairyAllergy;
    }

    public void setDairyAllergy(boolean dairyAllergy) {
        this.dairyAllergy = dairyAllergy;
        if (dairyAllergy) {
            addDairySubstitutionSuggestions();
        }
    }

    public Map<String, String> getSubstitutionSuggestions() {
        return new HashMap<>(substitutionSuggestions);
    }

    public boolean isChefApproval() {
        return chefApproval;
    }

    public List<String> getCustomerNotifications() {
        return new ArrayList<>(customerNotifications);
    }

    public void removeIngredient(String item) {
        if (ingredients.remove(item)) {
            customerNotifications.add("Removed ingredient: " + item);
        } else {
            customerNotifications.add("Ingredient to remove not found: " + item);
        }
    }


    public void addIngredient(String item) {
        ingredients.add(item);
        customerNotifications.add("Added ingredient: " + item);
    }

    public void updateIngredients(String removeItem, String addItem) {
        removeIngredient(removeItem);
        addIngredient(addItem);
    }

    private void addDairySubstitutionSuggestions() {
        substitutionSuggestions.put("milk", "almond milk");
        substitutionSuggestions.put("butter", "olive oil");
        substitutionSuggestions.put("cheese", "nutritional yeast");
    }

    public void chefApprove(boolean approval) {
        this.chefApproval = approval;
        if (approval) {
            customerNotifications.add("Chef approved the substitutions.");
        } else {
            customerNotifications.add("Chef rejected/modifies the substitutions.");
        }
    }

}
