package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class sample_test {
	public static void main(String[] args) {
		 
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		 
		driver.setJavascriptEnabled(false);
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		driver.get("https://www.gmail.com/");
		 
		System.out.println(driver.getTitle());
		 
		}
}
