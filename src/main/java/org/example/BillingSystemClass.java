package org.example;

import java.util.List;
import org.example.OrderInBilling;


public class BillingSystemClass {

    public void processOrder(OrderInBilling order) {

        System.out.println("Processing order: " + OrderInBilling.getOrderType() + " using " + OrderInBilling.getPaymentMethod());
        generateInvoice(order);
    }

    public void generateInvoice(OrderInBilling order) {
        System.out.println("Generating PDF invoice for: " + OrderInBilling.getOrderType());
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

