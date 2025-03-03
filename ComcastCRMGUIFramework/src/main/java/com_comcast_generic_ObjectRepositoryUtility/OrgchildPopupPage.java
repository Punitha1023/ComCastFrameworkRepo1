package com_comcast_generic_ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgchildPopupPage {

		 WebDriver driver;
			public OrgchildPopupPage(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver, this);				

			}

			@FindBy(id = "search_txt")
			private WebElement searchTextField;
			
			@FindBy(name = "search")
			private WebElement searchButton;

			public WebElement getSearchTextField() {
				return searchTextField;
			}

			public WebElement getSearchButton() {
				return searchButton;
			}		

}

