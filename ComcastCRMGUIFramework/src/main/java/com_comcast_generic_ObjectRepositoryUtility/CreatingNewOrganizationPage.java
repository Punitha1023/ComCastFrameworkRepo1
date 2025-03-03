package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	  WebDriver driver;
		public CreatingNewOrganizationPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);				

		}
		
@FindBy(name="accountname")
private WebElement orgnameEdit;

@FindBy(id = "phone")
private WebElement phoneEdit;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(name="industry")
private WebElement industrydropdown;

@FindBy(name="accounttype")
private WebElement typeDropdown;





public WebElement getOrgnameEdit() {
	return orgnameEdit;
}

public WebElement getPhoneEdit() {
	return phoneEdit;
}

public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getIndustrydropdown() {
	return industrydropdown;
}

public WebElement getTypeDropdown() {
	return typeDropdown;
}






public void createorg(String orgName) {
	orgnameEdit.sendKeys(orgName);
	saveButton.click();	
}

public void createorg(String orgName,String phoneNumber) {
	orgnameEdit.sendKeys(orgName);
	phoneEdit.sendKeys(phoneNumber);
	saveButton.click();
}

	
public void createorg(String orgName, String industry, String type) {
	orgnameEdit.sendKeys(orgName);
     Select sel = new Select(industrydropdown);
	sel.selectByValue(industry);
	 Select sel1 = new Select(typeDropdown);
		sel1.selectByValue(type);
	saveButton.click();	
}
	
	
	
	
	
	
	
}
