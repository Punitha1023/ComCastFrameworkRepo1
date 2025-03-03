package com_comcast_crm_contacttest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com_comcast_generic_ObjectRepositoryUtility.ContactInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.ContactPage;

import com_comcast_generic_ObjectRepositoryUtility.CreatingNewContactPage;
import com_comcast_generic_ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationInfoPage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.OrgchildPopupPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;
import com_comcast_generic_webdriverUtility.WebdriverUtility;

public class CreateContactwithOrTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//read data from GenericUtilityfiles
	      /*create object */
		Fileutility flib= new Fileutility();
		ExcelUtility elib= new ExcelUtility();	
		Javautility jlib = new Javautility();
		WebdriverUtility wlib=new WebdriverUtility();
		
		//read commondata from property file
		String BROWSER = flib.getDataPropertyFile("browser");
	    String URL=flib.getDataPropertyFile("url");
//		String USERNAME=flib.getDataPropertyFile("username");
//	    String PASSWORD=flib.getDataPropertyFile("password");
		
	   

		//read testscriptdata from excel file
		String orgName=elib.getDataFromExcel("org",7,2)+jlib.getRandomNumber();
		String contactLastName=elib.getDataFromExcel("contact",7,3)+jlib.getRandomNumber();

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
		
		
		
		HomePage hp=new HomePage(driver);
		 hp.getOrglink().click();
		   hp.getCreateNewOrgButton().click();
		   CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		   cnop.createorg(orgName);
		   
		  Thread.sleep(2000);
		  
	    hp.getContactlink().click();
		ContactPage cp = new ContactPage(driver);
		   cp.getcreateNewContactButton().click();
		  CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		   cncp.createcontact(contactLastName);
		   
		   cncp.getClickneworgbutton().click();
		   
		   wlib.switchToTabOnURL(driver, "module = Accounts");

		   
	        OrgchildPopupPage ocpp=new OrgchildPopupPage(driver);
	        ocpp.getSearchTextField().sendKeys(orgName);
	        ocpp.getSearchButton().click();
	        driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	        
        wlib.switchToTabOnURL(driver, "module = Contacts");

        cncp.getSaveButton().click();
       
      //verify
      		ContactInfoPage cip=new ContactInfoPage(driver);
      		String actLastname = cip.getLastNameTF().getText();
      		if (actLastname.trim().equals(contactLastName)) {
      			System.out.println(contactLastName+"information is created==PASS");
      		}else {
      			System.out.println(contactLastName+"information is not created==FAIL");
      		}
      		//verify header phoneName info expected result
      		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
      		String actOrgName = oip.getHeaderMsg().getText();
      				if (actOrgName.trim().equals(orgName)) {
      					System.out.println(orgName+"information is created==PASS");
      				}else {
      					System.out.println(orgName+"information is not created==FAIL");
      				}
      		
      		hp.logout();
        
        driver.quit();
        
        
	}
	

	}   
     
        
