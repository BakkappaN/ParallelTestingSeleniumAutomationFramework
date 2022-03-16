package com.testautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
      //  wait = new WebDriverWait(driver,20);
    }
    @FindBy(how=How.XPATH,using=".//*[@name='email']")
    private WebElement email_Textbox;
    
    @FindBy(how=How.XPATH,using=".//*[@name='pass']")
    private WebElement password_Textbox;
    
    @FindBy(how=How.XPATH,using=".//*[@value='Log In']")
    private WebElement login_Button;
    
    @FindBy(how=How.XPATH,using=".//*[text()='Forgotten account?']")
    private WebElement forgettenAccount_Link;
    
    @FindBy(how=How.XPATH,using=".//*[text()='Create New Account']")
    private WebElement CreatAccount_Text;
    
    public String getCreateAccountText() {
    	return CreatAccount_Text.getText().trim();    	
    }
    
    public boolean checkIfForgettenAccountLinkDisplayed() {
		return forgettenAccount_Link.isDisplayed();    	
    }
    
    public void loginToApp(String email,String password) {
    	email_Textbox.sendKeys(email);
    	password_Textbox.sendKeys(password);
    //	login_Button.click();
    }
    	
}
