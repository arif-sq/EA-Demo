package com.wpdev.ea.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	static {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\chromedriver\\chromedriver.exe");

		
	}
	public static WebDriver Driver= new ChromeDriver();
	


}
