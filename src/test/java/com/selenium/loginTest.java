package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.loginObject;

public class loginTest extends iniClass{
	
	/*@BeforeTest
	public void startBrowser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
	}*/
	

	@Test(dataProvider = "Login")
	public void login_neg_Test(String userName, String userPwd, String expMsg){
		
		loginObject login_obj = new loginObject(driver);
		Assert.assertEquals(login_obj.getLoginTitle(),"WordPress Demo Install › Log In");
		login_obj.loginFunc(userName,userPwd);
		//String exp_error_msg = driver.findElement(By.xpath(".//*[@id='login_error']")).getText();
		//WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.elementToBeClickable(By.name("test")));
		boolean feedBack = driver.findElement(By.tagName("body")).getText().contains(expMsg);
		Assert.assertTrue(feedBack);
		
	}
	
	 @DataProvider(name = "Login")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { {"admin", " ","ERROR: The password field is empty."},{"admin", "demo123","WordPress Demo Install"}};
	 
	  }

}
