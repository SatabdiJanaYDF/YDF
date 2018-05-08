package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Outlook {
 
  public void OpenEmail() throws AWTException, InterruptedException {
	  
	  Robot robo= new Robot();
	  robo.keyPress(KeyEvent.VK_WINDOWS);
	  robo.keyRelease(KeyEvent.VK_WINDOWS);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_O);
	  robo.keyRelease(KeyEvent.VK_O);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_ENTER);
	  robo.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_ALT);
	  robo.keyPress(KeyEvent.VK_SPACE);
	  robo.keyRelease(KeyEvent.VK_ALT);
	  robo.keyRelease(KeyEvent.VK_SPACE);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_DOWN);
	  robo.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_DOWN);
	  robo.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_DOWN);
	  robo.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_DOWN);
	  robo.keyRelease(KeyEvent.VK_DOWN);
	  Thread.sleep(2000);
	  robo.keyPress(KeyEvent.VK_ENTER);
	  robo.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(2000);
  }
}
