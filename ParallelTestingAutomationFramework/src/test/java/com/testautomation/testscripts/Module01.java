package com.testautomation.testscripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.testautomation.base.BaseTest;
import com.testautomation.base.TestFactory;
import com.testautomation.extentreports.ExtentTestManager;
import com.testautomation.pageobjects.BasePage;
import com.testautomation.utilities.ExcelHandler;
import com.testautomation.utilities.PropertiesFileReader;

public class Module01 extends BaseTest {
	
	
	@Parameters({"testDataFile","testDataSheet"})
	@Test(groups = { "Module01", "TC_001" }, description = "Test login page")
	public void Test1(String testDataFile,String testDataSheet) throws Exception {
		Map<String, String> testData = ExcelHandler.getTestDataInMap(testDataFile,testDataSheet,"TC_001");
		WebDriver driver = TestFactory.getDriver();
		try {
			ExtentTestManager.getTest().log(Status.INFO, "test case 1 running...");
			BasePage basePage = new BasePage(driver);			
			String createAccStr = basePage.getCreateAccountText();
			Assert.assertTrue(createAccStr.equals("Create New Account"), "Text didn't match");
			basePage.loginToApp(testData.get("Email_ID"), testData.get("Password"));
			ExtentTestManager.getTest().log(Status.INFO, "test case 1 passed");	
			
			new TestFactory().testHandler("PASS", driver, ExtentTestManager.getTest(), null,testDataFile,testDataSheet,testData.get("TestCaseId"));
		} catch (AssertionError | Exception e) {
			new TestFactory().testHandler("FAIL", driver, ExtentTestManager.getTest(), e,testDataFile,testDataSheet,testData.get("TestCaseId"));
		}
	}
	
	@Parameters({"testDataFile","testDataSheet"})
	@Test(groups = { "Module01", "TC_002" }, description = "Test login page")
	public void Test2(String testDataFile,String testDataSheet) throws Exception {
		Map<String, String> testData = ExcelHandler.getTestDataInMap(testDataFile,testDataSheet,"TC_002");
		WebDriver driver = TestFactory.getDriver();
		try {
			ExtentTestManager.getTest().log(Status.INFO, "test case 2 running...");
			BasePage basePage = new BasePage(driver);			
			String createAccStr = basePage.getCreateAccountText();
			Assert.assertTrue(createAccStr.equals("Create New Account"), "Text didn't match");
			basePage.loginToApp(testData.get("Email_ID"), testData.get("Password"));
			ExtentTestManager.getTest().log(Status.INFO, "test case 2 passed");	
			
			new TestFactory().testHandler("PASS", driver, ExtentTestManager.getTest(), null,testDataFile,testDataSheet,testData.get("TestCaseId"));
		} catch (AssertionError | Exception e) {
			new TestFactory().testHandler("FAIL", driver, ExtentTestManager.getTest(), e,testDataFile,testDataSheet,testData.get("TestCaseId"));
		}
	}
	
	@Parameters({"testDataFile","testDataSheet"})
	@Test(groups = { "Module01", "TC_003" }, description = "Test login page")
	public void Test3(String testDataFile,String testDataSheet) throws Exception {
		Map<String, String> testData = ExcelHandler.getTestDataInMap(testDataFile,testDataSheet,"TC_003");
		WebDriver driver = TestFactory.getDriver();
		try {
			ExtentTestManager.getTest().log(Status.INFO, "test case 3 running...");
			BasePage basePage = new BasePage(driver);			
			String createAccStr = basePage.getCreateAccountText();
			Assert.assertTrue(createAccStr.equals("Create New Account"), "Text didn't match");
			basePage.loginToApp(testData.get("Email_ID"), testData.get("Password"));
			ExtentTestManager.getTest().log(Status.INFO, "test case 3 passed");	
			
			new TestFactory().testHandler("PASS", driver, ExtentTestManager.getTest(), null,testDataFile,testDataSheet,testData.get("TestCaseId"));
		} catch (AssertionError | Exception e) {
			new TestFactory().testHandler("FAIL", driver, ExtentTestManager.getTest(), e,testDataFile,testDataSheet,testData.get("TestCaseId"));
		}
	}
	
	@Parameters({"testDataFile","testDataSheet"})
	@Test(groups = { "Module01", "TC_004" }, description = "Test login page")
	public void Test4(String testDataFile,String testDataSheet) throws Exception {
		Map<String, String> testData = ExcelHandler.getTestDataInMap(testDataFile,testDataSheet,"TC_004");
		WebDriver driver = TestFactory.getDriver();
		try {
			ExtentTestManager.getTest().log(Status.INFO, "test case 4 running...");
			BasePage basePage = new BasePage(driver);			
			String createAccStr = basePage.getCreateAccountText();
			basePage.loginToApp(testData.get("Email_ID"), testData.get("Password"));
			Assert.assertTrue(createAccStr.equals("Create an account..."), "Text didn't match");			
			ExtentTestManager.getTest().log(Status.INFO, "test case 4 passed");	
			
			new TestFactory().testHandler("PASS", driver, ExtentTestManager.getTest(), null,testDataFile,testDataSheet,testData.get("TestCaseId"));
		} catch (AssertionError | Exception e) {
			new TestFactory().testHandler("FAIL", driver, ExtentTestManager.getTest(), e,testDataFile,testDataSheet,testData.get("TestCaseId"));
		}
	}
	
}