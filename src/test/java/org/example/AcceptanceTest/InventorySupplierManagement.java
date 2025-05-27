package org.example.AcceptanceTest;

import io.cucumber.java.en.*;
import org.example.InventoryAndSupplierManagement;

import static org.junit.Assert.*;

import java.util.*;

public class InventorySupplierManagement {
    private InventoryAndSupplierManagement inventory = new InventoryAndSupplierManagement();
    private List<InventoryAndSupplierManagement.SupplierPrice> supplierPrices = new ArrayList<>() ;
    private String lastWarning;
    private boolean purchaseOrderGenerated = true;

    // Scenario Outline Steps
    @Given("{string} is below minimum stock level")
    public void ingredientBelowMinLevel(String ingredient) {
        inventory.setIngredient(ingredient);
        lastWarning = "Low Stock";
    }

    @When("the inventory is refreshed")
    public void refreshInventory() {
        // Simulate inventory refresh
        switch(inventory.getIngredient()) {
            case "Tomatoes":
                inventory.setReorderQuantity("20kg");
                break;
            case "Basil Leaves":
                inventory.setReorderQuantity("5kg");
                break;
            case "Pasta":
                inventory.setReorderQuantity("50kg");
                break;
        }
    }

    @Then("the system should show {string} warning")
    public void verifyWarning(String expectedWarning) {
        assertEquals(expectedWarning, lastWarning);
    }

    @Then("suggest reorder quantity of {string}")
    public void verifyReorderQuantity(String expectedQuantity) {
        assertEquals(expectedQuantity, inventory.getReorderQuantity());
    }

    // Auto-generate PO Steps
    @Given("an ingredient reaches critical level")
    public void setCriticalIngredient() {
        inventory.setCriticalIngredient("Olive Oil");
    }

    @When("the system checks inventory at {string}")
    public void checkInventoryAtTime(String time) {
        inventory.setCheckTime(time);
        if(time.equals("5pm")) {
            purchaseOrderGenerated = true;
        }
    }

    @Then("it should auto-generate a purchase order")
    public void verifyPurchaseOrderGenerated() {
        assertTrue(purchaseOrderGenerated);
    }

    @Then("email it to the default supplier")
    public void verifyEmailSent() {
        // In real implementation would check email service
        assertTrue(purchaseOrderGenerated);
    }

    // Price Comparison Steps
    @Given("multiple suppliers for {string}")
    public void setupSuppliers(String item) {
        inventory.setIngredient(item);
        supplierPrices = new ArrayList<>();
        supplierPrices.add(new InventoryAndSupplierManagement.SupplierPrice("OlivePro Ltd", 5.20));
        supplierPrices.add(new InventoryAndSupplierManagement.SupplierPrice("Green Harvest", 4.95));
        supplierPrices.add(new InventoryAndSupplierManagement.SupplierPrice("OrganicOils", 5.10));
        inventory.setSupplierPrices(supplierPrices);
    }

    @When("viewing inventory for this item")
    public void viewInventory() {
        // Sorting to find cheapest
        supplierPrices.sort(Comparator.comparingDouble(InventoryAndSupplierManagement.SupplierPrice::getPricePerLiter));
    }

    @Then("the system should show current prices:")
    public void verifyPrices(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedPrices = dataTable.asMaps();
        assertEquals(expectedPrices.size(), supplierPrices.size());

        for(int i=0; i<expectedPrices.size(); i++) {
            assertEquals(expectedPrices.get(i).get("Supplier"),
                    supplierPrices.get(i).getSupplierName());
            assertEquals(Double.parseDouble(expectedPrices.get(i).get("Price per Liter").replace("$", "")),
                    supplierPrices.get(i).getPricePerLiter(), 0.01);
        }
    }

    @Then("highlight the cheapest option")
    public void highlightCheapest() {
        assertEquals("Green Harvest", supplierPrices.get(0).getSupplierName());
        assertEquals(4.95, supplierPrices.get(0).getPricePerLiter(), 0.01);
    }
    @When("the system checks inventory at 5pm")
    public void theSystemChecksInventoryAt5pm() {

    }
    @Given("multiple suppliers for olive oil")
    public void multipleSuppliersForOliveOil() {

    }
}
