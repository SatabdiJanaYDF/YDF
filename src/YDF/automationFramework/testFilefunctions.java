package YDF.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;


public class testFilefunctions {
	
	 WebDriver driver = new FirefoxDriver();
	 String UAT = "https://www.sit.yourdigitalfile.net/loginx/";
	 
	 
  @Test(priority=1)
  public void testLogin() throws Exception {
	  //in default category
	      driver.get(UAT);
	      
	      driver.manage().window().maximize();
	      
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckouteditor01@yourdigitalfile.com.au");
		  
		  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
		  
		  YDFlogIn.getlogIn(driver).click();
		  
		  Thread.sleep(1000);
  }
  @Test(priority=2)
  public void testOverlay() throws Exception {
	  
		
		  YDFFileFunction.overlayClose(driver).click();
		  
		  
  }
  
 // @Test(priority=3)
  public void testaddFilebutton() throws Exception {
	  
	      Thread.sleep(1000);
		  YDFFileFunction.addFile(driver).click();
		 
		  YDFFileFunction.setPassword(driver).sendKeys("Test1234");
		  
		  YDFFileFunction.getBrowser(driver).sendKeys("C:\\Test\\sit_keys\\teddy.lloyd+testcheckouteditor01@yourdigitalfile.com.au-www.sit.yourdigitalfile.net.ydf");
		 
		  YDFFileFunction.getPrivateKey(driver).click();
		  
		  
		 
  }
  
 // @Test(priority=4)
  public void testNewFile() throws Exception {
	  
	 
	   YDFFileFunction.setFilename(driver).sendKeys("File1");
	   
	   YDFFileFunction.getFilepath(driver).sendKeys("C:\\Test\\YDF\\src\\testData\\Test.txt");;
	   
	   YDFFileFunction.uploadFile(driver).click();;
	   
       Thread.sleep(5000);
	   
	String value=   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span")).getText();
	  
	Assert.assertEquals(value, "File1", "Not Successfully downloaded");
	   	  
	  }
  @Test(priority=5)
  
  public void testCheckout() throws Exception {
	  Thread.sleep(10000); 
	 
	 WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
	 Actions action = new Actions(driver);
	 
     action.moveToElement(element).build().perform();

     driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
	Thread.sleep(1000);  
   driver.findElement(By.xpath("//*[@id=\"keyStoreOverlayClose\"]")).click();
   String value = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div[2]/div/p")).getText();
	Assert.assertEquals(value, "File checked-out", "Not Checked out downloaded");
	   	  
	  }
  }

