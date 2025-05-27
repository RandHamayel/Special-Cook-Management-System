package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.OrderAndMenuCustomization;
import org.example.Chef;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class OrderMenuCustomization {

    private List<String> initialIngredients;
    private List<String> modifiedIngredients;
    private Map<String, String> suggestedSubs;
    private OrderAndMenuCustomization orderSystem;
    private boolean chefApproved;

    @Given("a customer is viewing a pasta dish")
    public void aCustomerIsViewingAPastaDish() {
        initialIngredients = new ArrayList<>(Arrays.asList("cheese", "tomato", "basil"));
        orderSystem = new OrderAndMenuCustomization("pasta", initialIngredients);
    }
    @Given("a customer is viewing a salad dish")
    public void aCustomerIsViewingASaladDish() {
        initialIngredients = new ArrayList<>(Arrays.asList("croutons", "lettuce", "tomato"));
        orderSystem = new OrderAndMenuCustomization("salad", initialIngredients);
    }
    @Given("a customer is viewing a soup dish")
    public void aCustomerIsViewingASoupDish() {
        initialIngredients = new ArrayList<>(Arrays.asList("cream", "carrot", "celery"));
        orderSystem = new OrderAndMenuCustomization("soup", initialIngredients);
    }

    @When("they remove {string} and add {string}")
    public void theyRemoveAndAdd(String removeItem, String addItem) {
        orderSystem.updateIngredients(removeItem, addItem);
        modifiedIngredients = orderSystem.getIngredients();

    }
    @Then("the system should update the recipe")
    public void theSystemShouldUpdateTheRecipe() {
        assertNotNull(modifiedIngredients);
        assertFalse(modifiedIngredients.isEmpty());

    }
    @Then("show the modified ingredient list")
    public void showTheModifiedIngredientList() {
        System.out.println("Modified Ingredients: " + modifiedIngredients);
        assertTrue(modifiedIngredients.containsAll(orderSystem.getIngredients()));

    }

    @Given("a customer is allergic to dairy")
    public void aCustomerIsAllergicToDairy() {
        initialIngredients = Arrays.asList("milk", "butter", "cheese");
        orderSystem = new OrderAndMenuCustomization("customDish", initialIngredients);
        orderSystem.setDairyAllergy(true);

    }
    @When("they select a recipe containing {string}")
    public void theySelectARecipeContaining(String dairyItem) {
        assertTrue(orderSystem.getIngredients().contains(dairyItem));

    }
    @Then("the system should suggest the following alternatives:")
    public void theSystemShouldSuggestTheFollowingAlternatives(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedSubs = dataTable.asMaps();
        suggestedSubs = orderSystem.getSubstitutionSuggestions();
        for (Map<String, String> row : expectedSubs) {
            String original = row.get("Original Ingredient");
            String suggested = row.get("Suggested Substitute");
            assertEquals(suggested, suggestedSubs.get(original));
        }

    }
    @Then("highlight the substitution in yellow")
    public void highlightTheSubstitutionInYellow() {
        System.out.println("Highlighting substitutions in yellow: " + suggestedSubs);
        assertFalse(suggestedSubs.isEmpty());

    }
    @Given("a chef receives a substitution alert")
    public void aChefReceivesASubstitutionAlert() {
        initialIngredients = Arrays.asList("milk", "cheese");
        orderSystem = new OrderAndMenuCustomization("pizza", initialIngredients);
        orderSystem.setDairyAllergy(true);

    }
    @Then("they can approve or modify the substitution")
    public void chefApprovesOrModifies() {
        orderSystem.chefApprove(true);
        chefApproved = orderSystem.isChefApproval();
        assertTrue(chefApproved);
    }

    @Then("the customer should receive notification of the change")
    public void customerGetsNotified() {
        List<String> notifications = orderSystem.getCustomerNotifications();
        assertTrue(notifications.contains("Chef approved the substitutions."));
    }
    @When("they review the changed recipe")
    public void theyReviewTheChangedRecipe() {

        List<String> reviewedRecipe = orderSystem.getIngredients();

        Chef.setReviewedIngredients(reviewedRecipe);
    }
}
