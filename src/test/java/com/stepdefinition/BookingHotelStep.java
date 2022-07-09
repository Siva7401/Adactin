package com.stepdefinition;

import java.util.List;
import java.util.Map;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class BookingHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@Then("User Should Book Hotel {string},{string},{string} and Save Generated Order ID")
	public void userShouldBookHotelAndSaveGeneratedOrderID(String firstname, String lastname, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> cd = dataTable.asMaps(String.class,String.class);
		String ccNum =cd.get(2).get("CreditCardNo");
		String ccTYpe=cd.get(2).get("CreditCardType");
		String expMonth =cd.get(2).get("Month");
		String expYear =cd.get(2).get("Year");
		String ccvNo =cd.get(2).get("CCVNo");
	
		pom.getBookingPage().bookHotel(firstname, lastname, address, ccNum, ccTYpe, expMonth, expYear, ccvNo);
	}
	@Then("User Should Verify Message After Booking {string}")
	public void userShouldVerifyMessageAfterBooking(String string) {

	}

	@Then("User Should Book Hotel Without Filling All Mandatory Feilds")
	public void userShouldBookHotelWithoutFillingAllMandatoryFeilds() {

	}

	@Then("User Should Verify All Error Message After Booking {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAllErrorMessageAfterBookingAnd(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		pom.getBookingPage().bookHotel();

	}

}
