Feature: Scheduling and Task Management
  As kitchen staff
  I want to manage cooking tasks efficiently
  So that meals are prepared on time

  Scenario : Assign cooking tasks to chefs
    Given a kitchen manager is logged in
    When they assign "<Task>" to Chef <ChefName>
    Then the system should update Chef <ChefName>'s task list
    And send him a notification


  Scenario: Chef receives task notification
    Given a chef has pending tasks
    When a new task is assigned to them
    Then they should receive a mobile notification
    And see the task in their dashboard

  Scenario: View workload balance
    Given the kitchen manager views the staff schedule
    When they check "Current Workload"
    Then the system should show tasks per chef:
      | Chef Name | Assigned Tasks |
      | John      | 5              |
      | Alice     | 3              |
      | Ahmed     | 6              |

