Feature: Inventory Management
  As a kitchen manager
  I want to track ingredients
  So that we never run out of stock

  Scenario : Low stock alert for different ingredients
    Given <ingredient> is below minimum stock level
    When the inventory is refreshed
    Then the system should show "Low Stock" warning
    And suggest reorder quantity of <reorderQuantity>



  Scenario: Auto-generate purchase order
    Given an ingredient reaches critical level
    When the system checks inventory at 5pm
    Then it should auto-generate a purchase order
    And email it to the default supplier

  Scenario: Real-time price comparison
    Given multiple suppliers for "olive oil"
    When viewing inventory for this item
    Then the system should show current prices:
      | Supplier       | Price per Liter |
      | Green Harvest  | $4.95           |
      | OrganicOils    | $5.10           |
      | OlivePro Ltd   | $5.20           |
    And highlight the cheapest option
