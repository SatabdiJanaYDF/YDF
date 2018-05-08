package Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateUser {
	
	public static String createUserruntime() throws Exception{
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-h-m-s");
        Date date = new Date();
		String user ="satabdi.jana+"+dateFormat.format(date)+"@yourdigitalfile.com.au";
		return user;
		
		
	}
	
	
	public static String Privatekey(String user) {
		String Privatekey=user+"-www.test.yourdigitalfile.net.ydf";
		return Privatekey;
		
	}

}
