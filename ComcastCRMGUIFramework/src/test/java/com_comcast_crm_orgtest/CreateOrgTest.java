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
import org.openqa.selenium.support.PageFactory;

import com_comcast_generic_ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		//read data from GenericUtilityfiles
	      /*create object */
		Fileutility flib= new Fileutility();
		ExcelUtility elib= new ExcelUtility();		
		Javautility jlib = new Javautility();
		
		
		//read commondata from property file
		String BROWSER = flib.getDataPropertyFile("browser");

		   String URL=flib.getDataPropertyFile("url");
		
		   
		   //		  String USERNAME=flib.getDataPropertyFile("username"); String
           //		  PASSWORD=flib.getDataPropertyFile("password");
		 
	   

		//read testscriptdata from excel file
		String orgName=elib.getDataFromExcel("org",4,2)+jlib.getRandomNumber();

				
				WebDriver driver = null;
				if (BROWSER.equals("chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equals("firefox")) {
					driver = new FirefoxDriver();
				} else if (BROWSER.equals("edge")) {
					driver = new EdgeDriver();
				} 
				
				//Step1: Login to applicationb

				LoginPage lp=new LoginPage(driver);
				lp.loginToapp(URL,"admin", "admin");
				
		        
				//Step2: Navigate to Organization module
				HomePage hp =new HomePage(driver);
				   hp.getOrglink().click();
				   
				//Step3 : Click on "create organization" button
				   hp.getCreateNewOrgButton().click();
				   
				   
				//Step4 : enter all the details and create new organzation
				   CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
				   cnop.createorg(orgName);
				
				   
				//verify Header msg expected result
				   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				  String actOrgName = oip.getHeaderMsg().getText();
				  if(actOrgName.contains(orgName)) {
					  System.out.println(orgName+ " name is verified==PASS");
				  }
				  else {
					  System.out.println(orgName+" name is not verified==FAIL");
				  }
		   
				//Step5 : logout
				hp.logout();
				
				driver.quit();
				
						
				
	}

	}
			   
				   
				   
				   
				   
				   /*
					 * driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
					 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
					 * driver.findElement(By.id("submitButton")).click();
					 */
				   /*
					 * lp.getUsernameEdit().sendKeys("admin");
					 * lp.getPasswordEdit().sendKeys("admin"); lp.getLoginButton().click();
					 */
				
				   /*
					 * driver.findElement(By.linkText("Organizations")).click();
					 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
					 * );
					 */
				
					/*
					 * // get organisation name data from excel file
					 * driver.findElement(By.name("accountname")).sendKeys(orgName);
					 * 
					 * driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).
					 * click();
					 * 
					 * // verify header msg expected result WebElement header =
					 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")); String title =
					 * header.getText(); 
					 * System.out.println(title);
					 * 
					 * if (title.contains(orgName)) {
					 * System.out.println(orgName+"is created==PASS"); }else {
					 * System.out.println(orgName+"is not created==FAIL"); }
					 * 
					 * //verify header orgName info expected result String
					 * actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
					 * if (actOrgName.equals(orgName)) {
					 * System.out.println(orgName+"is created==PASS"); }else {
					 * System.out.println(orgName+"is not created==FAIL"); }
					 * 
					 * 
					 * WebElement mouseHover = driver.findElement(By.
					 * xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")); Actions act =
					 * new Actions(driver); act.moveToElement(mouseHover).perform();
					 * driver.findElement(By.linkText("Sign Out")).click();
					 */
				
	