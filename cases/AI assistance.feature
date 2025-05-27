Feature: AI Recipe Recommendation
  As a customer
  I want smart recipe suggestions
  Based on my preferences and available ingredients

  Scenario Outline: Personalized recipe suggestion based on preference and ingredients
    Given user preferences include "<preference>"
    And available ingredients are "<ingredients>"
    When requesting recipe recommendations
    Then the system should prioritize <preference> options
    And exclude any <excluded_items>

    Examples:
      | preference | ingredients               | excluded_items     |
      | Vegan      | Tomatoes, Pasta, Basil    | animal products    |
      | Gluten-Free| Rice, Chicken, Vegetables | gluten             |
      | Keto       | Eggs, Avocado, Cheese     | high-carb foods    |

  Scenario: Time-based filtering
    Given user has only "30 minutes" available
    When searching for recipes
    Then the system should exclude recipes over 30 mins
    And sort by fastest preparation time

  Scenario: Ingredient substitution
    Given a recipe requires the following ingredients:
      | Ingredient |
      | cream      |
      | butter     |
      | milk       |
    But user is lactose intolerant
    When viewing the recipe
    Then the system should suggest substitutions:
      | Original     | Substitute      |
      | cream        | coconut cream   |
      | butter       | olive oil       |
      | milk         | almond milk     |
    And adjust preparation instructions accordingly
