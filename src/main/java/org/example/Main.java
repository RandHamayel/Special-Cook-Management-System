package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BillingSystemClass billingSystem = new BillingSystemClass();
    private static OrderAndMenuCustomization orderCustomization;
    private static final SchedulingAndTaskManagement taskManager = new SchedulingAndTaskManagement();
    private static final InventoryAndSupplierManagement inventoryManager = new InventoryAndSupplierManagement();
    private static final Map<String, Chef> chefs = new HashMap<>();
    private static final Map<String, Customer> customers = new HashMap<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final List<FailedTransaction> failedTransactions = new ArrayList<>();

    public static void main(String[] args) {
        initializeSampleData();
        showMainMenu();
    }

    private static void initializeSampleData() {
        // Initialize some sample chefs
        Chef chef1 = new Chef("Gordon Ramsay");
        Chef chef2 = new Chef("Jamie Oliver");
        chefs.put("gordon", chef1);
        chefs.put("jamie", chef2);

        // Initialize some sample customers
        Customer customer1 = new Customer("John Doe");
        customer1.setDietaryPreference("Vegetarian");
        customer1.setAllergies("Peanuts");
        customers.put("john", customer1);

        Customer customer2 = new Customer("Jane Smith");
        customer2.setDietaryPreference("Vegan");
        customer2.setAllergies("Dairy");
        customers.put("jane", customer2);

        // Initialize some sample orders
        orders.add(new Order("2023-05-01", List.of("Vegan Burger", "Salad"), 15.99));
        orders.add(new Order("2023-05-02", List.of("Pasta", "Garlic Bread"), 12.50));

        // Initialize some sample failed transactions
        failedTransactions.add(new FailedTransaction("john", 15.99, "Insufficient funds"));
        failedTransactions.add(new FailedTransaction("jane", 12.50, "Card expired"));

        // Initialize order customization
        orderCustomization = new OrderAndMenuCustomization("Vegan Burger",
                List.of("Bun", "Vegan Patty", "Lettuce", "Tomato"));
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== RESTAURANT MANAGEMENT SYSTEM ===");
            System.out.println("1. Billing System");
            System.out.println("2. Chef Operations");
            System.out.println("3. Customer Management");
            System.out.println("4. Order Customization");
            System.out.println("5. Scheduling & Task Management");
            System.out.println("6. Inventory & Supplier Management");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    billingSystemMenu();
                    break;
                case 2:
                    chefOperationsMenu();
                    break;
                case 3:
                    customerManagementMenu();
                    break;
                case 4:
                    orderCustomizationMenu();
                    break;
                case 5:
                    schedulingMenu();
                    break;
                case 6:
                    inventoryMenu();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void billingSystemMenu() {
        System.out.println("\n=== BILLING SYSTEM ===");
        System.out.println("1. Process Order");
        System.out.println("2. Generate Monthly Report");
        System.out.println("3. Handle Failed Payments");
        System.out.println("4. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter order type: ");
                String orderType = scanner.nextLine();
                System.out.print("Enter customer ID: ");
                String customerId = scanner.nextLine();

                OrderInBilling order = new OrderInBilling(orderType, customerId);
                billingSystem.processOrder(order);
                break;
            case 2:
                billingSystem.generateMonthlyReport();
                break;
            case 3:
                billingSystem.handleFailedPayments(failedTransactions);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void chefOperationsMenu() {
        System.out.println("\n=== CHEF OPERATIONS ===");
        System.out.println("1. View Customer Profile");
        System.out.println("2. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter chef name: ");
                String chefName = scanner.nextLine();
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();

                Chef chef = chefs.get(chefName.toLowerCase());
                Customer customer = customers.get(customerName.toLowerCase());

                if (chef != null && customer != null) {
                    chef.viewCustomerProfile(customer);
                } else {
                    System.out.println("Chef or customer not found.");
                }
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void customerManagementMenu() {
        System.out.println("\n=== CUSTOMER MANAGEMENT ===");
        System.out.println("1. Add New Customer");
        System.out.println("2. View Customer Details");
        System.out.println("3. Add Allergy to Customer");
        System.out.println("4. Set Dietary Preference");
        System.out.println("5. View Order History");
        System.out.println("6. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                customers.put(name.toLowerCase(), new Customer(name));
                System.out.println("Customer added successfully.");
                break;
            case 2:
                System.out.print("Enter customer name: ");
                String viewName = scanner.nextLine();
                Customer viewCustomer = customers.get(viewName.toLowerCase());
                if (viewCustomer != null) {
                    System.out.println("Name: " + viewName);
                    System.out.println("Dietary Preference: " + viewCustomer.getDietaryPreference());
                    System.out.println("Allergies: " + viewCustomer.getAllergies());
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 3:
                System.out.print("Enter customer name: ");
                String allergyName = scanner.nextLine();
                System.out.print("Enter allergy: ");
                String allergy = scanner.nextLine();

                Customer allergyCustomer = customers.get(allergyName.toLowerCase());
                if (allergyCustomer != null) {
                    allergyCustomer.setAllergies(allergy);
                    System.out.println("Allergy added successfully.");
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 4:
                System.out.print("Enter customer name: ");
                String prefName = scanner.nextLine();
                System.out.print("Enter dietary preference: ");
                String preference = scanner.nextLine();

                Customer prefCustomer = customers.get(prefName.toLowerCase());
                if (prefCustomer != null) {
                    prefCustomer.setDietaryPreference(preference);
                    System.out.println("Dietary preference set successfully.");
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 5:
                System.out.print("Enter customer name: ");
                String historyName = scanner.nextLine();
                Customer historyCustomer = customers.get(historyName.toLowerCase());
                if (historyCustomer != null) {
                    List<Order> customerOrders = historyCustomer.getOrderHistory();
                    if (customerOrders.isEmpty()) {
                        System.out.println("No order history found.");
                    } else {
                        System.out.println("Order History:");
                        for (Order order : customerOrders) {
                            System.out.println(order.getDate() + " - " +
                                    order.getItems() + " - $" + order.getTotalPrice());
                        }
                    }
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void orderCustomizationMenu() {
        System.out.println("\n=== ORDER CUSTOMIZATION ===");
        System.out.println("1. View Current Dish");
        System.out.println("2. Remove Ingredient");
        System.out.println("3. Add Ingredient");
        System.out.println("4. Update Ingredients (Replace)");
        System.out.println("5. Set Dairy Allergy");
        System.out.println("6. View Substitution Suggestions");
        System.out.println("7. Chef Approval");
        System.out.println("8. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Current Dish: " + orderCustomization.getDish());
                System.out.println("Ingredients: " + orderCustomization.getIngredients());
                break;
            case 2:
                System.out.print("Enter ingredient to remove: ");
                String removeItem = scanner.nextLine();
                orderCustomization.removeIngredient(removeItem);
                System.out.println("Ingredient removed.");
                break;
            case 3:
                System.out.print("Enter ingredient to add: ");
                String addItem = scanner.nextLine();
                orderCustomization.addIngredient(addItem);
                System.out.println("Ingredient added.");
                break;
            case 4:
                System.out.print("Enter ingredient to remove: ");
                String oldItem = scanner.nextLine();
                System.out.print("Enter new ingredient: ");
                String newItem = scanner.nextLine();
                orderCustomization.updateIngredients(oldItem, newItem);
                System.out.println("Ingredients updated.");
                break;
            case 5:
                orderCustomization.setDairyAllergy(true);
                System.out.println("Dairy allergy flag set. Substitution suggestions generated.");
                break;
            case 6:
                System.out.println("Substitution Suggestions:");
                orderCustomization.getSubstitutionSuggestions().forEach((k, v) ->
                        System.out.println(k + " → " + v));
                break;
            case 7:
                System.out.print("Approve modifications? (true/false): ");
                boolean approval = scanner.nextBoolean();
                orderCustomization.chefApprove(approval);
                System.out.println("Approval status set.");
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void schedulingMenu() {
        System.out.println("\n=== SCHEDULING & TASK MANAGEMENT ===");
        System.out.println("1. Assign Task to Chef");
        System.out.println("2. View Chef Tasks");
        System.out.println("3. View Chef Notifications");
        System.out.println("4. View Workload Distribution");
        System.out.println("5. Identify Overworked Chefs");
        System.out.println("6. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter chef name: ");
                String chefName = scanner.nextLine();
                System.out.print("Enter task: ");
                String task = scanner.nextLine();
                taskManager.assignTaskToChef(task, chefName);
                System.out.println("Task assigned.");
                break;
            case 2:
                System.out.print("Enter chef name: ");
                String taskChef = scanner.nextLine();
                List<String> tasks = taskManager.getTasksForChef(taskChef);
                System.out.println("Tasks for " + taskChef + ":");
                tasks.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Enter chef name: ");
                String notifyChef = scanner.nextLine();
                List<String> notifications = taskManager.getNotificationsForChef(notifyChef);
                System.out.println("Notifications for " + notifyChef + ":");
                notifications.forEach(System.out::println);
                break;
            case 4:
                Map<String, Integer> workload = taskManager.getWorkloadPerChef();
                System.out.println("Workload Distribution:");
                workload.forEach((k, v) -> System.out.println(k + ": " + v + " tasks"));
                break;
            case 5:
                System.out.print("Enter threshold for overwork: ");
                int threshold = scanner.nextInt();
                List<String> overworked = taskManager.getOverworkedChefs(threshold);
                System.out.println("Overworked Chefs:");
                overworked.forEach(System.out::println);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void inventoryMenu() {
        System.out.println("\n=== INVENTORY & SUPPLIER MANAGEMENT ===");
        System.out.println("1. Set Ingredient");
        System.out.println("2. Set Reorder Quantity");
        System.out.println("3. Set Critical Ingredient");
        System.out.println("4. Set Check Time");
        System.out.println("5. View Current Inventory Settings");
        System.out.println("6. Return to Main Menu");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter ingredient: ");
                inventoryManager.setIngredient(scanner.nextLine());
                System.out.println("Ingredient set.");
                break;
            case 2:
                System.out.print("Enter reorder quantity: ");
                inventoryManager.setReorderQuantity(scanner.nextLine());
                System.out.println("Reorder quantity set.");
                break;
            case 3:
                System.out.print("Enter critical ingredient: ");
                inventoryManager.setCriticalIngredient(scanner.nextLine());
                System.out.println("Critical ingredient set.");
                break;
            case 4:
                System.out.print("Enter check time: ");
                inventoryManager.setCheckTime(scanner.nextLine());
                System.out.println("Check time set.");
                break;
            case 5:
                System.out.println("Current Inventory Settings:");
                System.out.println("Ingredient: " + inventoryManager.getIngredient());
                System.out.println("Reorder Quantity: " + inventoryManager.getReorderQuantity());
                System.out.println("Critical Ingredient: " + inventoryManager.getCriticalIngredient());
                System.out.println("Check Time: " + inventoryManager.getCheckTime());
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
}