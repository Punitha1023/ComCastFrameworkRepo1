package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	



	WebDriver driver;
		public ContactInfoPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);				

		}
	
	
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement LastNameTF;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrganizationTF;


	@FindBy(id="dtlview_Support Start Date")
	private WebElement Startdatetf;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement Enddatetf;


	@FindBy(id ="mouseArea_Phone")
	private WebElement phoneNumberTextField;

	public WebElement getLastNameTF() {
		return LastNameTF;
	}



	public WebElement getOrganizationTF() {
		return OrganizationTF;
	}



	public WebElement getStartdatetf() {
		return Startdatetf;
	}



	public WebElement getEnddatetf() {
		return Enddatetf;
	}



	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

















}


