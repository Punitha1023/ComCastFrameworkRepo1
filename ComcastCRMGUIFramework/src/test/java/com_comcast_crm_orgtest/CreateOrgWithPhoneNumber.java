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
import org.openqa.selenium.support.ui.WebDriverWait;

import com_comcast_generic_ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;

public class CreateOrgWithPhoneNumber {

	public static void main(String[] args) throws IOException, Exception {
		//read data from GenericUtilityfiles
	      /*create object */
		Fileutility flib= new Fileutility();
		ExcelUtility elib= new ExcelUtility();		
		Javautility jlib = new Javautility();
		
		
		//read commondata from property file
		String BROWSER = flib.getDataPropertyFile("browser");
	    String URL=flib.getDataPropertyFile("url");
		String USERNAME=flib.getDataPropertyFile("username");
	    String PASSWORD=flib.getDataPropertyFile("password");
		
	   

		//read testscriptdata from excel file
		String orgName=elib.getDataFromExcel("org",7,2)+jlib.getRandomNumber();
		String phonenumber=elib.getDataFromExcel("org",7,3);
		 
		 
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
				   cnop.createorg(orgName,phonenumber);
				

				   //verify  phonenumber info equals to  expected result
			      
				   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		   String actphonenumber = oip.getPhoneNumberTextField().getText();

				if (actphonenumber.contains(phonenumber)) {
					System.out.println(phonenumber+" is created==PASS");
				}else {
					System.out.println(phonenumber+" is not created==FAIL");
				}
				
				
				hp.logout();

			driver.quit();	
	}

}


/*
 * // driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
 * //
 * driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
 * // driver.findElement(By.id("submitButton")).click();
 * 
 * // click on create organisation button
 * 
 * // driver.findElement(By.linkText("Organizations")).click(); //
 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
 * );
 * 
 * //get organisation name data from excel file //
 * driver.findElement(By.name("accountname")).sendKeys(orgName); //
 * driver.findElement(By.id("phone")).sendKeys(phonenumber);
 * 
 * //findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click(
 * );
 */
/*
 * ////Thread.sleep(3000); ////cnp.getCreateNewOrgButton().click();
 * ////orgName=elib.getDataFromExcel("org",7,2)+jlib.getRandomNumber(); ////
 * System.out.println("Org2:"+orgName); //
 * //cnop.getPhoneTextField().sendKeys(phonenumber); // ////
 * cnop.createorg1(orgName, phonenumber); //
 */