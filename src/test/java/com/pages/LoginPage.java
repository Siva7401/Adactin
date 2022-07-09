package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;
	
	@FindBy(id = "//div[@class='auth_error']")
	private WebElement error;
	
	public WebElement getError() {
		return error;
	}
	public WebElement getTextUserName() {
		return txtUserName;
	}

	public WebElement getTextPassword() {
		return txtPassword;
	}

	public WebElement getbtnLogin() {
		return btnLogin;
	}

	public void login(String userName, String password) {
		sendText(getTextUserName(), userName);
		sendText(getTextPassword(), password);
		clickButton(getbtnLogin());

	}

	public void loginWithEnter(String userName, String password) throws AWTException {
		sendText(getTextUserName(), userName);
		sendText(getTextPassword(), password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void login() {
		clickButton(getbtnLogin());
	}

}
