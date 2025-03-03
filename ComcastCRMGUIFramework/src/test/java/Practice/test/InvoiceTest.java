package Practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com_comcast_crm_basetest.BaseClass;

public class InvoiceTest extends BaseClass {
	
	@Test
	//(retryAnalyzer = com.comcast.crm.listenerUtility.RetryListImpClass.class)
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Log in");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	
	}
	
	
	
	
	
	//this code to take screenshot for defect
//@Test
//public void createInvoiceTest() {
//	System.out.println("execute createInvoiceTest");
//	String actTitle=driver.getTitle();
//	Assert.assertEquals(actTitle, "Log in");
//	System.out.println("Step-1");
//	System.out.println("Step-2");
//	System.out.println("Step-3");
//	System.out.println("Step-4");
//
//}

//@Test
//public void createInvoicewithContactTest() {
//	System.out.println("execute createInvoicewithContactTest");
//	System.out.println("Step-1");
//	System.out.println("Step-2");
//	System.out.println("Step-3");
//	System.out.println("Step-4");
//}
}
