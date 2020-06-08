package com.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

	Properties properties;

	// Load property file 
	public ReadConfigFile(){

		File configFile = new File("./Configuration/config.properties");

		try {
		//Open the file in the read mode and read the data
		FileInputStream input = new FileInputStream(configFile);
		properties = new Properties();
		properties.load(input);
		}catch(Exception e) {
			
			System.out.println("Exception is :" + e.getMessage());
		}

	}

	public String getBaseURL() {

		String url = properties.getProperty("baseURL");
		return url;
	}

	public String getUsername() {

		String username = properties.getProperty("username");
		return username;
	}

	public String getPassword() {

		String password = properties.getProperty("password");
		return password;
	}
	public String getChromePath() {

		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath() {

		String iepath = properties.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxPath() {

		String firefoxpath = properties.getProperty("firefoxpath");
		return firefoxpath;
	}
}
