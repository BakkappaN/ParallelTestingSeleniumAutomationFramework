package com.testautomation.base;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testautomation.utilities.PropertiesFileReader;
import com.testautomation.utilities.TestDataHandler;

public class BaseTest {
	
	@BeforeSuite(alwaysRun=true)
	public void oneTimeSetUp() {
		PropertiesFileReader configData = new PropertiesFileReader();
		Properties prop=null;
		try {
			prop = configData.getPropertyForConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TestDataHandler().setEnvironment(prop.get("ApplicationEnvironment").toString());
	}
	
	@AfterSuite(alwaysRun=true)
	public void oneTimeTearDown() {
		System.out.println("Completed with executing all the Test cases...");
	}
	
	
}
