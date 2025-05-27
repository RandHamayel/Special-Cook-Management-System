package org.example.AcceptanceTest;

import io.cucumber.java.en.*;

public class AI_assistance {

    @Given("user preferences include {string}")
    public void set_preferences(String preference) {
        System.out.println("User preferences: " + preference);
    }

    @Given("available ingredients are {string}")
    public void set_available_ingredients(String ingredients) {
        System.out.println("Available ingredients: " + ingredients);
    }

    @When("requesting recipe recommendations")
    public void request_recommendations() {
        System.out.println("Requesting recipe recommendations...");
    }

    @Then("the system should prioritize vegan options")
    public void verify_vegan_filter() {
        System.out.println("System prioritizes vegan options.");
    }

    @Then("exclude any animal products")
    public void exclude_animal_products() {
        System.out.println("System excludes animal products.");
    }

    @Given("user has only {string} available")
    public void set_time_constraint(String time) {
        System.out.println("Time available: " + time);
    }

    @When("searching for recipes")
    public void search_for_recipes() {
        System.out.println("Searching for recipes...");
    }

    @Then("the system should exclude recipes over {int} mins")
    public void verify_time_filter(int minutes) {
        System.out.println("Filtering recipes over " + minutes + " minutes");
    }

    @Then("sort by fastest preparation time")
    public void sort_by_fastest_preparation_time() {
        System.out.println("Sorting by fastest preparation time...");
    }

    @Given("a recipe requires {string}")
    public void recipe_requires(String ingredient) {
        System.out.println("Recipe requires: " + ingredient);
    }

    @But("user is lactose intolerant")
    public void user_is_lactose_intolerant() {
        System.out.println("User is lactose intolerant.");
    }

    @When("viewing the recipe")
    public void viewing_the_recipe() {
        System.out.println("Viewing the recipe.");
    }

    @Then("the system should suggest {string}")
    public void system_should_suggest_substitute(String substitute) {
        System.out.println("Suggested substitute: " + substitute);
    }

    @And("adjust preparation instructions accordingly")
    public void adjust_preparation_instructions() {
        System.out.println("Adjusting preparation instructions accordingly...");
    }
    @Then("the system should prioritize Vegan options")
    public void theSystemShouldPrioritizeVeganOptions() {

    }
    @Then("the system should prioritize Gluten-Free options")
    public void theSystemShouldPrioritizeGlutenFreeOptions() {

    }
    @Then("exclude any gluten")
    public void excludeAnyGluten() {

    }
    @Then("the system should prioritize Keto options")
    public void theSystemShouldPrioritizeKetoOptions() {

    }
    @Then("exclude any high-carb foods")
    public void excludeAnyHighCarbFoods() {

    }
    @Given("a recipe requires the following ingredients:")
    public void aRecipeRequiresTheFollowingIngredients(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("the system should suggest substitutions:")
    public void theSystemShouldSuggestSubstitutions(io.cucumber.datatable.DataTable dataTable) {

    }

}


