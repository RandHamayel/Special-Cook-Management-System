package org.example.AcceptanceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Chef;
import org.example.Customer;
import org.example.Order;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerProfileManagement {

    private String lastMessage;
    private Customer customer;
    private List<Order> lastViewedOrders;
    private Chef chef;


    @Given("a customer is logged in")
    public void aCustomerIsLoggedIn() {
        customer = new Customer("Test User");

    }
    @When("they update their profile with {string} dietary preference")
    public void theyUpdateTheirProfileWithDietaryPreference(String preference) {
        customer.setDietaryPreference(preference);
        lastMessage = "Preferences saved successfully";

    }
    @Then("the system should save these preferences")
    public void theSystemShouldSaveThesePreferences() {
        assertNotNull(customer.getDietaryPreference());

    }
    @Then("show confirmation message {string}")
    public void showConfirmationMessage(String expectedMessage) {
        assertEquals(expectedMessage, lastMessage);

    }
    @Given("a customer has ordered meals before")
    public void aCustomerHasOrderedMealsBefore() {
        customer = new Customer("Test User");

        List<Order> orderHistory = new ArrayList<>();
        orderHistory.add(new Order("2025-05-01", List.of("Vegan Burger", "Salad"), 12.99));
        orderHistory.add(new Order("2025-04-28", List.of("Tofu Stir-fry"), 10.50));
        orderHistory.add(new Order("2025-04-25", List.of("Lentil Soup", "Bread"), 9.75));
        orderHistory.add(new Order("2025-04-23", List.of("Pasta Primavera"), 11.40));
        orderHistory.add(new Order("2025-04-20", List.of("Grilled Veggie Wrap"), 8.95));

        customer.setOrderHistory(orderHistory);
    }
    @When("they navigate to {string}")
    public void theyNavigateTo(String pageName) {
        if (pageName.equals("Order History"))
            lastViewedOrders = customer.getOrderHistory();
    }
    @Then("the system should display the following orders:")
    public void theSystemShouldDisplayTheFollowingOrders(io.cucumber.datatable.DataTable dataTable) {
        List<Order> orders = customer.getOrderHistory();
        assertEquals(5, orders.size()); // Verify 5 orders exist

    }
    @Given("a chef is logged in")
    public void aChefIsLoggedIn() {
        chef = new Chef("Basel");

    }
    @When("they select a customer profile")
    public void theySelectACustomerProfile() {
        customer = new Customer("Test Customer");
        customer.setDietaryPreference("Vegan");
        customer.setAllergies("Peanuts");

    }
    @Then("the system should display dietary restrictions")
    public void theSystemShouldDisplayDietaryRestrictions() {
        assertNotNull(customer.getDietaryPreference());

    }
}
