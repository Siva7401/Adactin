package com.stepdefinition;

import java.awt.AWTException;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin Home Page")
	public void userIsOnTheAdactinHomePage() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		loadUrl(getPropertyFileValue("url"));
		maximize();
		implicitWaits(30);

	}

	@When("User Should Perform Login {string},{string}")
	public void userShouldPerformLogin(String UserName, String Password) {
		pom.getLoginPage().login(UserName, Password);

	}

	@When("User Should Perform Login {string},{string} With Help of ENTER key")
	public void userShouldPerformLoginWithHelpOfENTERKey(String UserName, String Password) throws AWTException {
		pom.getLoginPage().loginWithEnter(UserName, Password);

	}

	@Then("User Should Verify Login Error Message Contains After Login {string}")
	public void userShouldVerifyLoginErrorMessageContainsAfterLogin(String error) {
		pom.getLoginPage().login();
		String text1 = getText1(pom.getLoginPage().getError());
		Assert.assertTrue("verify",text1.contains(error));

	}

}
