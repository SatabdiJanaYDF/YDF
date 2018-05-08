package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDFFileFunction {

	
	public static WebElement element = null;

	
	public static WebElement addFile(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20); 
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addFile > img:nth-child(1)")));
		return element;
		
	}
	
	public static WebElement setPassword(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("keystorePassword")));
		return element;
		
	}
	
	public static WebElement overlayClose(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#closeOverlay")));
		return element;
		
	}
	
	public static WebElement getBrowser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"keystorePath\"]")));
		return element;
		
	}
	
	public static WebElement getPrivateKey(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"overlay_button\"]")));
		return element;
		
	}

	public static WebElement setFilename(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,100);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id_name")));
		return element;
		
	}
	
	public static WebElement getFilepath(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,100);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#uploadPath")));
		return element;
		
	}
	
	public static WebElement uploadFile(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,100);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#upload_button > span:nth-child(2)")));
		return element;
		
	}
	
}
