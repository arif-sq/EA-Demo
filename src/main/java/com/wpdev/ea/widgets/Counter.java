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
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/counter/");
		System.out.println("TESTING COUNTER");
		assertEquals(Driver.getTitle(), CounterUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.widget_title)).getText(),
				CounterUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.widget_desc)).getText(),
				CounterUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(CounterUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.doc_page_title)).getText(),
				CounterUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		// Driver.findElement(By.className("nx-close")).click();
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,928)");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_1_data_1)).getText(),
				CounterUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(CounterUtils.Locator.style_1_icon)).isDisplayed();

		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		 Style_2.executeScript("window.scrollTo(0,1450)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_2_data_1)).getText(), CounterUtils.Text.style_2_data_1);
		 Driver.findElement(By.xpath(CounterUtils.Locator.style_2_icon)).isDisplayed();
		 
		 JavascriptExecutor Style_3 = (JavascriptExecutor) Driver;
		 Style_3.executeScript("window.scrollTo(0,1700)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_3_data_1)).getText(), CounterUtils.Text.style_3_data_1);
		  Driver.findElement(By.xpath(CounterUtils.Locator.style_3_icon)).isDisplayed();
		  
		 // JavascriptExecutor Style_4 = (JavascriptExecutor) Driver;
		 // Style_4.executeScript("window.scrollTo(0,2022)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_4_data_1)).getText(), CounterUtils.Text.style_4_data_1);
		 
		// JavascriptExecutor Style_5 = (JavascriptExecutor) Driver;
		// Style_5.executeScript("window.scrollTo(0,2480)"); Thread.sleep(2000);
		 assertEquals(Driver.findElement(By.xpath(CounterUtils.Locator.style_5_data_1)).getText(), CounterUtils.Text.style_5_data_1);
		 Driver.findElement(By.xpath(CounterUtils.Locator.style_5_icon)).isDisplayed();
		 }
}
