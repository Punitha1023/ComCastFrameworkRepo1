package com_comcast_generic_webdriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> allWindowId= driver.getWindowHandles();
		for (String id : allWindowId) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {
				break;
			}
			
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> allWindowId= driver.getWindowHandles();
		for (String id : allWindowId) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialTitle)) {
				break;
			}
			
		}
	}
	
	public void switchtoframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchtoframe(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchtoframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchtoAlertandCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mousemoveOnElement(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver , WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
		
		
//		public void alertPopUp(WebDriver driver) {
//			Alert ale = driver.switchTo().alert();
//			ale.accept();
//		}
	
}
}
