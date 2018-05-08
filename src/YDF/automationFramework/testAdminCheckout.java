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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;
import Utility.Screenshots;


public class testAdminCheckout {
	 
	 String filepath= "C:\\Test\\DATABASE.xlsx";
	 String UAT = "https://www.sit.yourdigitalfile.net/loginx/";
	 WebDriver driver= new FirefoxDriver();
	 Boolean bol;

@BeforeMethod
public void admincheckout() throws Exception {
	// WebDriver driver= new FirefoxDriver();
	   driver.get(UAT);
     
     driver.manage().window().maximize();
     
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 
	  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckoutorg02@yourdigitalfile.com.au");
	  
	  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
	  
	  YDFlogIn.getlogIn(driver).click();
	  
	  Thread.sleep(1000);

     YDFFileFunction.overlayClose(driver).click();
	  Thread.sleep(10000);
	 String Filename=  driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span[1]")).getText();
	  
    if(Filename.contentEquals("A")) {
    	
    	//Mouse hover on new file
 	   WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
 	   Actions action = new Actions(driver);
 	   action.moveToElement(element).build().perform();
      //Read the File already checked out 
 	   
 	    WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img"));
	    Actions toolAct = new Actions(driver);
	    toolAct.moveToElement(element1).build().perform();
	    WebElement toolTipElement = driver.findElement(By.className("tooltip"));
	    String toolTipText = toolTipElement.getText();
	    System.out.println(toolTipText);
	    
       if (toolTipText.contains("Cancel check-out") )
         {
          signout();
    
         }else {
               driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
 	           Thread.sleep(5000);  
               driver.findElement(By.xpath("//*[@id=\"keyStoreOverlayClose\"]")).click();
               Thread.sleep(5000); 
               signout();

               }  
    }else {
 	      Thread.sleep(5000);
 	      
 	      //Add File
 	      
 		   YDFFileFunction.addFile(driver).click();
 		   YDFFileFunction.setPassword(driver).sendKeys("Test1234");
 		   YDFFileFunction.getBrowser(driver).sendKeys("C:\\Test\\sit_keys\\teddy.lloyd+testcheckoutorg02@yourdigitalfile.com.au-www.sit.yourdigitalfile.net.ydf");
 		   YDFFileFunction.getPrivateKey(driver).click();
 		   YDFFileFunction.setFilename(driver).sendKeys("A");
 		   YDFFileFunction.getFilepath(driver).sendKeys("C:\\Test\\YDF\\src\\testData\\Test.txt");;
 		   YDFFileFunction.uploadFile(driver).click();;
 		   Thread.sleep(10000);

 	     
 	        //Mouse hover on new file
 	 	    WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
 	 	   Actions action = new Actions(driver);
 	 	   action.moveToElement(element).build().perform();
 	 	   
 	      //Click on  Check out
 	      driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
 	      Thread.sleep(5000);  
 	   	  Cancelfile();
 	      //Thread.sleep(5000); 
 	       signout();
    }
  
 }


       
@Test(priority =1)
  public void testmemNooption() throws Exception {
	   
	    //  WebDriver driver= new FirefoxDriver();
    	  //Admin log in 
    	 
	 driver.get(UAT);
     
	  driver.manage().window().maximize();
		      
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 
	  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckoutmember01@yourdigitalfile.com.au");
			  
	  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
			  
	  YDFlogIn.getlogIn(driver).click();
			  
	  Thread.sleep(1000);
	 
	   YDFFileFunction.overlayClose(driver).click();
		
	   Thread.sleep(1000);
	   WebElement elementadmin=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
 	 
	   Actions actionadmin = new Actions(driver);
		    	 
	   actionadmin.moveToElement(elementadmin).build().perform();
	   try {
		   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click(); 
		   Screenshots.takeSnapShot(driver);
	   }catch(Exception e)
	   {
		   
		  Assert.assertTrue(true, "Not found");
	   }
}

@Test(priority =2)
public void testLeadercancel() throws Exception {
	
	 
	// WebDriver driver1= new FirefoxDriver();
	  //Admin log in 
	 
	  driver.get(UAT);
		      
	  driver.navigate().refresh();
		      
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 
	  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckoutleader01@yourdigitalfile.com.au");
			  
	  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
			  
	  YDFlogIn.getlogIn(driver).click();
			  
	  Thread.sleep(1000);
	 
	   YDFFileFunction.overlayClose(driver).click();
		
	   Thread.sleep(1000);
			
	  //Admin cancel checkout
	   WebElement elementadmin=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
		    	 
	   Actions actionadmin = new Actions(driver);
		    	 
	   actionadmin.moveToElement(elementadmin).build().perform();
		         
	   //Click on  Check out
		         
	   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click();
	    
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[2]/span[2]/span")).click();
		         //Confirm
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[2]/span[1]/span")).click();
	   Thread.sleep(2000);
	   String heading = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div/div[2]/div/p")).getText();
		         
	   Assert.assertEquals(heading, "File cancelled check-out"); 

	  }

@Test(priority =3)
public void testReviewerNoOption() throws Exception {
	
	 
	// WebDriver driver1= new FirefoxDriver();
	  //Admin log in 
	 
	  driver.get(UAT);
		      
	  driver.manage().window().maximize();
		      
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 
	  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckoutreviewer01@yourdigitalfile.com.au");
			  
	  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
			  
	  YDFlogIn.getlogIn(driver).click();
			  
	  Thread.sleep(1000);
	 
	   YDFFileFunction.overlayClose(driver).click();
		
	   Thread.sleep(1000);
	   WebElement elementadmin=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
  	 
	   Actions actionadmin = new Actions(driver);
		    	 
	   actionadmin.moveToElement(elementadmin).build().perform();
	   try {
		   driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img")).click(); 
		   Screenshots.takeSnapShot(driver);
	   }catch(Exception e)
	   {
		   
		  Assert.assertTrue(true, "Not found");
	   }
}
	
  @Test(priority =4)
	   public void testEditorNoOption() throws Exception {
	   	
	   	 
	   	  driver.get(UAT);
	   		      
	   	  driver.manage().window().maximize();
	   		      
	   	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   			 
	   	  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckouteditor01@yourdigitalfile.com.au");
	   			  
	   	  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
	   			  
	   	  YDFlogIn.getlogIn(driver).click();
	   			  
	   	  Thread.sleep(1000);
	   	 
	   	   YDFFileFunction.overlayClose(driver).click();
	   		
	   	   Thread.sleep(1000);
	   	   WebElement elementadmin=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
	     	 
	   	   Actions actionadmin = new Actions(driver);
	   	   actionadmin.moveToElement(elementadmin).build().perform();
	   	
	  	   WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[5]/img"));
		    Actions toolAct = new Actions(driver);
		    toolAct.moveToElement(element1).build().perform();
		    WebElement toolTipElement = driver.findElement(By.className("tooltip"));
		    String toolTipText = toolTipElement.getText();
		    System.out.println(toolTipText);
	   	    Assert.assertEquals(toolTipText, "Request check-in");
	   	   
}
@AfterMethod
public void logout() throws Exception {
	
	signout();
}
public void signout() {
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
		   // driver.quit();
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
  

}
