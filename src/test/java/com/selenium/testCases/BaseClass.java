package com.selenium.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.selenium.utilities.ReadConfigFile;


public class BaseClass {

	ReadConfigFile readConfig = new ReadConfigFile();

	public String baseURL = readConfig.getBaseURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();

	public static WebDriver driver = null;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browserName) {

		logger = LogManager.getLogger();

		if(browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			ChromeOptions options = new ChromeOptions();     
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {

			System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.ignoreZoomSettings();
			driver = new InternetExplorerDriver(options);

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomString() {

		//Count parameter indicates the length of random string need to generate
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {

		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedNumber;
	}
}

