package com_comcast_crm_orgtest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com_comcast_generic_ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;
import com_comcast_generic_webdriverUtility.WebdriverUtility;

public class CreateOrgWithIndustriesTest {
	@Test
	public void createOrgWithIndustryType_Test() throws IOException {
		//read data from GenericUtilityfiles
	      /*create object */
		Fileutility flib= new Fileutility();
		ExcelUtility elib= new ExcelUtility();		
		Javautility jlib = new Javautility();
		WebdriverUtility wlib = new WebdriverUtility();
		
		//read commondata from property file
		String BROWSER = flib.getDataPropertyFile("browser");
	    String URL=flib.getDataPropertyFile("url");
//		String USERNAME=flib.getDataPropertyFile("username");
//	    String PASSWORD=flib.getDataPropertyFile("password");
	
	   

		//read testscriptdata from excel file
		String orgName=elib.getDataFromExcel("org",4,2)+jlib.getRandomNumber();
		String industry=elib.getDataFromExcel("org",4,3);
		String type=elib.getDataFromExcel("org",4,4);

	
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
				
				//Step2: Navigate to Organization module
				HomePage hp =new HomePage(driver);
				   hp.getOrglink().click();
				   
				//Step3 : Click on "create organization" button
					  hp.getCreateNewOrgButton().click();
   
				 //Step4 : enter all the details and create new organzation
				   CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			        	cnop.createorg(orgName, industry, type); 
				   
				   
				   //verify the industry and type info
				 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				  String actIndustries = oip.getIndustryDropDown().getText();
		         	if(actIndustries.contains(industry)) {
					System.out.println(industry+"information is verified==PASS");
				}else {
					System.out.println(industry+"information is not verified==FAIL");
				} 
				   
				   
				  String actType = oip.getIndustryDropDown().getText();   
		            if (actType.contains(type)) {
					System.out.println(type+"information is verified==PASS");
				}else {
					System.out.println(type+"information is not verified==FAIL");
				} 
			   
				//Step5 : logout
				hp.logout();
				
				driver.quit();
	}

	}			   
				   
				   
//				// get organisation name data from excel file
//				driver.findElement(By.name("accountname")).sendKeys(orgName);
//				
//				driver.findElement(By.name("accountname")).sendKeys(orgName);
//				WebElement wbsel1=driver.findElement(By.name("industry"));
//				Select sel1=new Select(wbsel1);
//				sel1.selectByVisibleText(industry);
//				
//				WebElement wbsel2=driver.findElement(By.name("accounttype"));
//				Select sel2=new Select(wbsel2);
//				sel2.selectByValue(type);
//				
//				driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//
//		   //verify the industry and type info
//				String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
//				if (actIndustries.equals(industry)) {
//					System.out.println(industry+"information is verified==PASS");
//				}else {
//					System.out.println(industry+"information is not verified==FAIL");
//				}
//				
//				String actType=driver.findElement(By.id("dtlview_Type")).getText();
//				if (actType.equals(type)) {
//					System.out.println(type+"information is verified==PASS");
//				}else {
//					System.out.println(type+"information is not verified==FAIL");
//				}
//				
//				WebElement mouseHover = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
//				Actions act = new Actions(driver);
//				act.moveToElement(mouseHover).perform();
//				driver.findElement(By.linkText("Sign Out")).click();
				
				
	
