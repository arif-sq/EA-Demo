package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.ProtectedContentUtils;
import com.wpdev.ea.utils.config;

public class ProtectedContent {
	@Test
	public static void ProtectedContent() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/protected-content/");
		System.out.println("PROTECTED CONTENT");
		assertEquals(Driver.getTitle(), ProtectedContentUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.widget_title)).getText(),
				ProtectedContentUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.widget_desc)).getText(),
				ProtectedContentUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ProtectedContentUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), ProtectedContentUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_header)).getText(), ProtectedContentUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_desc)).getText(), ProtectedContentUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_data_1_header)).getText(), ProtectedContentUtils.Text.style_1_data_1_header);
		Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_password)).sendKeys("1234");
		Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_submit)).click();
		Thread.sleep(3000);
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,990)", "");
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_data_2)).getText(), ProtectedContentUtils.Text.style_1_data_2);
		System.out.println ("Style 1 Working");
		
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_2_header)).getText(), ProtectedContentUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_2_desc)).getText(), ProtectedContentUtils.Text.style_2_desc);
		
		Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_2_password)).sendKeys("4321");
		Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_2_submit)).click();
		Thread.sleep(3000);
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2450)", "");
		assertEquals(Driver.findElement(By.xpath(ProtectedContentUtils.Locator.style_1_data_2)).getText(), ProtectedContentUtils.Text.style_1_data_2);
		System.out.println ("Style 2 Working");
		
		System.out.println("PROTECTED CONTENT ALL OK");
		System.out.println("----------------------");
		
	}

}
