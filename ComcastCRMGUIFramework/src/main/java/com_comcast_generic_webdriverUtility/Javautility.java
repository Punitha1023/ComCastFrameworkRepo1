package com_comcast_generic_webdriverUtility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Javautility {
       public int  getRandomNumber() {
    	   Random random = new Random();
    	  int rantInt= random.nextInt(5000);
    	  return rantInt;
       }
       
       
    public String getSystemDateYYYYDDMM() {
    	Date dateObj = new Date();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String date=sdf.format(dateObj);
    	return date;
    }
       
       public String getRequiredDateYYYYDDMM(int days) {
    	   Date dateObj = new Date();
       	
       	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       	String date=sdf.format(dateObj);
    	   
    	   Calendar cal = sdf.getCalendar();
    	   cal.add(Calendar.DAY_OF_MONTH, days);
    	   String reqDate = sdf.format(cal.getTime());
		return reqDate;
       
       
       }
       
       
       
       
       
       
}
