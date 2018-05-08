package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;


public class Screenshots {
	public static void takeSnapShot(WebDriver driver) throws Exception{
            
	      DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy_h-m-s");
	        Date date = new Date();
	        
	      //Convert web driver object to TakeScreenshot

	      TakesScreenshot scrShot =((TakesScreenshot)driver);

	      //Call getScreenshotAs method to create image file

	              File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	          //Move image file to new destination
	              String filename="Error";
	              

	              File DestFile=new File("C:\\Test\\Error\\"+filename+"-"+dateFormat.format(date)+".png");

	              //Copy file at destination

	              FileUtils.copyFile(SrcFile, DestFile);

	  }

}
