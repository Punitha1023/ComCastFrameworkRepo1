package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Products")
	private WebElement Productlink;

	@FindBy(linkText = "Organizations")
	private WebElement orglink;

	@FindBy(linkText = "Contacts")
	private WebElement contactlink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;

	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgButton;

	public WebElement getProductlink() {
		return Productlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCreateNewOrgButton() {
		return createNewOrgButton;
	}

	public void navigateToCompaingnPage() {
		Actions act = new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutlink.click();
	}

}
