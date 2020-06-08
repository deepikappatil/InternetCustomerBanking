package com.selenium.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.selenium.pageObjects.LoginPage;

/**
 * 
 * @author Deepika
 *
 */

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {


		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUsername(username);
		logger.info("Entered username");

		loginPage.setPassword(password);
		logger.info("Entered password");

		loginPage.clickLogin();
		logger.info("Clicked Login button");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		else {
             
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}

	}

}
