package org.example.AcceptanceTest;

import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import org.example.SchedulingAndTaskManagement;
import org.junit.jupiter.api.Assertions;

public class SchedulingTaskManagement {

    SchedulingAndTaskManagement system = new SchedulingAndTaskManagement();
    String currentChef;
    String currentTask;

    @Given("a kitchen manager is logged in")
    public void kitchenManagerIsLoggedIn() {
        // You can simulate login logic if needed
        System.out.println("Kitchen manager logged in.");
    }

    @When("they assign {string} to Chef {string}")
    public void theyAssignTaskToChef(String task, String chefName) {
        currentChef = chefName;
        currentTask = task;
        system.assignTaskToChef(task, chefName);
    }

    @Then("the system should update Chef {string}'s task list")
    public void systemShouldUpdateChefTaskList(String chefName) {
        List<String> tasks = system.getTasksForChef(chefName);

    }

    @Then("send him a notification")
    public void sendHimNotification() {
        List<String> notifications = system.getNotificationsForChef(currentChef);
        Assertions.assertTrue(notifications.stream().anyMatch(n -> n.contains(currentTask)),
                "Expected notification not found.");
    }

    @Given("a chef has pending tasks")
    public void chefHasPendingTasks() {
        system.assignTaskToChef("Cut Vegetables", "Ahmed");
    }

    @When("a new task is assigned to them")
    public void newTaskAssignedToThem() {
        system.assignTaskToChef("Clean Station", "Ahmed");
    }

    @Then("they should receive a mobile notification")
    public void receiveMobileNotification() {
        List<String> notes = system.getNotificationsForChef("Ahmed");
        Assertions.assertTrue(notes.contains("New task assigned: Clean Station"));
    }

    @Then("see the task in their dashboard")
    public void seeTaskInDashboard() {
        List<String> tasks = system.getTasksForChef("Ahmed");
        Assertions.assertTrue(tasks.contains("Clean Station"));
    }

    @Given("the kitchen manager views the staff schedule")
    public void kitchenManagerViewsSchedule() {
        system.assignTaskToChef("Dish 1", "John");
        system.assignTaskToChef("Dish 2", "John");
        system.assignTaskToChef("Dish 3", "John");
        system.assignTaskToChef("Dish 4", "John");
        system.assignTaskToChef("Dish 5", "John");

        system.assignTaskToChef("Grill", "Alice");
        system.assignTaskToChef("Sauce", "Alice");
        system.assignTaskToChef("Serve", "Alice");

        system.assignTaskToChef("Bread", "Ahmed");
        system.assignTaskToChef("Soup", "Ahmed");
        system.assignTaskToChef("Fish", "Ahmed");
        system.assignTaskToChef("Salad", "Ahmed");
        system.assignTaskToChef("Pasta", "Ahmed");
        system.assignTaskToChef("Dessert", "Ahmed");
    }

    @When("they check {string}")
    public void theyCheckCurrentWorkload(String label) {
        System.out.println("Checking: " + label);
    }

    @Then("the system should show tasks per chef:")
    public void systemShouldShowTasksPerChef(io.cucumber.datatable.DataTable dataTable) {
        Map<String, Integer> actualWorkload = system.getWorkloadPerChef();

        List<Map<String, String>> expected = dataTable.asMaps();

        for (Map<String, String> row : expected) {
            String chefName = row.get("Chef Name");
            int expectedTasks = Integer.parseInt(row.get("Assigned Tasks"));
            int actualTasks = actualWorkload.getOrDefault(chefName, -1);
            Assertions.assertEquals(expectedTasks, actualTasks,
                    "Mismatch in task count for " + chefName);
        }
    }

    @Then("highlight overworked staff in orange")
    public void highlightOverworkedStaff() {
        List<String> overworked = system.getOverworkedChefs(5);
        Assertions.assertTrue(overworked.contains("Ahmed"),
                "Ahmed should be considered overworked.");
    }
}

