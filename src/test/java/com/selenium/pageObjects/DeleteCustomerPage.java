package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	@FindBy(how = How.XPATH, using = "//a[text()='Delete Customer']")
	@CacheLookup
	WebElement delCustomerLink;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='cusid']")
	@CacheLookup
	WebElement custmerId;
	
	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement submitButton;
	
	WebDriver driver = null;
	
	public DeleteCustomerPage(WebDriver testDriver) {
		
		driver = testDriver;
		PageFactory.initElements(testDriver, this);
		
	}
	
	public void clickDeleteCustomer() {
		
		delCustomerLink.click();
	}
	
	public void provideCustomerId(int cid) {
		
		custmerId.sendKeys(String.valueOf(cid));
	}
	
	public void clickSubmit() {
		
		submitButton.click();
	}
}
