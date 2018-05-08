package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDFnewRegistration {

public static WebElement element = null;
	
	public static WebElement getPersonalPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#regPersonal")));
		return element;
		
	}
	
	public static WebElement getFreePlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/form/div/div[6]/table[1]/tbody/tr/td[2]")));
		return element;
}
	public static WebElement getEmailverification(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_email\"]")));
		return element;
}
	public static WebElement sendToken(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sendTokenBt\"]")));
		return element;
}
	public static WebElement setEmailToken(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_entered_mail_code\"]")));
		return element;
}
	public static WebElement getNextButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nextButton\"]")));
		return element;
}
	
	public static WebElement getErrormsg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/form/div/ul/li[14]/ul")));
		return element;
}
	public static WebElement SetPasswordForm(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_password\"]")));
		return element;
}
	public static WebElement setconfirmPassword(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_confirm\"]")));
		return element;
}
	
	
	public static WebElement getMobileRegion(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_mobile_region\"]")));
		return element;
}
	public static WebElement setPasswordPrivatekey(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		return element;
}

	public static WebElement getFormNext(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nextButton\"]")));
		return element;
	}
	
	public static WebElement getPrivateKey(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"createKeystore\"]")));
		return element;
	}
	
	public static WebElement getBrowser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"keystoreFile\"]")));
		return element;
	}
	
	public static WebElement validatePrivateKey(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div[1]/form/div/ul[5]/li[2]/span[1]/span")));
		return element;
	}
	
	public static WebElement setMobileToken(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_entered_token\"]")));
		return element;
	}
	
	public static WebElement getMobileNextbutton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nextButton\"]")));
		return element;
	}
}