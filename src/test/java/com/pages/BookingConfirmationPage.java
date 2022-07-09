package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmationPage extends BaseClass {
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement getAttributeValue;

	@FindBy(xpath = "//td[text()='Booking Confirmation']")
	private WebElement verifyBookingConfirmation;

	public WebElement getGetAttributeValue() {
		return getAttributeValue;
	}

	public WebElement getVerifyBookingConfirmation() {
		return verifyBookingConfirmation;
	}

	public String getOrderId() {
		String orderID = getAttribute(getOrderId());
		return orderID;

	}

}
