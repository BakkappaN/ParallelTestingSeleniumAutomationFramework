package com.testautomation.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author TheTechie AutomationLabs
 *
 */
public class PageUtility {
	
	//fluent wait
	//explicit wait default pooling time is 500 ms
	//dropdowns
	//frame
	//alert
	
	/**
	 * @author TheTechie AutomationLabs
	 *
	 * @param element accepts webpage element
	 * @param driver accepts any browser driver object
	 */
	public static void waitForWebElementToBeVisible(WebElement element, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(3)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 *
	 * @param element accepts webpage element
	 * @param driver accepts any browser driver object
	 */
	public static void waitForWebElementToBeClickable(WebElement element, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(3)).ignoring(NoSuchElementException.class)
				.ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
				.ignoring(ElementNotInteractableException.class).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 *
	 * @param element accepts webpage element
	 * @param driver accepts any browser driver object
	 */
	public static void explicitWaitElementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * @param element accepts webpage element
	 * @param driver accepts any browser driver object
	 */
	public static void explicitWaitElementToBeVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param element of webpage
	 * @param index to be selected from dropdown
	 */
	public static void selectDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param element of webpage
	 * @param value to be selected from dropdown
	 */
	public static void selectDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param element of webpage
	 * @param str to be selected from dropdown
	 */
	public static void selectDropdownByVisibleText(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByVisibleText(str);
	}

	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param element of webpage
	 * @return list of values from dropdown list
	 */
	public static List<String> selectDropdownValues(WebElement element) {
		Select select = new Select(element);
		List<String> dropDownValues = new ArrayList<String>();
		List<WebElement> dropDownElements = select.getOptions();
		for (WebElement webElement : dropDownElements) {
			dropDownValues.add(webElement.getText());
		}
		return dropDownValues;
	}

	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param element of webpage
	 * @return
	 */
	public static String getFirstSelectedValueFromDropDown(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param frameIdOrName of frame to be switched
	 * @param driver accepts any browser driver object
	 */
	public static void switchToFrameByIdorName(String frameIdOrName,WebDriver driver) {
		driver.switchTo().frame(frameIdOrName);
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 *
	 * @param element accepts webpage element
	 * @param driver accepts any browser driver object
	 */
	public static void switchToFrameByWebElement(WebElement element,WebDriver driver) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param driver accepts any browser driver object
	 */
	public static void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param driver accepts any browser driver object
	 */
	public static void switchToAlertAndAccept(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param driver accepts any browser driver object
	 */
	public static void switchToAlertAndDismiss(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	/**
	 * @author TheTechie AutomationLabs
	 * 
	 * @param driver accepts any browser driver object
	 * @return string text from popup
	 */
	public static String switchToAlertAndGetText(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	

}
