package com.comcast.crm.orgtest.asserttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com_comcast_crm_basetest.BaseClass;
import com_comcast_generic_ObjectRepositoryUtility.CreatingNewOrganizationPage;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.OrganizationInfoPage;

public class CreateOrgTest3 extends BaseClass {
	@Test(groups = "smokeTest")
	public void createorgtest() throws EncryptedDocumentException, IOException {

		// read testscriptdata from excel file
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();

		// Step2: Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Step3 : Click on "create organization" button
		hp.getCreateNewOrgButton().click();

		// Step4 : enter all the details and create new organzation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName);

		// verify Header msg expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified==PASS");
		} else {
			System.out.println(orgName + " name is not verified==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createorgtestwithPhononumber() throws EncryptedDocumentException, IOException {

		// read testscriptdata from excel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phonenumber = elib.getDataFromExcel("org", 7, 3);

		// Step2: Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Step3 : Click on "create organization" button
		hp.getCreateNewOrgButton().click();

		// Step4 : enter all the details and create new organzation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName, phonenumber);

		// verify phonenumber info equals to expected result

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actphonenumber = oip.getPhoneNumberTextField().getText();

		if (actphonenumber.contains(phonenumber)) {
			System.out.println(phonenumber + " is created==PASS");
		} else {
			System.out.println(phonenumber + " is not created==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createorgtestwithIndustryType() throws EncryptedDocumentException, IOException {

		// read testscriptdata from excel file
		String orgName = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		// Step2: Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Step3 : Click on "create organization" button
		hp.getCreateNewOrgButton().click();

		// Step4 : enter all the details and create new organzation
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName, industry, type);

		// verify the industry and type info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustries = oip.getIndustryDropDown().getText();
		if (actIndustries.contains(industry)) {
			System.out.println(industry + "information is verified==PASS");
		} else {
			System.out.println(industry + "information is not verified==FAIL");
		}

		String actType = oip.getIndustryDropDown().getText();
		if (actType.contains(type)) {
			System.out.println(type + "information is verified==PASS");
		} else {
			System.out.println(type + "information is not verified==FAIL");
		}

	}
}
