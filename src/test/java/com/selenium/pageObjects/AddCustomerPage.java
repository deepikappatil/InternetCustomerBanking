package com.selenium.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepika
 *
 */
public class AddCustomerPage {

	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement newCustomerLink;

	@FindBy(how = How.XPATH, using = "//input[@type='text'][@name='name']")
	@CacheLookup
	WebElement customerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement gender;

	// Id and name has same value
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement DOB;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement pinCode;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement telephoneNumber;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement emailId;

	@FindBy(how = How.XPATH, using = "//input[@type='password'][@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@name='sub']")
	@CacheLookup
	WebElement submitButton;

	WebDriver driver = null;

	public AddCustomerPage(WebDriver testDriver) {

		driver = testDriver;
		PageFactory.initElements(testDriver, this);
	}

	public void clickAddNewCustomer() {

		newCustomerLink.click();
	}

	public void custName(String cname) {

		customerName.sendKeys(cname);
	}

	public void custGender(String cgender) {

		gender.click();
	}


	public void custDOB(String dd,String mm,String yyyy) {

		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yyyy);

		//		DOB.sendKeys(String.valueOf(dd));
		//		DOB.sendKeys(String.valueOf(mm));
		//		DOB.sendKeys(String.valueOf(yyyy));
		DOB.sendKeys(Keys.RETURN);
	}

	public void custAddress(String caddress) {

		address.sendKeys(caddress);
	}

	public void custCity(String ccity) {

		city.sendKeys(ccity);
	}

	public void custState(String cstate) {

		state.sendKeys(cstate);
	}

	public void custPinCode(String cpin) {
		pinCode.sendKeys(String.valueOf(cpin));
	}

	public void custTelePhoneNumber(String ctelephone) {

		telephoneNumber.sendKeys(String.valueOf(ctelephone));
	}

	public void custEmailId(String cemailId) {

		emailId.sendKeys(cemailId);
	}

	public void custPassword(String cpassword) {

		password.sendKeys(cpassword);
	}

	public void custSubmit() {

		submitButton.click();
	}
}

