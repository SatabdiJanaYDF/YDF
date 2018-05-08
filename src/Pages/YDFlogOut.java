package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDFlogOut {
	public static WebElement element = null;
	
	public static WebElement getlogOut(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20); 
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logoutLink")));
		return element;
	}

}
