package com.selenium.testCases;

import org.testng.annotations.Test;

import com.selenium.pageObjects.DeleteCustomerPage;
import com.selenium.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass {
	
	@Test
	public void deleteCutsomer() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		Thread.sleep(3000);
		
		DeleteCustomerPage delCustomer = new DeleteCustomerPage(driver);
		delCustomer.clickDeleteCustomer();
		logger.info("Deleting customer");
		delCustomer.provideCustomerId(1234);
		delCustomer.clickSubmit();
		
	
	}

}
