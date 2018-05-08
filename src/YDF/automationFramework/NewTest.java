package YDF.automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("Test1");
  }
  @Test
  public void f1() {
	  System.out.println("Test2");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }
  @BeforeMethod
  public void beforemethod() {
	  System.out.println("beforeMethod");
  }
  @BeforeMethod
  public void afteremethod() {
	  System.out.println("afterMethod");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
  }

}
