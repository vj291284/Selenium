package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import pageObjects.loginObject;

public class loginTest extends iniClass{
	
	@BeforeTest
	public void initBrowser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
	}
	

	@Test(dataProvider = "Login")
	public void login_neg_Test(String userName, String userPwd, String expMsg){
		
		loginObject login_obj = new loginObject(driver);
		Assert.assertEquals(login_obj.getLoginTitle(),"WordPress Demo Install › Log In");
		login_obj.loginFunc(userName,userPwd);
		//String exp_error_msg = driver.findElement(By.xpath(".//*[@id='login_error']")).getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean feedBack = driver.findElement(By.tagName("body")).getText().contains(expMsg);
		Assert.assertTrue(feedBack);
		
	}
	
	 @DataProvider(name = "Login")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { {"admin", " ","ERROR: The password field is empty."},{"admin", "demo123","WordPress Demo Install"}};
	 
	  }

}
