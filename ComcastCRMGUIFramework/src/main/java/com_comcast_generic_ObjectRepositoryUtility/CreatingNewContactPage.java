package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	 WebDriver driver;
		public CreatingNewContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);				

		}
		
		
@FindBy(name="lastname")
private WebElement lastnameEdit;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(name="support_start_date")
private WebElement StartDateDropdown;

@FindBy(name="support_end_date")
private WebElement EndDateDropdown;
 
@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
private WebElement clickneworgbutton;



public WebElement getLastnameEdit() {
	return lastnameEdit;
}

public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getStartDateDropdown() {
	return StartDateDropdown;
}

public WebElement getEndDateDropdown() {
	return EndDateDropdown;
}

public WebElement getClickneworgbutton() {
	return clickneworgbutton;
}



public void createcontact(String lastname) {
	lastnameEdit.sendKeys(lastname);
		
}
}