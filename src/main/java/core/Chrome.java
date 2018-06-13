package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";
		
		// This web-site allows to check User Engine of particular browser
		String url = "http://alex.academy/ua";
		
		// We are checking, which system we are using for test execution
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/chromedriver";

        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) // If we have WebDrivers for PC
            driverPath = "./resources/webdrivers/pc/chromedriver.exe";

        else 
	        throw new IllegalArgumentException("Unknown OS. Script should be executed on Mac");
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Disable debugging logs
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		
		// Disable infobars and notifications
		//option.addArguments("disable-infobars")	;
		//option.addArguments("--disable-notifications");
		
		// Maximaze browser window
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			option.addArguments("-start-fullscreen");
		
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) // If we have WebDrivers for PC
		    option.addArguments("--start-maximized"); 
		
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(url);
		
		String ua = driver.findElement(By.id("id_ua")).getText();
		System.out.println(ua);
		
		String ua2 = driver.findElement(By.id("id_js")).getText();
		System.out.println(ua2);
		
		Thread.sleep(3000); // Pause 3 second
		
		driver.quit();
	}
	

} 

