package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTesting {
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("Before suite executed");
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Before Test executed");
	}
	
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Before Class executed");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before Method executed");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("After suite executed");
	}
	
	
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("After Test executed");
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class executed");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method executed");
		
	}
	
	@Test
	public void Aeroplance() {
		
		System.out.println("This is an Aeroplane");
	}
	
	@Test(priority = -1)
	public void Book() {
		
		System.out.println("This is a Book");
		
	}
	
	@Test(priority =1)
	public void Chocolate() {
		
		System.out.println("This is a Chocolate");
	}
	
	@Test
	public void Delhi() {
		
		System.out.println("Delhi");
	}
	
	

}
