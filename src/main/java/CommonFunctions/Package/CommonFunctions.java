package CommonFunctions.Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.openqa.selenium.OutputType;
import com.sun.javafx.PlatformUtil;


public class CommonFunctions {

	public WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void screenCapture() throws IOException{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File (".\\Screenshots\\" + driver.getTitle() + ".png");
		FileUtils.copyFile(scrFile,screenshotName);
		Reporter.log("<br><img src='" + screenshotName + "'height='400' width='400'/><br>");
	}
	
	
	public void CommonFunctions1() {
		setDriverPath();
		
		//Disabling notifications in chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--disable-notifications");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
    
    
    
	
    public void setDriverPath() {
    	// Identifying the OS in which scripts are executed to assign suitable driver
        if (PlatformUtil.isMac()) {
        	System.out.println("Mac");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
        	System.out.println("Linux");
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	
    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
}
