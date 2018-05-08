package YDF.automationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;
import Utility.ExcelApiTest;


public class testFileOwnerCheckout {
	
	 String filepath= "C:\\Test\\DATABASE.xlsx";
	 
@Test(dataProvider="SITData")
  public void testLogin(String username,String key) throws Exception {
	   
	WebDriver driver= new FirefoxDriver();
	 String UAT = "https://www.sit.yourdigitalfile.net/loginx/"; 
	
	      driver.get(UAT);
	      
	      driver.manage().window().maximize();
	      
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		  YDFlogIn.getEmail(driver).sendKeys(username);
		  
		  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
		  
		  YDFlogIn.getlogIn(driver).click();
		  
		  Thread.sleep(1000);
 
          YDFFileFunction.overlayClose(driver).click();
		  Thread.sleep(1000);
		  YDFFileFunction.addFile(driver).click();
		 
		  YDFFileFunction.setPassword(driver).sendKeys("Test1234");
		  
		  YDFFileFunction.getBrowser(driver).sendKeys(key);
		 
		  YDFFileFunction.getPrivateKey(driver).click();
		  
	 
	   YDFFileFunction.setFilename(driver).sendKeys("Checkoutmem");
	   
	   YDFFileFunction.getFilepath(driver).sendKeys("C:\\Test\\YDF\\src\\testData\\Test.txt");;
	   
	   YDFFileFunction.uploadFile(driver).click();;
	   
       Thread.sleep(5000);
	   
      // String value=   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span")).getText();
	  
	 //  Assert.assertEquals(value, "Checkout", "Not Successfully downloaded");
	   	  
	// Thread.sleep(5000); 
	 //Mouse hover on new file
	 WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
	 Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
     //Click on  Check out
     driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
    
	  Thread.sleep(5000);  
	  Cancelfile();
    //  String value2 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div[2]/div/p")).getText();
	 //Assert.assertEquals(value2, "Checkout.txt download successful", "Not Checked out downloaded");
	  	  
       Thread.sleep(5000); 
		 
		 WebElement mouseelement=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
		 Actions action1 = new Actions(driver);
         action1.moveToElement(mouseelement).build().perform();
        //Click on cancel check out
	     driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
		 Thread.sleep(5000);  

	   //  String value3 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div[2]/div/p")).getText();
		// Assert.assertEquals(value3, "File cancelled check-out", "Checked out not canceled");

	     Thread.sleep(10000); 
		 
     	 WebElement element1=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
		 Actions action2 = new Actions(driver);
		  action2.moveToElement(element1).build().perform();
	     
	     //Click on Delete
	     driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[10]/img")).click();
		 Thread.sleep(5000); 
		 //Delete Overlay
	     driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[2]/span[1]")).click();
	     
	   //logout
	     Thread.sleep(5000); 
	     try {
	    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[2]/a/img")).click();
	    Alert alert = driver.switchTo().alert();		
 		
	     // Capturing alert message.    
	     String alertMessage= driver.switchTo().alert().getText();		
	     		
	     // Displaying alert message		
	     System.out.println(alertMessage);	
	     Thread.sleep(2000);
	     		
	     // Accepting alert		
	     alert.accept();	
	     driver.quit();
	     Thread.sleep(5000); 
	     }catch(Exception e) {
	    	 driver.quit();
	     }
        
	    
	  }
  
  public void Cancelfile() throws AWTException {
		Robot robo= new Robot();
		robo.keyPress(KeyEvent.VK_TAB	);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB	);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB	);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_ENTER);
	}
  
@DataProvider(name="SITData")
public Object[][] testData() throws Exception
{
	  
	ExcelApiTest config = new ExcelApiTest(filepath);
	int rows = config.getRowCount(0);
	Object[][]data=new Object[rows][2];
	try {
	for (int i=0;i<rows;i++) {
	data[i][0]=config.getData(0, i, 0);
	data[i][1]=config.getData(0, i, 1);
	}
	//return data;
	}catch(Exception e)
	  {
		System.out.println("The Exception is : " + e.getMessage());
	  }
	return data;
	
	}
}
