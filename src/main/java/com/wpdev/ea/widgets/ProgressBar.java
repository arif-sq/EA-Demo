package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CreativeButtonsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.ProgressBarUtils;
import com.wpdev.ea.utils.config;

public class ProgressBar {
	@Test
	public static void ProgressBar() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/progress-bar/");
		
		System.out.println("TESTING PROGRESS BAR");


		assertEquals(Driver.getTitle(), ProgressBarUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.widget_title)).getText(),
				ProgressBarUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.widget_desc)).getText(),
				ProgressBarUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ProgressBarUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), ProgressBarUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,900)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_1_header)).getText(), ProgressBarUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_1_desc)).getText(), ProgressBarUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_1_data_1)).getText(), ProgressBarUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_1_data_2)).getText(), ProgressBarUtils.Text.style_1_data_2);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1600)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_2_header)).getText(), ProgressBarUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_2_desc)).getText(), ProgressBarUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_2_data_1)).getText(), ProgressBarUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_2_data_2)).getText(), ProgressBarUtils.Text.style_2_data_2);
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,4000)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_3_header)).getText(), ProgressBarUtils.Text.style_3_header);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_3_desc)).getText(), ProgressBarUtils.Text.style_3_desc);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_3_data_1)).getText(), ProgressBarUtils.Text.style_3_data_1);
		assertEquals(Driver.findElement(By.xpath(ProgressBarUtils.Locator.style_3_data_2)).getText(), ProgressBarUtils.Text.style_3_data_2);
	
		System.out.println("PROGRESS BAR ALL OK");
		System.out.println("----------------------");
	}
}
