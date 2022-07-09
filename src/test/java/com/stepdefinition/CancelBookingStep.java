package com.stepdefinition;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class CancelBookingStep {

	PageObjectManager pom = new PageObjectManager();

	@Then("User Should Cancel The Order Id")
	public void userShouldCancelTheOrderId() {
		pom.getCancelBookingPage().cancelOrderId();

	}

	@Then("User Should Verify Message After Cancelling {string}")
	public void userShouldVerifyMessageAfterCancelling(String string) {
	}

	@Then("User Should Cancel The Previously Booked Order Id {string}")
	public void userShouldCancelThePreviouslyBookedOrderId(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);
		

	}

}
