package com_comcast_crm_contacttest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com_comcast_crm_basetest.BaseClass;
import com_comcast_generic_ObjectRepositoryUtility.ContactInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.ContactPage;
import com_comcast_generic_ObjectRepositoryUtility.CreatingNewContactPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;

public class Createcontactwithsupporttest extends BaseClass {

	public static void main(String[] args) throws IOException {
		//read data from GenericUtilityfiles
	      /*create object */
		Fileutility flib= new Fileutility();
		ExcelUtility elib= new ExcelUtility();		
		Javautility jlib = new Javautility();
		
		
		//read commondata from property file
		String BROWSER = flib.getDataPropertyFile("browser");
	    String URL=flib.getDataPropertyFile("url");
//		String USERNAME=flib.getDataPropertyFile("username");
//	    String PASSWORD=flib.getDataPropertyFile("password");
		
	   

		//read testscriptdata from excel file
		String lastname=elib.getDataFromExcel("contact",1,2);
	    
	    WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} 

	
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL,"admin", "admin");
		

		// click on create contact link and button

		HomePage hp =new HomePage(driver);
		   hp.getContactlink().click();
		   
		   ContactPage cnp = new ContactPage(driver);
		   cnp.getcreateNewContactButton().click();
		
			//Step4 : enter all the details and create new contact
		   CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		   cncp.createcontact(lastname);
	
		   
		  String startdate=jlib.getSystemDateYYYYDDMM();
		  String enddate=jlib.getRequiredDateYYYYDDMM(30);
		  
		  
		  cncp.getStartDateDropdown().clear();
		  cncp.getStartDateDropdown().sendKeys(startdate);
		  
		  cncp.getEndDateDropdown().clear();
		  cncp.getEndDateDropdown().sendKeys(enddate);
		  
		  
		   cncp.getSaveButton().click();
    
    
		//verify header startdate info expected result
		ContactInfoPage cip=new ContactInfoPage(driver);
		  String actstartdate = cip.getStartdatetf().getText();
		  System.out.println(actstartdate);
		  if (actstartdate.contains(startdate)) {
			System.out.println(startdate+"information is verified==PASS");
		}else {
			System.out.println(startdate+"information is verified==FAIL");
		}
		
		//verify enddate  info expected result
			ContactInfoPage cip1=new ContactInfoPage(driver);
			  String actenddate = cip1.getEnddatetf().getText(); 
			  System.out.println(actenddate);
		if (actenddate.contains(enddate)) {
			System.out.println(enddate+"information is verified==PASS");
		}else {
			System.out.println(enddate+"information is verified==FAIL");
		}
		
		//Step5 : logout
				hp.logout();
				
				driver.quit();
				
	}

	}
		
		
		
		
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//
//		// click on create organisation button
//
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//
//		String startdate=jlib.getSystemDateYYYYDDMM();
//		String endDate=jlib.getRequiredDateYYYYDDMM(30);
//	 
//		driver.findElement(By.name("lastname")).sendKeys(lastname);
//		driver.findElement(By.name("support_start_date")).clear();
//		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
//		
//		driver.findElement(By.name("support_end_date")).clear();
//		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
//		
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//
//		//verify header startdate info expected result
//		String actstartdate=driver.findElement(By.id("dtlview_Last Name")).getText();
//		if (actstartdate.equals(startdate)) {
//			System.out.println(startdate+"information is verified==PASS");
//		}else {
//			System.out.println(startdate+"information is verified==FAIL");
//		}
//		
//		//verify enddate  info expected result
//		String actendDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
//		if (actendDate.equals(endDate)) {
//			System.out.println(endDate+"information is verified==PASS");
//		}else {
//			System.out.println(endDate+"information is verified==FAIL");
//		}
//		
//		WebElement mouseHover = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(mouseHover).perform();
//		driver.findElement(By.linkText("Sign Out")).click();
//		
		
	
