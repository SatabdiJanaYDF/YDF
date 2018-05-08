package YDF.automationFramework;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.YDFnewRegistration;

public class TestPhoneNegative {
	 
	

	WebDriver driver = new FirefoxDriver ();

  @Test
  public void testEmptySpecialcharPh() throws Exception {
	  
	  driver.get("https://www.test.yourdigitalfile.net/register/");
		 
	  YDFnewRegistration.getPersonalPlan(driver).click();
	 
	  YDFnewRegistration.getFreePlan(driver).click();
	 
     YDFnewRegistration.getEmailverification(driver).sendKeys("satabdi.jana12@yourdigitalfile.com.au");
     Thread.sleep(5000);
	 YDFnewRegistration.sendToken(driver).click();
	
	 Thread.sleep(5000);
	 YDFnewRegistration.setEmailToken(driver).sendKeys("1234");
	 
	 YDFnewRegistration.getNextButton(driver).click(); 
	 try {
	 Thread.sleep(5000);
	  
	 Select  mobile = new Select(YDFnewRegistration.getMobileRegion(driver));
		 
	  List<WebElement> listOptionDropdown = mobile.getOptions();
  
	  int size=listOptionDropdown.size();
	  
        for (int i=0;i<size;i++) {
        	Thread.sleep(5000);
		mobile.selectByIndex(i);
		driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).sendKeys("+");
		YDFnewRegistration.getFormNext(driver).click();	
		 System.out.println(YDFnewRegistration.getErrormsg(driver).getText());
		 driver.findElement(By.xpath("//*[@id=\"id_mobile_number\"]")).clear();
        }
        
	 }catch(Exception e) {
		 System.out.println("Error is :"+ e);
	 }
   }
  
  
  @DataProvider(name="Specialdata")
  public String[]testData() throws Exception
  {
	 String[] data = {"+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^", "~", "*", "?", ":","\"","\\" ," "};
	 int size = data.length;
	 for (int j=0;j<size;) {
		j++;
	 }
	return data;
  	}
  
  	

  
  
}
