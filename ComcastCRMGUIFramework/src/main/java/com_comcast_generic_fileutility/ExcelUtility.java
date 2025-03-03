package com_comcast_generic_fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
     public String getDataFromExcel(String sheetName, int rownum, int celnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\pugazh\\eclipse-workspace\\ComcastCRMGUIFramework\\testData\\TESTSCRIPTDATA.xlsx");
    	// FileInputStream fis = new FileInputStream("‪C:\\Users\\pugazh\\Desktop\\org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rownum).getCell(celnum).getStringCellValue();
        return data;
    	 }
	
     public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis = new FileInputStream("C:\\Users\\pugazh\\eclipse-workspace\\ComcastCRMGUIFramework\\testData\\TESTSCRIPTDATA.xlsx");
 		Workbook wb = WorkbookFactory.create(fis);
 		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
     }
     
     public void setDataIntoExcel(String sheetName, int rownum, int celnum,String data) throws EncryptedDocumentException, IOException {
    	FileInputStream fis = new FileInputStream("C:\\Users\\pugazh\\eclipse-workspace\\ComcastCRMGUIFramework\\testData\\TESTSCRIPTDATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).getCell(celnum);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\pugazh\\eclipse-workspace\\ComcastCRMGUIFramework\\testData\\TESTSCRIPTDATA.xlsx");
		wb.write(fos);
		wb.close();
		
		
    }

}
