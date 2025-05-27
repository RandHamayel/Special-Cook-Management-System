package org.example;

import java.util.List;
import java.util.Map;

public class InventoryAndSupplierManagement {
    private String ingredient;
    private String reorderQuantity;
    private List<SupplierPrice> supplierPrices;
    private String criticalIngredient;
    private String checkTime;

    // Constructor
    public InventoryAndSupplierManagement() {}

    // ingredient
    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    // reorderQuantity
    public String getReorderQuantity() {
        return reorderQuantity;
    }
    public void setReorderQuantity(String reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    // supplierPrices
    public List<SupplierPrice> getSupplierPrices() {
        return supplierPrices;
    }
    public void setSupplierPrices(List<SupplierPrice> supplierPrices) {
        this.supplierPrices = supplierPrices;
    }

    // criticalIngredient
    public String getCriticalIngredient() {
        return criticalIngredient;
    }
    public void setCriticalIngredient(String criticalIngredient) {
        this.criticalIngredient = criticalIngredient;
    }

    // checkTime
    public String getCheckTime() {
        return checkTime;
    }
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    // Inner class to represent Supplier & Price
    public static class SupplierPrice {
        private String supplierName;
        private double pricePerLiter;

        public SupplierPrice() {}

        public SupplierPrice(String supplierName, double pricePerLiter) {
            this.supplierName = supplierName;
            this.pricePerLiter = pricePerLiter;
        }

        public String getSupplierName() {
            return supplierName;
        }
        public void setSupplierName(String supplierName) {
            this.supplierName = supplierName;
        }

        public double getPricePerLiter() {
            return pricePerLiter;
        }
        public void setPricePerLiter(double pricePerLiter) {
            this.pricePerLiter = pricePerLiter;
}
}
}

