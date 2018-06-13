package core;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Edge {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		String driverPath = "";
		String url = "http://alex.academy/ua";

		if (!System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			throw new IllegalArgumentException("MS Edge is available only on Windows");

		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(url);
		String ua = driver.findElement(By.id("id_ua")).getText();
		System.out.println("User Agent: " + ua);
		Thread.sleep(1000); // Pause in milleseconds (1000 – 1 sec)
		driver.quit();
	}
}