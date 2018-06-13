package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

public class Safari {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		// Disable the logs
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";
		
		String url = "http://alex.academy/ua";
		
		// We are checking, if system is Mac
		if (!System.getProperty("os.name").toUpperCase().contains("MAC"))
			throw new IllegalArgumentException("Safari is available only on Mac");

		driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
		
		String ua = driver.findElement(By.id("id_ua")).getText();
		System.out.println(ua);
		
		String ua2 = driver.findElement(By.id("id_js")).getText();
		System.out.println(ua2);
		
		Thread.sleep(3000); // Pause 3 second
		
		driver.quit();
	}
	

} 

