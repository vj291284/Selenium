package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class loginObject {
	WebDriver driver;
	By usr_name = By.xpath(".//*[@id='user_login']");
	By usr_pwd = By.xpath(".//*[@id='user_pass']");
	By submit_btn = By.xpath(".//*[@id='wp-submit']");
	
	Select select;
	
	public loginObject(WebDriver driver){
		this.driver = driver;
	}
	
	public String getLoginTitle(){
		return driver.getTitle();
	}
	public void setUsername(String strUserName){
		driver.findElement(usr_name).sendKeys(strUserName);
	
	}
	public void setPassword(String strPassword){
		driver.findElement(usr_pwd).sendKeys(strPassword);
	}
	
	public void submitLogin(){
		driver.findElement(submit_btn).submit();
	}
	
	public void loginFunc(String strUserName,String strPassword){
		this.setUsername(strUserName);
		this.setPassword(strPassword);
		this.submitLogin();
		
	}

}
