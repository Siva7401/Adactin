package com.stepdefinition;



import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

public class SearchHotelStep {
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User Should Fill & Submit All Feilds In Search Hotel Page {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldFillSubmitAllFeildsInSearchHotelPageAnd(String location, String hotels, String roomType, String roomNo, String checkIndate, String checkOutDate, String adultPerRoom, String childPerRoom) {
	pom.getSearchhotelPage().searchHotel(location, hotels, roomType, roomNo, checkIndate, checkOutDate, adultPerRoom, childPerRoom);
	}

	@Then("User Should Verify Message After Search {string}")
	public void userShouldVerifyMessageAfterSearch(String string) {
	   
	}

	@Then("User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page {string},{string},{string},{string} and {string}")
	public void userShouldFillSubmitOnlyMandatoryFeildsInSearchHotelPageAnd(String location, String roomNo, String checkIndate, String checkOutDate, String adultPerRoom) {
	pom.getSearchhotelPage().searchHotel(location, roomNo, checkIndate, checkOutDate, adultPerRoom);
	}

	@Then("User Should Verify Invalid Date Error Message After Search {string},{string}")
	public void userShouldVerifyInvalidDateErrorMessageAfterSearch(String string, String string2) {
	    
	}

	@Then("User Should Submit Search Hotel Page Without Filling Any Details")
	public void userShouldSubmitSearchHotelPageWithoutFillingAnyDetails() {
	pom.getSearchhotelPage().searchHotel();
	}

	@Then("User Should Verify Error Message After Search {string}")
	public void userShouldVerifyErrorMessageAfterSearch(String string) {
	  
	}

}


