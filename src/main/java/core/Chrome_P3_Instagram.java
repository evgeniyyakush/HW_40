package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Chrome_P3_Instagram {
	 
																											//Prerequisites
	static WebDriver driver;
//		 variable to externalize variables
		static Properties p = new Properties();

	public static void main(String[] cla) throws InterruptedException, FileNotFoundException, IOException {
		
																											    	//Head
//      Get rid of Warnings
		Logger.getLogger("").setLevel(Level.OFF);	
		System.setProperty("webdriver.chrome.silentOutput", "true"); 
		
//		To disable Notifications
//		ChromeOptions option = new ChromeOptions();                         
//		option.addArguments("disable-infobars");                                     
//		option.addArguments("--disable-notifications");    
//		
//		Externalization of variables
		p.load(new FileInputStream("input_Instagram.properties"));
		
		// If we use "ChromeOptions"
//		driver = new ChromeDriver(option);
		
//		Driver	
		driver = new ChromeDriver();		

//		Getting Browser and OS Version
		Capabilities caps = (((RemoteWebDriver) driver).getCapabilities());
		System.out.println("OS: " + System.getProperty("os.name"));
		System.out.println("Browser: " + caps.getBrowserName().substring(0, 1).toUpperCase() + caps.getBrowserName().substring(1).toLowerCase()  + " " + caps.getVersion());
			
//		Explicit Wait Time
		WebDriverWait wait = new WebDriverWait(driver, 15);
		final long start = System.currentTimeMillis();
		
																									             	//Process

// 		Website
		driver.get(p.getProperty("url"));
		
//		Set the Window size
		driver.manage().window().setSize(new Dimension(Integer.parseInt(p.getProperty("x")), Integer.parseInt(p.getProperty("y"))));  
		
//		Check the Window size 
		System.out.println("Window size: " + driver.manage().window().getSize());
		
//		Title of the page	
		System.out.println("");
		System.out.println("Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(p.getProperty("username_name")))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(p.getProperty("username_name")))).sendKeys("evgeniy.yakush@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(p.getProperty("password_name")))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(p.getProperty("password_name")))).sendKeys(System.getenv("insta_password"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("log_in_xpath")))).click();
		
		//Notification
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("pop_up_window_xpath")))).click();
		
		//My cabinet
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("my_cabinet_xpath")))).click();
		//OwnerName
		String OwnerName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("owner_name_xpath")))).getText();
		//OwnerSatus
		String OwnerSatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("owner_status_xpath")))).getText();
		//Num of posts
		String posts = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("post_number_xpath")))).getText();
		//Num of followers
		String followers = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("post_followers_xpath")))).getText();
		//Num following
		String following = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("post_following_xpath")))).getText();
		
		//Go to Timeline
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(p.getProperty("timeline_cssSelector")))).click();
		//Click first story
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("first_story_xpath")))).click();
		Thread.sleep(3000);
		
		//Click next, next, next, next
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("next_story_xpath")))).click();
		Thread.sleep(1000);
		

		final long finish = System.currentTimeMillis();
		
		driver.quit();
	
																		                                            //After Process
		System.out.println("Owner Name: " + OwnerName);
		System.out.println("OwnerSatus: " + OwnerSatus);
		System.out.println("You have " + posts + " posts");
		System.out.println("You have " + followers + " followers");
		System.out.println("You follow " + following + " people");
		System.out.println("");
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");

	}
}