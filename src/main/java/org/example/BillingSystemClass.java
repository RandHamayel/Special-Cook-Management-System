package org.example;

import java.util.List;

public class BillingSystem {

    public void processOrder(Order order) {
        System.out.println("Processing order: " + order.getOrderType() + " using " + order.getPaymentMethod());
        generateInvoice(order);
    }

    public void generateInvoice(Order order) {
        System.out.println("Generating PDF invoice for: " + order.getOrderType());
        System.out.println("Emailing invoice to customer...");
    }

    public void generateMonthlyReport() {
        System.out.println("Creating monthly revenue breakdown...");
        System.out.println("Showing comparison to previous month...");
    }

    public void handleFailedPayments(List<FailedTransaction> failedTransactions) {
        System.out.println("Retrying failed transactions after 24 hours...");
        for (FailedTransaction tx : failedTransactions) {
            System.out.println("Notifying customer " + tx.getCustomerId() + " about failed payment of $" + tx.getAmount() + " (Reason: " + tx.getReason() + ")");
            System.out.println("Suspending delivery for customer " + tx.getCustomerId());
}
}
}

