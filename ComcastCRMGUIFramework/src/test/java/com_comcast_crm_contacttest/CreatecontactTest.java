package com_comcast_crm_contacttest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com_comcast_crm_basetest.BaseClass;
import com_comcast_generic_ObjectRepositoryUtility.ContactInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.ContactPage;
import com_comcast_generic_ObjectRepositoryUtility.CreatingNewContactPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;

public class CreatecontactTest extends BaseClass {

	
		public static void main(String[] args) throws IOException {
			//read data from GenericUtilityfiles
		      /*create object */
			Fileutility flib= new Fileutility();
			ExcelUtility elib= new ExcelUtility();		
			Javautility jlib = new Javautility();
			
			//read commondata from property file
			String BROWSER = flib.getDataPropertyFile("browser");
		    String URL=flib.getDataPropertyFile("url");
//			String USERNAME=flib.getDataPropertyFile("username");
//		    String PASSWORD=flib.getDataPropertyFile("password");
			
		   

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
			
			   //verify header lastname info expected result
				   ContactInfoPage cip=new ContactInfoPage(driver);
					  String actlastname = cip.getLastNameTF().getText();
					  if (actlastname.contains(lastname)) {
				System.out.println(lastname+" is created==PASS");
			}else {
				System.out.println(lastname+" is not created==FAIL");
			}
			
			//Step5 : logout
			hp.logout();
			
			driver.quit();
			
		
			
	}

}
