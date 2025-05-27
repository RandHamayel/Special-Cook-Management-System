Feature: Order and Menu Customization
  As a customer
  I want to customize my meals
  So that they match my dietary needs and preferences

  Scenario Outline: Customize meal ingredients with different changes
    Given a customer is viewing a <dish> dish
    When they remove "<removeItem>" and add "<addItem>"
    Then the system should update the recipe
    And show the modified ingredient list

    Examples:
      | dish  | removeItem | addItem    |
      | pasta | cheese     | mushrooms  |
      | salad | croutons   | avocado    |
      | soup  | cream      | tofu       |

  Scenario: System suggests substitutions for dairy allergies
    Given a customer is allergic to dairy
    When they select a recipe containing "milk"
    Then the system should suggest the following alternatives:
      | Original Ingredient | Suggested Substitute |
      | milk                | almond milk          |
      | butter              | olive oil            |
      | cheese              | nutritional yeast    |
    And highlight the substitution in yellow

  Scenario: Chef approves substitutions
    Given a chef receives a substitution alert
    When they review the changed recipe
    Then they can approve or modify the substitution
    And the customer should receive notification of the change
