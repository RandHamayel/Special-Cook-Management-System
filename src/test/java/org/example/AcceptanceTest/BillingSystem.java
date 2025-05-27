package org.example.AcceptanceTest;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.example.BillingSystemClass;
import org.example.FailedTransaction;
import org.example.Order;
import org.example.OrderInBilling;

import java.util.List;
import java.util.stream.Collectors;

public class BillingSystem {

    @Given("an order is completed with physical goods")
    public void anOrderIsCompletedWithPhysicalGoods() {

    }
    @Given("the payment method is credit card")
    public void thePaymentMethodIsCreditCard() {

    }
    @When("the billing system processes it")
    public void theBillingSystemProcessesIt() {

    }
    @Then("a PDF invoice should be generated")
    public void aPDFInvoiceShouldBeGenerated() {

    }
    @Then("emailed to the customer")
    public void emailedToTheCustomer() {

    }
    @Given("an order is completed with digital items")
    public void anOrderIsCompletedWithDigitalItems() {

    }
    @Given("the payment method is PayPal")
    public void thePaymentMethodIsPayPal() {

    }
    @Given("an order is completed with subscription")
    public void anOrderIsCompletedWithSubscription() {

    }
    @Given("the payment method is bank transfer,")
    public void thePaymentMethodIsBankTransfer() {

    }
    @Given("it's the end of the month")
    public void itSTheEndOfTheMonth() {

    }
    @When("the administrator generates reports")
    public void theAdministratorGeneratesReports() {

    }
    @Then("the system should create revenue breakdown")
    public void theSystemShouldCreateRevenueBreakdown() {

    }
    @Then("show comparison to previous month")
    public void showComparisonToPreviousMonth() {

    }
    @Given("the following failed transactions:")
    public void theFollowingFailedTransactions(io.cucumber.datatable.DataTable dataTable) {

    }
    @When("the system retries after {int} hours")
    public void theSystemRetriesAfterHours(Integer int1) {

    }
    @Then("it should notify the customer")
    public void itShouldNotifyTheCustomer() {

    }
    @Then("suspend delivery until resolved")
    public void suspendDeliveryUntilResolved() {

    }
}

