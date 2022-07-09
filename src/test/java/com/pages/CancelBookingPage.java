package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement clickItinarary;

	@FindBy(xpath="//input[@type='button'][1]")
	private WebElement clickOrderId;

	@FindBy(id = "order_id_text")
	private WebElement clickSearchBox;

	@FindBy(id = "search_hotel_id")
	private WebElement clickGoButton;

	@FindBy(name = "ids[]")
	private WebElement selectId;

	@FindBy(name = "cancelall")
	private WebElement clickCancel;

	public WebElement getClickItinarary() {
		return clickItinarary;
	}

	public WebElement getClickOrderId() {
		return clickOrderId;
	}

	public WebElement getClickSearchBox() {
		return clickSearchBox;
	}

	public WebElement getClickGoButton() {
		return clickGoButton;
	}

	public WebElement getSelectId() {
		return selectId;
	}

	public WebElement getClickCancel() {
		return clickCancel;
	}

	public void cancelOrderId() {
		clickButton(getClickItinarary());
		clickButton(getClickOrderId());
		simpleAlerts();

	}

	public void cancelOrderId(String orderId) {
		clickButton(getClickItinarary());
		sendText(clickSearchBox, orderId);
		clickButton(getClickGoButton());
		clickButton(getSelectId());
		clickButton(getClickCancel());
		simpleAlerts();
		System.out.println("Deleted Successfully" );

	}
}
