package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	  WebDriver driver;
		public OrganizationInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);				

		}

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameTextField;
	
	@FindBy(id ="mouseArea_Phone")
	private WebElement phoneNumberTextField;
		
	@FindBy(id="mouseArea_Industry")
	private WebElement IndustryDropDown;
		
	@FindBy(id="mouseArea_Type")
	private WebElement TypeDropDown;
	

	
	
	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getHeaderMsg() {
			return headerMsg;
		}
	
	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}
	
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}
	
	public WebElement TypeDropDown() {
		return TypeDropDown;
	}
	
	
	
}
