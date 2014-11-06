package com.selenium;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginObject;


public class FirstTest {
	
	WebDriver driver;
	loginObject login_obj;
	public String home_pg_text = "WordPress Demo Install";
	/*@Test
	public void startWebdriver(){
		WebDriver driver = new FirefoxDriver();
		String baseurl = "http://demo.opensourcecms.com/wordpress/wp-login.php";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("WordPress Demo Install › Log In",driver.getTitle());
		driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("demo123");
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).submit();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='welcome-panel']/div[2]/h3")).getText();
		Assert.assertEquals("Welcome to your new WordPress site!", driver.findElement(By.xpath(".//*[@id='welcome-panel']/div[2]/h3")).getText());
		driver.quit(); 
		
	}*/
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
		
	}
	
	@Test
	public void loginTest(){
		login_obj = new loginObject(driver);
		Assert.assertEquals(login_obj.getLoginTitle(),"WordPress Demo Install › Log In");
		login_obj.loginFunc("admin","demo123");
		Reporter.log("loginTest Test Passed");
	}
	
	@Test
	public void homepageTest(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*String home_pg_text = driver.findElement(By.xpath(".//*[@id='welcome-panel']/div[2]/h3")).getText();*/
		/*boolean feedBack = driver.findElement(By.cssSelector("body")).getText().contains(home_pg_text);*/
		boolean feedBack = driver.findElement(By.tagName("body")).getText().contains(home_pg_text);
		Assert.assertTrue(feedBack);
		Reporter.log("homepageTest Test Passed");
		
	}
	
	@AfterTest
	public void after_test(){
		driver.close();
		driver.quit();
	}
}
