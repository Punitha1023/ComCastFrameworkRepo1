package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_comcast_crm_basetest.BaseClass;

public class listenerImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	ExtentTest test;
	public void OnStart(ISuite suite) {
		System.out.println("Report configuration");
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

	public void OnFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("======>" + result.getMethod().getMethodName() + "====START===");
		test = report.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, result.getMethod().getMethodName()+"=====STARTED=====");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("======>" + result.getMethod().getMethodName() + "====END===");
        test.log(Status.PASS, result.getMethod().getMethodName()+"=====COMPLETED=====");

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
	    String Time= new java.util.Date().toString().replace(" ", "_").replace(":", " ");
		test.addScreenCaptureFromBase64String(filePath,testName+""+Time);
        test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAILED=====");

		
//		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
//		File temp = ts.getScreenshotAs(OutputType.FILE);		
//		try {
//			org.openqa.selenium.io.FileHandler.copy(temp, src);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailureWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFinish(ITestContext context) {
            
	}
}
