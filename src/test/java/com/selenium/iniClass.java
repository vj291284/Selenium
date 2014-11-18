package com.selenium;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import pageObjects.loginObject;

import org.testng.annotations.*;

public class iniClass {
	
	WebDriver driver;
	String baseUrl;
	String nodeUrl;

	@Parameters({"browser"})
	@BeforeSuite
	public void initBrowser(String browser){
		if (browser.equalsIgnoreCase("FireFox")){
			/*System.out.println(browser);
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("SeleniumTest");
			driver = new FirefoxDriver(myprofile);
			//Actions act = new Actions(driver);*/
			
			baseUrl = "http://demo.opensourcecms.com/wordpress/wp-login.php";
			nodeUrl = "http://10.0.2.15:5566/wd/hub";
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.XP);
			try {
				driver = new RemoteWebDriver(new URL(nodeUrl),capability );
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.close();
		driver.quit();
		
	}

}
