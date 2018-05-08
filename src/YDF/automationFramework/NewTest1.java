package YDF.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.YDFFileFunction;
import Pages.YDFlogIn;

public class NewTest1 {
	String filepath= "C:\\Test\\DATABASE.xlsx";
	 String UAT = "https://www.sit.yourdigitalfile.net/loginx/";
	 WebDriver driver= new FirefoxDriver();
  @Test
  public void f() throws Exception {
		// WebDriver driver= new FirefoxDriver();
		 driver.get(UAT);
	     
	     driver.manage().window().maximize();
	     
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		  YDFlogIn.getEmail(driver).sendKeys("teddy.lloyd+testcheckoutmember01@yourdigitalfile.com.au");
		  
		  YDFlogIn.getpassword(driver).sendKeys("Test1234"); 
		  
		  YDFlogIn.getlogIn(driver).click();
		  
		  Thread.sleep(1000);

	     YDFFileFunction.overlayClose(driver).click();
		  Thread.sleep(10000);
		  WebElement element=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/div/span"));
	 	   Actions action = new Actions(driver);
	 	   action.moveToElement(element).build().perform();
		    WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div/div[2]/div[2]/div/div[4]/div/table/tbody/tr[2]/td[5]/div[1]/span[8]/img"));
		    Actions toolAct = new Actions(driver);
		    toolAct.moveToElement(element1).build().perform();
		    WebElement toolTipElement = driver.findElement(By.className("tooltip"));
		    String toolTipText = toolTipElement.getText();
		    System.out.println(toolTipText);
		 
  }
}
