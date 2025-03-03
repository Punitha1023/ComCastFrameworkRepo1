package com_comcast_crm_basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_comcast_crm_generic_databaseutility.DataBaseUtility;
import com_comcast_generic_ObjectRepositoryUtility.HomePage;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;
import com_comcast_generic_fileutility.ExcelUtility;
import com_comcast_generic_fileutility.Fileutility;
import com_comcast_generic_webdriverUtility.Javautility;
import com_comcast_generic_webdriverUtility.WebdriverUtility;

public class BaseClass {
	/* create object */
	public DataBaseUtility dblib = new DataBaseUtility();
	public Fileutility flib = new Fileutility();
	public ExcelUtility elib = new ExcelUtility();
	public Javautility jlib = new Javautility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public WebdriverUtility wLib = new WebdriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configbeforesuite() throws SQLException {
		System.out.println("Connect to DB and report config");
		dblib.getDbConnection();

		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configbeforeclass(@Optional("chrome") String browser) throws IOException {
		System.out.println("Launch the browser");
		String BROWSER = browser;
		// flib.getDataPropertyFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configbeforemethod() throws IOException {
		System.out.println("login");
		String URL = flib.getDataPropertyFile("url");
		String USERNAME = flib.getDataPropertyFile("username");
		String PASSWORD = flib.getDataPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configaftermethod() {
		System.out.println("logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configafterclass() {
		System.out.println("close the browser");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configaftersuite() throws SQLException {
		System.out.println("close db and report backup");
		dblib.closeDbConnection();
		report.flush();
	}
}
