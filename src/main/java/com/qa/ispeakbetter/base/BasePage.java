package com.qa.ispeakbetter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	//WebDriver
	//Properties
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_drver(String browsername){
		
		System.out.println("BrowserName is " + browsername);
		
		if(browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
		
		
	}
	
	public Properties init_properties(){
		prop = new Properties();
		String path = "./src/main/java/com/qa/ispeakbetter/config/config.properties";
		

			try {
				FileInputStream ip = new FileInputStream(path);
				prop.load(ip);
			} catch (FileNotFoundException e) {
				System.out.println("some issue with config properties... Please correct your config...!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return prop;  
	}
			
	
}
