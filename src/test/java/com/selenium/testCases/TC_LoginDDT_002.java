package com.selenium.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pageObjects.LoginPage;
import com.selenium.utilities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String password) throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(username);
		logger.info("username provided");
		loginPage.setPassword(password);
		logger.info("password provided");
		loginPage.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			
			//close alert
			driver.switchTo().alert().accept();
			//Focus on the main page
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);   //failure case
			logger.warn("Loggin failed");
		}
		else {
			
			Assert.assertTrue(true); //passed case
			logger.info("Login passed");
			loginPage.clickLogout();
			Thread.sleep(3000);
			//close logout alert
			String logoutAlert = driver.switchTo().alert().getText();
			Assert.assertEquals(logoutAlert, "You Have Succesfully Logged Out!!");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	//user defined method created to check alert is presetn or not
	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {

			return false;
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String ExcelPath = System.getProperty("user.dir")+"/src/test/java/com/selenium/testData/LoginData.xlsx";

		int rowCount = ExcelUtils.getRowCount(ExcelPath, "Sheet1");
		int colCount = ExcelUtils.getCellCount(ExcelPath, "Sheet1", rowCount);

		String loginData[][] = new String[rowCount][colCount];

		for(int i=1; i<=rowCount; i++) {

			for(int j=0; j<colCount; j++) {

				loginData[i-1][j] = ExcelUtils.getCellData(ExcelPath, "Sheet1", i, j);
			}
		}

		return loginData;
	}
}
