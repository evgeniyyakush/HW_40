package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari_P3 {
	static WebDriver driver;
	// variable to externalize variables
		static Properties p = new Properties();

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
//		Get rid of Warnings
	    Logger.getLogger("").setLevel(Level.OFF); 
	    
//		Externalizing variables into properties file
//		If it's without path it means we will put it into the root directory of this project
		p.load(new FileInputStream("input_Safari.properties"));
	    
// 		Safari -  Mac OS Support Only
		if (!System.getProperty("os.name").contains("Mac OS X")) {
			throw new IllegalArgumentException("Safari is available only on Mac");
		}
	    
//   	Driver
		driver = new SafariDriver();
		
//		Getting Browser and OS Version
		Capabilities caps = (((RemoteWebDriver) driver).getCapabilities());
		System.out.println("OS: " + System.getProperty("os.name"));
		System.out.println("Browser: " + caps.getBrowserName().substring(0, 1).toUpperCase() + caps.getBrowserName().substring(1).toLowerCase()  + " " + caps.getVersion());
	
//		Explicit Wait Time
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
//      Benchmark start	
		final long start = System.currentTimeMillis();

// 		Website
		driver.get(p.getProperty("url"));
		
//		Set the Window size and putting Dimensions into external file with making variables integers
//		driver.manage().window().setSize(new Dimension(1920, 1080));  
		driver.manage().window().setSize(new Dimension(Integer.parseInt(p.getProperty("x")), Integer.parseInt(p.getProperty("y"))));  
		
//		Check the Window size 
		System.out.println("Window size: " + driver.manage().window().getSize()); 
		
		System.out.println("Title: " + driver.getTitle());

//		Workflow
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_email")))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_email")))).sendKeys("evgeniy.yakush@gmail.com");
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_password")))).clear();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_password")))).sendKeys(System.getenv("fb_password"));
//		it did not work with properties file somehow	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(System.getenv("fb_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_login")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_timeline")))).click();
		
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_num_Of_Friends")))).getText();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_NavigationLabel")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(p.getProperty("linkText_logout")))).click();
		
//		Benchmark finish
		final long finish = System.currentTimeMillis();
		
		driver.quit();
	
		System.out.println("You have " + friends + " friends");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}