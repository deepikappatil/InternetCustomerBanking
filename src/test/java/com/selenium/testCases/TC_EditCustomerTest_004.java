package com.selenium.testCases;

import org.testng.annotations.Test;

import com.selenium.pageObjects.EditCustomerPage;
import com.selenium.pageObjects.LoginPage;

/**
 * 
 * @author Deepika
 *
 */
public class TC_EditCustomerTest_004 extends BaseClass{

	@Test
	public void editCustomer() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		Thread.sleep(3000);
		
		EditCustomerPage editCustomerPage = new EditCustomerPage(driver);
		editCustomerPage.clickEditCutomer();
		logger.info("Editing Customer");
		editCustomerPage.provideCustId(1234);
		editCustomerPage.clickSubmit();
		
	}
}
