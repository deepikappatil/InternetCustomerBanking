package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepika
 *
 */

// UserID : mngr262732  password: dAgupeh

public class LoginPage {

	@FindBy(name = "uid")
	@CacheLookup
	WebElement textUsername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement textPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement loginButton;

	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement resetButton;

	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement logoutButton;
	
	WebDriver driver = null;

	public LoginPage(WebDriver testDriver) {

		driver = testDriver;
		PageFactory.initElements(testDriver, this);
	}

	public void setUsername(String username) {

		textUsername.sendKeys(username);
	}

	public void setPassword(String password) {

		textPassword.sendKeys(password);
	}

	public void clickLogin() {

		loginButton.click();
	}
	
	public void clickLogout() {

		logoutButton.click();
	}

}
