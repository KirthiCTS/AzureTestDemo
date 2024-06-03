
package com.cucumber.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = {
		"C:\\Project\\Selenium_Training\\Selenium_Traininng_Workspace\\Selenium_Training\\Features\\MyTest.feature" }, glue = {
				"com.cucumber.StepDefinition" }, plugin = { "pretty" })

public class Test_Runner extends AbstractTestNGCucumberTests {

}