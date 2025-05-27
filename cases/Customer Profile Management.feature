Feature: Customer Profile Management
  As a user of the meal system
  I want to manage dietary preferences and order history
  So that I can get personalized meal recommendations

  Scenario Outline: Store different dietary preferences
    Given a customer is logged in
    When they update their profile with "<dietaryPreference>" dietary preference
    Then the system should save these preferences
    And show confirmation message "Preferences saved successfully"

    Examples:
      | dietaryPreference |
      | Vegan             |
      | Gluten-Free       |
      | Keto              |
      | Vegetarian        |

  Scenario: View past orders
    Given a customer has ordered meals before
    When they navigate to "Order History"
    Then the system should display the following orders:
      | Date       | Items                      | Total Price |
      | 2025-05-01 | Vegan Burger, Salad        | 12.99       |
      | 2025-04-28 | Tofu Stir-fry              | 10.50       |
      | 2025-04-25 | Lentil Soup, Bread         | 9.75        |
      | 2025-04-23 | Pasta Primavera            | 11.40       |
      | 2025-04-20 | Grilled Veggie Wrap        | 8.95        |


  Scenario: Chef views customer preferences
    Given a chef is logged in
    When they select a customer profile
    Then the system should display dietary restrictions
