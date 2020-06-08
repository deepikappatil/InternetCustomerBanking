package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	@FindBy(how = How.XPATH, using = "//a[text()='Edit Customer']")
	@CacheLookup
	WebElement editCustomerLink;
	
	@FindBy(how = How.CSS, using = "input[type=text][name='cusid']")
	@CacheLookup
	WebElement customerid;
	
	@FindBy(how = How.CSS, using = "input[type=submit][name='AccSubmit']")
	@CacheLookup
	WebElement submitButton;

	WebDriver driver = null;
	
	public EditCustomerPage(WebDriver testDriver) {
		
		driver = testDriver;
		PageFactory.initElements(testDriver, this);
	}
	
	public void clickEditCutomer() {
		
		editCustomerLink.click();
	}
	
	public void provideCustId(int cid) {
		
		customerid.sendKeys(String.valueOf(cid));
	}
	
	public void clickSubmit() {
		
		submitButton.click();
	}
}
