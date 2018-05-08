package YDF.automationFramework;

	 
	import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
	 
	import org.testng.annotations.Parameters;
	 
	import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;
import Pages.YDFlogOut;
	 
	public class MultiBrowser {
	 
		public WebDriver driver;
	 
		 String Prod = "https://www.yourdigitalfile.com.au/login/";

	@Parameters("browser")
	 
	  @BeforeClass
	 
	 
	  public void beforeTest(String browser) {
	 
	 
	  if(browser.equalsIgnoreCase("firefox")) {
       driver = new FirefoxDriver();
	  
	 
	  }
	  
	  
//	  else if (browser.equalsIgnoreCase("ie")) { 
//	 
//       String Driver_Path= "C:\\Test\\IEDriverServer_x64_3.11.1\\IEDriverServer.exe";
//        
//        System.setProperty("webdriver.ie.driver", Driver_Path);
//        
//       DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
//        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//         driver = new InternetExplorerDriver(dc);
//         

		  
		  
//	}
	  else if (browser.equalsIgnoreCase("chrome")) { 
			 

		  System.setProperty("webdriver.chrome.driver", "C:\\Test\\chromedriver_win32\\chromedriver.exe");

		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("test-type");
		    options.addArguments("--disable-extensions");
		    options.addArguments("--start-maximized");
		    options.setExperimentalOption("excludeSwitches", Arrays.asList("ignorecertificate-errors"));
		    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); 
	
		   driver = new ChromeDriver(options);
	 
	  }  
//Selenium 2 support safari driver in window	  
//	  else if (browser.equalsIgnoreCase("safari")) {
//		  driver = new SafariDriver();
//	  }
	  }
	 
	  // Once Before method is completed, Test method will start
	 
	@Test(priority=1)
	  public void testLogin() throws Exception {
		  //in default category
		      driver.get(Prod);
		      
		   //   driver.manage().window().maximize();
		      
			 
			
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
		   
		   YDFFileFunction.getFilepath(driver).sendKeys("C:\\Test\\YDF\\src\\testData\\Test.txt");
		   
		   Thread.sleep(2000);
		  
		  
		  if( driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span")).getText().equals("File1")){
		   
			  Assert.fail("file already existed");
		  }
		  
		  else {
		   YDFFileFunction.uploadFile(driver).click();;
		   
	    
		  }
		
		  
		  }
	  
	 @Test(priority=5)
	 
	 public void testLogout() throws Exception {
		 driver.navigate().back();
			Thread.sleep(2000);
			 YDFlogOut.getlogOut(driver).click();
			 // Switching to Alert        
		     Alert alert = driver.switchTo().alert();		
		     		
		     // Capturing alert message.    
		     String alertMessage= driver.switchTo().alert().getText();		
		     		
		     // Displaying alert message		
		     System.out.println(alertMessage);	
		     Thread.sleep(5000);
		     		
		     // Accepting alert		
		     alert.accept();	
		     driver.quit();
	 }

	 
	}

