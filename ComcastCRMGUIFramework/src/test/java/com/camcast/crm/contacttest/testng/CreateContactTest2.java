package com.camcast.crm.contacttest.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
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
/**
 * @author pugazh
 * 
 * 
 */
public class CreateContactTest2 extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest2() throws Throwable {

		// read testscriptdata from excel file
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// click on create contact link and button

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		ContactPage cnp = new ContactPage(driver);
		cnp.getcreateNewContactButton().click();

		// Step4 : enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createcontact(lastname);

		cncp.getSaveButton().click();

		// verify header lastname info expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actlastname = cip.getLastNameTF().getText();
		if (actlastname.contains(lastname)) {
			System.out.println(lastname + " is created==PASS");
		} else {
			System.out.println(lastname + " is not created==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactwithSupportdate() throws EncryptedDocumentException, IOException {

		// read testscriptdata from excel file
		String lastname = elib.getDataFromExcel("contact", 1, 2);

		// click on create contact link and button

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		ContactPage cnp = new ContactPage(driver);
		cnp.getcreateNewContactButton().click();

		// Step4 : enter all the details and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createcontact(lastname);

		String startdate = jlib.getSystemDateYYYYDDMM();
		String enddate = jlib.getRequiredDateYYYYDDMM(30);

		cncp.getStartDateDropdown().clear();
		cncp.getStartDateDropdown().sendKeys(startdate);

		cncp.getEndDateDropdown().clear();
		cncp.getEndDateDropdown().sendKeys(enddate);

		cncp.getSaveButton().click();

		// verify header startdate info expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actstartdate = cip.getStartdatetf().getText();
		System.out.println(actstartdate);
		if (actstartdate.contains(startdate)) {
			System.out.println(startdate + "information is verified==PASS");
		} else {
			System.out.println(startdate + "information is verified==FAIL");
		}

		// verify enddate info expected result
		ContactInfoPage cip1 = new ContactInfoPage(driver);
		String actenddate = cip1.getEnddatetf().getText();
		System.out.println(actenddate);
		if (actenddate.contains(enddate)) {
			System.out.println(enddate + "information is verified==PASS");
		} else {
			System.out.println(enddate + "information is verified==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactwithOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {
		// read testscriptdata from excel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
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

		wLib.switchToTabOnURL(driver, "module = Accounts");

		OrgchildPopupPage ocpp = new OrgchildPopupPage(driver);
		ocpp.getSearchTextField().sendKeys(orgName);
		ocpp.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		wLib.switchToTabOnURL(driver, "module = Contacts");

		cncp.getSaveButton().click();

		// verify
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actLastname = cip.getLastNameTF().getText();
		if (actLastname.trim().equals(contactLastName)) {
			System.out.println(contactLastName + "information is created==PASS");
		} else {
			System.out.println(contactLastName + "information is not created==FAIL");
		}
		// verify header phoneName info expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		} else {
			System.out.println(orgName + "information is not created==FAIL");
		}

	}
}
