package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGExamples {
  @Test(dataProvider = "testData")
  public void f(Integer n, String s) {
	 System.out.println("Data Provider value : " ); 
	 System.out.println(n +"  " + s); 
	  
  }
  
  @DataProvider(name = "testData")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
    };
  }
  
  
  
  @Test(priority=0)
  public void method1() {
	  System.out.println("Method 1 with priority=0");
   }
   
  @Test(priority=1)
  public void method2() {
	  System.out.println("Method 2 with priority=1");
   }
   
  @Test(priority=2 , groups= {"Smoke","Sanity"})
  public void method3() {
	  System.out.println("Method 3 with priority=2");
   }
  @Test (groups= {"Smoke"})
  public void method4() {
	  System.out.println("Method 4 with out priority");
   }
  
  @BeforeMethod (alwaysRun = true ,groups= {"Smoke"} )
  public void beforeMethod() {
	  System.out.println("This is Before method ");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method ");
  }


  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is Before class method ");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("This is After Class method ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is Before Test method ");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is After Test method ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is Before Suite method ");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is After Suite method ");
  }

}
