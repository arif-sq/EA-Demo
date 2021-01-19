package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.EventCalenderUtils;
import com.wpdev.ea.utils.config;

public class EventCalender {
	@Test
	public static void EventCalender() throws InterruptedException {
		
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		
		Driver.get(config.base_url + "/event-calendar/");
		System.out.println("TESTING EVENT CALENDER");

		assertEquals(Driver.getTitle(), EventCalenderUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.widget_title)).getText(),
				EventCalenderUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.widget_desc)).getText(),
				EventCalenderUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(EventCalenderUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1650)", "");
		
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_data_1)).getText(),EventCalenderUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_data_2)).getText(),EventCalenderUtils.Text.style_1_data_2);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_data_3)).getText(),EventCalenderUtils.Text.style_1_data_3);
		Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_day)).click();
		Thread.sleep(1000);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_time)).getText(),EventCalenderUtils.Text.style_1_time);
		Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_1_month)).click();
		Thread.sleep(1000);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2900)", "");
		
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_data_1)).getText(),EventCalenderUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_data_2)).getText(),EventCalenderUtils.Text.style_2_data_2);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_data_3)).getText(),EventCalenderUtils.Text.style_2_data_3);
		Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_day)).click();
		Thread.sleep(1000);
		assertEquals(Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_time)).getText(),EventCalenderUtils.Text.style_2_time);
		Driver.findElement(By.xpath(EventCalenderUtils.Locator.style_2_month)).click();
	}
}
