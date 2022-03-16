package com.testautomation.extentreports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static String reportFileName = "Test-Automaton-Report";
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = "./reports/AutomationReport_"+getCurrentDateTimeForReport()+".html";       
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"); 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);        
        extent.setSystemInfo("Application", "Youtube");
        extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
        return extent;
    }
    
	public ITestContext setiTestContext(ITestContext iTestContext,WebDriver driver) {
		iTestContext.setAttribute("driver", driver);
        return iTestContext;
	}

	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String targetLocation=System.getProperty("user.dir")+"\\screenshots\\".replace('\\', '/');
		String dest = targetLocation.replace('\\', '/')+ getCurrentDateandTime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}
	
	private static String getCurrentDateandTime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}
	
	private static String getCurrentDateTimeForReport() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replaceAll("/", "_").replaceAll(" ", "_");
		} catch (Exception e) {
		}
		return str;
	}
	

}