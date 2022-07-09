package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement selectHotel;

	@FindBy(id = "continue")
	private WebElement selectContinue;

	@FindBy(xpath = "//td[@class='login_title'])[2]")
	private WebElement verifyBookAHotel;

	
	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getSelectContinue() {
		return selectContinue;
	}

	public WebElement getVerifyBookAHotel() {
		return verifyBookAHotel;
	}

	public void selectHotel() {
		clickButton(getSelectHotel());
		clickButton(getSelectContinue());

	}

	public void selectContinue() {
		clickButton(getSelectContinue());

	}

}
