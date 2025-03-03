package com_comcast_generic_ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_comcast_generic_webdriverUtility.WebdriverUtility;
/**
 * @author pugazh
 * 
 * This class contains login page elements and business libraries like login()
 */
public class LoginPage extends WebdriverUtility{                      //Rule1: create a seperate java class

	 //Rule3: Object Initialization
      WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);				

	}
	
   @FindBy(name="user_name")                 	//Rule2: Object Creation
   private WebElement usernameEdit;

   @FindBy(name="user_password")
   private WebElement passwordEdit;
	
   @FindBy(id="submitButton")
   private WebElement loginButton;

   
   //Rule4: Object encapsulation
   public WebElement getUsernameEdit() {
	return usernameEdit;
}

   public WebElement getPasswordEdit() {
	return passwordEdit;
}

   public WebElement getLoginButton() {
	return loginButton;
}	
	
  /**
   * Login too application based username, password, url arguments
   * @param url
   * @param username
   * @param password
   */
   
   public void loginToapp(String url,String username , String password) {
	   waitForPageToLoad(driver);
	   driver.get(url);
	   driver.manage().window().maximize();
	   usernameEdit.sendKeys(username);
	   passwordEdit.sendKeys(password);
	   loginButton.click();
   }


   
   
   
   
   
	
	
}
