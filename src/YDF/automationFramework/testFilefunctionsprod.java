package YDF.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;
import Pages.YDFlogOut;


public class testFilefunctionsprod {
	
	 WebDriver driver = new FirefoxDriver();

	 String UAT = "https://www.yourdigitalfile.com.au/login/";
	 
  @Test(priority=1)
  public void testLogin() throws Exception {
	  //in default category
	      driver.get(UAT);
	      
	      driver.manage().window().maximize();
	      
		 
		
		 YDFlogIn.getLogInButton(driver).click();
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		  YDFlogIn.getEmail(driver).sendKeys("satabdi.jana+test09@yourdigitalfile.com.au");
		  
		  YDFlogIn.getpassword(driver).sendKeys("Test12345678"); 
		  
		  YDFlogIn.getlogIn(driver).click();
		  
		  Thread.sleep(1000);
  }
  @Test(priority=2)
  public void testOverlay() throws Exception {
	  
		
		  YDFFileFunction.overlayClose(driver).click();
		  
		  
  }
  
  @Test(priority=3)
  public void testaddFilebutton() throws Exception {
	  
	      Thread.sleep(1000);
		  YDFFileFunction.addFile(driver).click();
		 
		  YDFFileFunction.setPassword(driver).sendKeys("Test12345678");
		  Thread.sleep(1000);
		  
		  YDFFileFunction.getBrowser(driver).sendKeys("C:\\Test\\satabdi.jana+test09@yourdigitalfile.com.au-www.yourdigitalfile.com.au.ydf");
		 
		  YDFFileFunction.getPrivateKey(driver).click();
		  
		  
		 
  }
  
  @Test(priority=4)
  public void testNewFile() throws Exception {
	  
	 
	   YDFFileFunction.setFilename(driver).sendKeys("File1");
	   
	   YDFFileFunction.getFilepath(driver).sendKeys("C:\\Test\\YDF\\src\\testData\\Test.txt");;
	   
	   YDFFileFunction.uploadFile(driver).click();;
	   
       Thread.sleep(2000);
	   
	String value=   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span")).getText();
	  
	Assert.assertEquals(value, "File1", "Not Successfully downloaded");
	   	  
	  }
  
  @Test(priority=5)
  public void testlogOut () throws Exception {
	  
	  
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

