package YDF.automationFramework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.YDFlogIn;
import Pages.YDFlogOut;
import Utility.ExcelApiTest;



//To check that Web page is launching correctly
public class TestYDFlogIN {

	
	 WebDriver driver = new FirefoxDriver();
	 String UAT = "https://www.uat.yourdigitalfile.net/login/#";
	// String prod="https://www.yourdigitalfile.com.au/login/";
	 String filepath="C:\\Test\\DATABASE.xlsx";

	 String currentURL = "https://www.uat.yourdigitalfile.net/";
		
		
	
  
 @Test (dataProvider="userData")
public void TestLogin(String email,String password) throws InterruptedException { 
	 
	 driver.get(UAT);
	 Thread.sleep(2000);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 
	 YDFlogIn.getEmail(driver).clear();
	 YDFlogIn.getEmail(driver).sendKeys(email);
	
	 YDFlogIn.getpassword(driver).clear();
	 YDFlogIn.getpassword(driver).sendKeys(password);

	
	 YDFlogIn.getlogIn(driver).click();

	
	 System.out.println(driver.getCurrentUrl());
    // Assert.assertEquals(driver.getCurrentUrl(), "https://www.uat.yourdigitalfile.net/");
	 Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://www.uat.yourdigitalfile.net/"),"Not a valid user");
	 
      if (driver.getCurrentUrl().equals(currentURL)){
		driver.navigate().back();
	
		 YDFlogOut.getlogOut(driver).click();
		 // Switching to Alert        
	     Alert alert = driver.switchTo().alert();		
	     		
	     // Capturing alert message.    
	     String alertMessage= driver.switchTo().alert().getText();		
	     		
	     // Displaying alert message		
	     System.out.println(alertMessage);	
	     Thread.sleep(2000);
	     		
	     // Accepting alert		
	     alert.accept();	
	     
      }
	    
	}
	
	 
@DataProvider(name="userData")

public Object[][] testData() throws Exception
{
	ExcelApiTest config = new ExcelApiTest(filepath);
	int rows = config.getRowCount(0);
	Object[][]data=new Object[rows][2];
	for (int i=0;i<rows;i++) {
	data[i][0]=config.getData(0, i, 0);
	data[i][1]=config.getData(0, i, 1);
	}
	return data;
	}
}
