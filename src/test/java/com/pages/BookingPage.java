package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingPage extends BaseClass {

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement typeFirstName;

	@FindBy(id = "last_name")
	private WebElement typeLastName;

	@FindBy(id = "address")
	private WebElement typeAddress;

	@FindBy(id = "cc_num")
	private WebElement typeCCNum;

	@FindBy(id = "cc_type")
	private WebElement typeCCType;

	@FindBy(id = "cc_exp_month")
	private WebElement typeExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement typeExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement typeCCVNo;

	@FindBy(id = "book_now")
	private WebElement selectBookNow;

	@FindBy(xpath = "//td[text()='Booking Confirmation']")
	private WebElement verifyBookingConfirmation;

	public WebElement getTypeFirstName() {
		return typeFirstName;
	}

	public WebElement getTypeLastName() {
		return typeLastName;
	}

	public WebElement getTypeAddress() {
		return typeAddress;
	}

	public WebElement getTypeCCNum() {
		return typeCCNum;
	}

	public WebElement getTypeCCType() {
		return typeCCType;
	}

	public WebElement getTypeExpMonth() {
		return typeExpMonth;
	}

	public WebElement getTypeExpYear() {
		return typeExpYear;
	}

	public WebElement getTypeCCVNo() {
		return typeCCVNo;
	}

	public WebElement getSelectBookNow() {
		return selectBookNow;
	}

	public WebElement getVerifyBookingConfirmation() {
		return verifyBookingConfirmation;
	}

	public void bookHotel(String firstName, String lastName, String address, String ccNum, String ccTYpe,
			String expMonth, String expYear, String ccvNo) {
		sendText(getTypeFirstName(), firstName);
		sendText(getTypeLastName(), lastName);
		sendText(getTypeAddress(), address);
		sendText(getTypeCCNum(), ccNum);
		sendText(getTypeCCType(), ccTYpe);
		sendText(getTypeExpMonth(), expMonth);
		sendText(getTypeExpYear(), expYear);
		sendText(getTypeCCVNo(), ccvNo);
		clickButton(getSelectBookNow());

	}

	public void bookHotel() {
		clickButton(getSelectBookNow());

	}

}
