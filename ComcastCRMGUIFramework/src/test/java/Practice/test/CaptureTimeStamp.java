package Practice.test;

import java.sql.Date;

public class CaptureTimeStamp {
 public static void main(String[]args) {
	 
    String Time= new java.util.Date().toString().replace(" ", "_").replace(":", " ");
    System.out.println(Time);
 }
}

//.replace(" ", "_").replace(":", " ")


//Thu Feb 20 13:20:51 IST 2025