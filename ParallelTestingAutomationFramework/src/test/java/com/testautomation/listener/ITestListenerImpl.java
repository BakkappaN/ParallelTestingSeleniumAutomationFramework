package com.testautomation.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.testautomation.extentreports.ExtentManager;
import com.testautomation.extentreports.ExtentTestManager;
import com.testautomation.testscripts.Module01;

public class ITestListenerImpl implements ITestListener {
	
	private static final Logger logger = LogManager.getLogger(ITestListenerImpl.class);

	public void onStart(ITestContext context) {
		logger.info("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		logger.info("*** Test Suite " + context.getName() + " ending ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		logger.info("*** Running test method " + result.getMethod().getMethodName() + "...");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
	}

	public void onTestFailure(ITestResult result) {
		logger.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}
