package Practice_DataProvider_test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
@BeforeSuite
public void configbeforesuite() {
	System.out.println("execute BS");
}
	
@BeforeClass
public void configbeforeclass() {
	System.out.println("execute BC");
}

@BeforeMethod
public void configbeforemethod() {
	System.out.println("execute BM");
}

@Test
public void createcontact() {
	System.out.println("execute createcontact");
}

@Test
public void createcontactwithdate() {
	System.out.println("execute createcontactwithdate");
}


@AfterMethod
public void configaftermethod() {
	System.out.println("execute AM");
}


@AfterClass
public void configafterclass() {
	System.out.println("execute AC");
}

@AfterSuite
public void configaftersuite() {
	System.out.println("execute AS");
}
	
}
