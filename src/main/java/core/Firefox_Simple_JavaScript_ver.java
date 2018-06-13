package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_Simple_JavaScript_ver {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		String driverPath = "";
		
		String url = "http://alex.academy/ua";
		
		driverPath = "./resources/webdrivers/mac/geckodriver";
		
		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();
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

