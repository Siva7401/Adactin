package com.stepdefinition;



import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	@Then("User Should Select Hotel")
	public void userShouldSelectHotel() {
		pom.getSelectPage().selectHotel();
	}

	@Then("User Should Verify Message After Select {string}")
	public void userShouldVerifyMessageAfterSelect(String string) {

	}

	@Then("User Should Continue To Book Hotel Page Without Selecting Hotel")
	public void userShouldContinueToBookHotelPageWithoutSelectingHotel() {
		pom.getSelectPage().selectContinue();

	}

	@Then("User Should Verify Error Message After Not Selecting Hotel {string}")
	public void userShouldVerifyErrorMessageAfterNotSelectingHotel(String string) {

	}
}
