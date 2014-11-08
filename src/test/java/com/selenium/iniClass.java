package com.selenium;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.loginObject;
import org.testng.annotations.*;

public class iniClass {
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void initBrowser(String browser){
		if (browser.equalsIgnoreCase("FireFox")){
			System.out.println(browser);
			driver = new FirefoxDriver();
		}
		
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.close();
		driver.quit();
		
	}

}
