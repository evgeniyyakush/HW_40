package core;

import java.util.logging.*;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlUnit {
	public static void main(String[] cla) throws Exception {
//		Get rid of Warnings
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
//		Web page
		String url = "http://alex.academy/exe/signup/www";
		
//		Called Client not Driver
//		In this case we'll have Windows 7, Chrome 81
//		WebClient driver = new WebClient();
//		To have a different Browser then Chrome 81
		WebClient driver = new WebClient(BrowserVersion.BEST_SUPPORTED);
		
//		Benchmark start
		final long start = System.currentTimeMillis();
		
		HtmlPage page = driver.getPage(url);
		System.out.println("Page URI: " + page.getUrl());
		System.out.println("Page Title: " + page.getTitleText());
		
		HtmlElement os_browser = page.getHtmlElementById("os_browser");
		System.out.println("OS & Browser: " + os_browser.asText());
		
//		Benchmark finish	
		final long finish = System.currentTimeMillis();
		
		driver.close();
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}