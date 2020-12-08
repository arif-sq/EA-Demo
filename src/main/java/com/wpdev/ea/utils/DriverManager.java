package com.wpdev.ea.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	static {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("headless");
		
	}
	public static WebDriver Driver= new ChromeDriver();
	
	


}
