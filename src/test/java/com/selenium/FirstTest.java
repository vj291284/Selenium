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



public class FirstTest {
	
	private static WebDriver driver;
	public String home_pg_text = "WordPress Demo Install";
	loginObject login_obj;

	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser){
		
		if (browser.equalsIgnoreCase("FireFox")){
			System.out.println(browser);
			driver = new FirefoxDriver();
		}
		/*else if (browser.equalsIgnoreCase("chrome")){
			System.out.println(browser);
			System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
			driver = new ChromeDriver();
		}*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
		
	}
	
	
	@Test
	public void loginTest(){
		login_obj = new loginObject(driver);
		Assert.assertEquals(login_obj.getLoginTitle(),"WordPress Demo Install › Log In");
		login_obj.loginFunc("admin","demo123");
		
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
	
	@AfterClass
	public void after_test(){
		driver.close();
		driver.quit();
	}
}
