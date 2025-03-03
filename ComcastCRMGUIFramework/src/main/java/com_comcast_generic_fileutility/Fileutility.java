package com_comcast_generic_fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {
 public String getDataPropertyFile(String key) throws IOException {
	
	 FileInputStream fis = new FileInputStream("C:\\Users\\pugazh\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
	 Properties pObj = new Properties();
	 pObj.load(fis);
	 String data=pObj.getProperty(key);
	 
	 return data;
	 
 }
}
