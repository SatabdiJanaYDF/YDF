package YDF.automationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.YDFnewRegistration;
import Utility.CreateUser;
import Utility.ExcelApiTest;
import Utility.Screenshots;

public class TestPhoneNumber {
	
	 
	
	String filepath= "C:\\Test\\Phonenum.xlsx";
	
	WebDriver  driver  ;
	// int i=0;

  
  
@Test (dataProvider= "PhoneData")
	 public void testPhone(String Phone , String i) throws Exception {
	  
	      driver = new FirefoxDriver ();
	     driver.get("https://www.test.yourdigitalfile.net/login/");
		
		 driver.findElement(By.xpath(" /html/body/div[1]/div/div[4]/div/div[2]/div[2]/div/div[2]/h4/a")).click();
		 
	 
	      YDFnewRegistration.getPersonalPlan(driver).click();
		 
		
		 YDFnewRegistration.getFreePlan(driver).click();
		 
		 Thread.sleep(1000);
		 
		
		String email= CreateUser.createUserruntime();
		String PrivateKey ="C:\\Users\\satabdi.jana\\Downloads\\"+ CreateUser.Privatekey(email);
		System.out.println(PrivateKey);
		
		try {
		 YDFnewRegistration.getEmailverification(driver).sendKeys(email);
		 YDFnewRegistration.sendToken(driver).click();
		}catch(Exception e) {
			 Screenshots.takeSnapShot(driver);
		}
		 
		
		try{
		 YDFnewRegistration.setEmailToken(driver).sendKeys("1234");
		 
		 YDFnewRegistration.getNextButton(driver).click();
		}catch(Exception e)
		{
			Screenshots.takeSnapShot(driver);
		}
		
		try {
	       YDFnewRegistration.SetPasswordForm(driver).sendKeys("Test12345678");
	       YDFnewRegistration.setconfirmPassword(driver).sendKeys("Test12345678");
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//*[@id=\"id_first_name\"]")).sendKeys("SA");
	       driver.findElement(By.xpath("//*[@id=\"id_last_name\"]")).sendKeys("JA");
	       Select mobile = new Select(YDFnewRegistration.getMobileRegion(driver));
            int index = Integer.parseInt(i);
		    mobile.selectByIndex(index);
		    driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).sendKeys(Phone);
		    YDFnewRegistration.getFormNext(driver).click();
	      }catch (Exception e) {
	    		Screenshots.takeSnapShot(driver);
	    		driver.close();
	    		driver.quit();
	    		
	      }
	      Thread.sleep(5000);
	      try {
			YDFnewRegistration.setPasswordPrivatekey(driver).sendKeys("Test12345678");
			YDFnewRegistration.getPrivateKey(driver).click();
			Thread.sleep(5000);
			Savefile();
			Thread.sleep(5000);
         	YDFnewRegistration.getBrowser(driver).sendKeys(PrivateKey);;
         	YDFnewRegistration.validatePrivateKey(driver).click();
	      }catch(Exception e)
	      {
	    	  Screenshots.takeSnapShot(driver);
	    	  driver.close();
	    	  driver.quit();
	      }
         	
         	try {
         	Thread.sleep(10000);
         	YDFnewRegistration.setMobileToken(driver).sendKeys("1234");
         	YDFnewRegistration.getMobileNextbutton(driver).click();
         	}catch(Exception e)
         	{
         		 Screenshots.takeSnapShot(driver);
         		driver.close();
	    		driver.quit();
         	}
			
         	Thread.sleep(20000);
         	Assert.assertEquals(driver.getTitle(), "Your Digital File", "loggedin not succesful");
         	try {
         		driver.close();
         	driver.quit();
         	}catch (Exception e) {
         		driver.quit();
         	}
         	
         	 }



	         
public void Savefile() throws AWTException {
	Robot robo= new Robot();
	robo.keyPress(KeyEvent.VK_DOWN);
	robo.keyRelease(KeyEvent.VK_DOWN);
	robo.keyPress(KeyEvent.VK_ENTER);
}
  
  
  @DataProvider(name="PhoneData")

  public Object[][] testData() throws Exception
  {
	  
  	ExcelApiTest config = new ExcelApiTest(filepath);
  	int rows = config.getRowCount(0);
  	Object[][]data=new Object[rows][2];
  	try {
  	for (int i=0;i<rows;i++) {
  	data[i][0]=config.getDataNumericAsString(0, i, 0);
  	data[i][1]=config.getDataNumericAsString(0, i, 1);
  	
  	}
  	//return data;
	  }catch(Exception e)
	  {
		  System.out.println("The Exception is : " + e.getMessage());  
	  }
	return data;
     
  } 

}
