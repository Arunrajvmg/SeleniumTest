package TestcasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import CommonFunctions.Package.CommonFunctions;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.StringEncoderComparator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class aliexpress extends CommonFunctions {
 
    @FindBy(className = "close-layer")
    private WebElement ClosePopup;
    @FindBy(xpath = "//div[@class='user-account']//a[contains(text(),'Sign in')]")
    private WebElement SignIn;    
    @FindBy(xpath = "//div[@class='user-account']//a[contains(text(),'Join')]")
    private WebElement Join;    
    @FindBy(id = "ws-xman-register-email")
    private WebElement EmailAddress;
    @FindBy(id = "ws-xman-register-password")
    private WebElement Password;
    @FindBy(id="ws-xman-register-submit")
    private WebElement Register;
    @FindBy(xpath="//div[contains(text(),'This email already exists.')]")
    private WebElement DuplicateMailID;
    @FindBy(id="fm-login-id")
    private WebElement Login_Username;
    @FindBy(id="fm-login-password")
    private WebElement Login_Password;
    @FindBy(className="fm-button fm-submit password-login")
    private WebElement Submit;
    @FindBy(xpath="//div[contains(text(),'Your account name or password is incorrect.')]")
    private WebElement LoginError;
    @FindBy(id="search-key")
    private WebElement SearchText;
    @FindBy (className="search-button")
    private WebElement SearchBtn;
    

    
//	new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
//searchButton.click();*/
//Assert.assertTrue(isElementPresent(driver,By.linkText("Check availability")));    
    
    
    @BeforeMethod
    public void beforeTest() {
    	CommonFunctions1();
    }

    
    @Test(enabled=true)
    public void UserLogin() throws IOException {
    	try {
    		System.out.println("UserLogin");
 	        driver.get("https://www.aliexpress.com/");
	        PageFactory.initElements(driver, this);
	        Assert.assertTrue(0==driver.getTitle().compareTo("AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More."));
	        screenCapture();
	        if (isElementPresent(driver, By.className("close-layer")) == true) {
	        	ClosePopup.click();        }
	        screenCapture();
	        SignIn.click();
	        screenCapture();
	        driver.switchTo().frame("alibaba-login-box");
            Login_Username.sendKeys("arunrajvmg@gmail.com");
            Login_Password.sendKeys("123456789");
            Login_Password.sendKeys(Keys.ENTER);
	        screenCapture();
            //Submit.click();
        	Assert.assertTrue(isElementPresent(driver, By.xpath("//div[contains(text(),'Your account name or password is incorrect.')]")));
        	driver.quit(); 	        }
    	catch (Exception e) {
	        screenCapture(); 
    		Assert.assertTrue(false);
			 driver.close();}}
    
    @Test(enabled=true)
    public void UserRegisteration() throws IOException {
    	try {
    		System.out.println("UserRegisteration");
 	        driver.get("https://www.aliexpress.com/");
	        PageFactory.initElements(driver, this);
	        Assert.assertTrue(0==driver.getTitle().compareTo("AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More."));
	        screenCapture();
	        if (isElementPresent(driver, By.className("close-layer")) == true) {
		        screenCapture();
	        	ClosePopup.click();        }
	        	screenCapture();
	        	Join.click();
		        screenCapture();
	        	EmailAddress.sendKeys("abc@xyz.com");
	        	Password.sendKeys("123abc@");
	        	Register.click();
		        screenCapture();
	        	Assert.assertTrue(isElementPresent(driver, By.xpath("//div[contains(text(),'This email already exists.')]")));
	        	Assert.assertTrue(isElementPresent(driver, By.xpath("//div[contains(text(),'Please enter 6 - 20 characters (A-Z, a-z, 0-9 only)')]")));
		        driver.quit(); 	        }
	    	catch (Exception e) {
		        screenCapture();
				 Assert.assertTrue(false);
				 driver.close();}}
    
    
    
    @Test(enabled=true)
    public void SearchItems() throws IOException {
    	try {
    		System.out.println("SearchItems");
    		
 	        driver.get("https://www.aliexpress.com/");
	        PageFactory.initElements(driver, this);
	        screenCapture();
	        Assert.assertTrue(0==driver.getTitle().compareTo("AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More."));
	        if (isElementPresent(driver, By.className("close-layer")) == true) {
		        screenCapture();
	        	ClosePopup.click();        }
	        screenCapture();
	        SearchText.clear();
		    SearchText.sendKeys("Shoes");
	        screenCapture();
		    SearchBtn.click();
	        screenCapture();
		    SearchText.sendKeys(Keys.ENTER);
	        if (isElementPresent(driver, By.className("close-layer")) == true) {
		        screenCapture();
	       	ClosePopup.click();        }
	               
	        List<WebElement> listOfElements = driver.findElements(By.xpath("//li[@class='list-item']"));
	        screenCapture();
		    
		    //System.out.println(listOfElements.size());
		    
			Assert.assertTrue(8==listOfElements.size());
	        screenCapture();
		    driver.quit(); 	        }
catch (Exception e) {
    screenCapture();
	 Assert.assertTrue(false);
	 driver.close();}}
    
    
    
}