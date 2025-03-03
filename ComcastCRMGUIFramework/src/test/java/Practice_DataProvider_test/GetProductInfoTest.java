package Practice_DataProvider_test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_comcast_generic_fileutility.ExcelUtility;

public class GetProductInfoTest {
@Test(dataProvider="getData")
public void getproductInfo(String brandname, String productname) {
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	
	//search for a product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	
	//capture product info
	//String x ="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span";
	String x ="//span[text()='"+productname+"']/../../../..//span[@class='a-price']";

	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
}
	
//@DataProvider
//public  Object[][] getData(){
//	Object[][] objarr = new Object[3][2];
//	
//	objarr[0][0]="iphone";
//	objarr[0][1]="Apple iPhone 15 (128 GB) - Black";
//	objarr[1][0]="iphone";
//	objarr[1][1]="Apple iPhone 13 (128GB) - Blue";
//	objarr[2][0]="iphone";
//	objarr[2][1]="Apple iPhone 13 (128GB) - (Product) RED";  
//	
//	return objarr;
//	

@DataProvider
public  Object[][] getData() throws EncryptedDocumentException, IOException{
	ExcelUtility elib=new ExcelUtility();
	int Rowcount=elib.getRowcount("product");
	
	Object[][] objarr = new Object[Rowcount][2];

   for(int i=0;i<Rowcount;i++) {
	   objarr[i][0]=elib.getDataFromExcel("product", i+1, 0);
	   objarr[i][1]=elib.getDataFromExcel("product", i+1, 1);

 
   }
	
	return objarr;




	
}
	
	
	
	
	
	
	
	
	
	
	
}
