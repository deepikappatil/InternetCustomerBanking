package com.selenium.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.pageObjects.AddCustomerPage;
import com.selenium.pageObjects.LoginPage;

/**
 * 
 * @author Deepika
 *
 */

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {


		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		logger.info("Username provided");
		loginPage.setPassword(password);
		logger.info("Password provided");
		loginPage.clickLogin();

		Thread.sleep(3000);

		AddCustomerPage customerPage = new AddCustomerPage(driver);
		customerPage.clickAddNewCustomer();
		
		logger.info("Providing customer details.....");
		
		customerPage.custName("Raman");
		customerPage.custGender("male");
		Thread.sleep(2000);
		customerPage.custDOB("10","12","1987");
		Thread.sleep(4000);
		customerPage.custAddress("INDIA");
		customerPage.custCity("BNG");
		customerPage.custState("KA");
		customerPage.custPinCode("560050");
		customerPage.custTelePhoneNumber("987890091");
		customerPage.custEmailId(randomString()+"gmail.com");
		customerPage.custPassword("AphtEio");
		customerPage.custSubmit();

		Thread.sleep(3000);

		logger.info("Validation started");
		boolean custResult = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(custResult==true) {

			Assert.assertTrue(true);
			logger.info("Customer creation is Passed");
		}
		else {

			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Customer creation is failed");
		}
	}




}
