package com.PageFactoryConcept;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;



public class LoginPage  {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, driver);
	}
	
	//Locator for username field
	@FindBy(id="userName")
	WebElement uName;
	
	@FindBy(id="password")
	WebElement pswd;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
		//By uName = By.id("userName");
		
		//Locator for password field
		//By pswd = By.id("password");
		
		//Locator for login button
		//By loginBtn = By.id("login");
		
		
		//Method to enter username
		public void enterUsername(String user) {
		uName.sendKeys(user);
		}

		//Method to enter password
		public void enterPassword(String pass) {
			pswd.sendKeys(pass);
		}
		
		//Method to click on Login button
		public void clickLogin() {
			
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginBtn);
			//driver.findElement(loginBtn).click();
		}
		
		

		

}
