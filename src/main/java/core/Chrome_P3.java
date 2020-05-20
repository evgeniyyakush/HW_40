package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Chrome_P3 {
	static WebDriver driver;
	// variable to externalize variables
		static Properties p = new Properties();

	public static void main(String[] cla) throws InterruptedException, FileNotFoundException, IOException {
//      Get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);	
		System.setProperty("webdriver.chrome.silentOutput", "true"); 
		
		
		
//		Externalizing variables into properties file
//		If it's without path it means we will put it into the root directory of this project
		p.load(new FileInputStream("input.properties"));
		
//		Driver	
		driver = new ChromeDriver();		

//		Getting Browser and OS Version
		Capabilities caps = (((RemoteWebDriver) driver).getCapabilities());
		System.out.println("OS: " + System.getProperty("os.name"));
		System.out.println("Browser: " + caps.getBrowserName().substring(0, 1).toUpperCase() + caps.getBrowserName().substring(1).toLowerCase()  + " " + caps.getVersion());
			
//		Explicit Wait Time
		WebDriverWait wait = new WebDriverWait(driver, 15);
		final long start = System.currentTimeMillis();

// 		Website
		driver.get(p.getProperty("url"));
		
//		Set the Window size
		driver.manage().window().setSize(new Dimension(Integer.parseInt(p.getProperty("x")), Integer.parseInt(p.getProperty("y"))));  
//		Simple version of using credential wi	thout externaling them	
//		driver.manage().window().setSize(new Dimension(1920, 1080));
		
//		Check the Window size 
		System.out.println("Window size: " + driver.manage().window().getSize());
		
//		Title of the page	
		System.out.println("Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_email")))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_email")))).sendKeys("evgeniy.yakush@gmail.com");
//		Does not work when externilizing 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_password")))).clear();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_password")))).sendKeys(System.getenv("fb_password"));
//		work without externalizing
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_login")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_timeline")))).click();
		
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_num_Of_Friends")))).getText();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_settings")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_logout")))).click();
		
		final long finish = System.currentTimeMillis();
		
		driver.quit();
	
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}

