package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDFlogIn {
	public static WebElement element = null;
	
	public static WebElement getEmail(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_username")));
		//element = driver.findElement(By.name("username"));
		return element;
		
	}
	
	public static WebElement getpassword(WebDriver driver) {
		element = driver.findElement(By.name("password"));
	    return element;
	}
	
	public static WebElement getlogIn(WebDriver driver) {
		element = driver.findElement(By.id("loginButton"));
		return element;
	}
	
	public static WebElement getLogInButton(WebDriver driver) {
		 element = driver.findElement(By.cssSelector(".btn-blue-inverted > span:nth-child(1)"));
		 return element;
	}

}
