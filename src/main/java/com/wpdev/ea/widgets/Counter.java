package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.ContactForm7Utils;
import com.wpdev.ea.utils.CounterUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class Counter {
	@Test
	public static void Counter() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/counter/");
		System.out.println("TESTING COUNTER");
	
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.widget_title)).getText(),
				CounterUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.widget_desc)).getText(),
				CounterUtils.Text.widget_desc);
		Thread.sleep(1000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(CounterUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.doc_page_title)).getText(),
				CounterUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,928)");
		Thread.sleep(2000);
		if (Driver.findElement(By.xpath(config.crisp_close)).isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_1_data_1)).getText(),
				CounterUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(CounterUtils.Locator.style_1_icon)).isDisplayed();

		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		 Style_2.executeScript("window.scrollTo(0,1450)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_2_data_1)).getText(), CounterUtils.Text.style_2_data_1);
		 Driver.findElement(By.xpath(CounterUtils.Locator.style_2_icon)).isDisplayed();
		 
		 JavascriptExecutor Style_3 = (JavascriptExecutor) Driver;
		 Style_3.executeScript("window.scrollTo(0,1900)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_3_data_1)).getText(), CounterUtils.Text.style_3_data_1);
		  Driver.findElement(By.xpath(CounterUtils.Locator.style_3_icon)).isDisplayed();
	
		 }
}
