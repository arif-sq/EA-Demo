package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.BtrDocsCatGridUtils;
import com.wpdev.ea.utils.CallToActionUtils;
import com.wpdev.ea.utils.ContactForm7Utils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class BtrDocsCatGrid {
	@Test
	public static void BtrDocsCatGrid() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/betterdocs-category-grid/");
		System.out.println("TESTING BETTERDOCS CATEGORY GRID");
		assertEquals(Driver.getTitle(), BtrDocsCatGridUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.widget_title)).getText(),
				BtrDocsCatGridUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.widget_desc)).getText(),
				BtrDocsCatGridUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.doc_page_title)).getText(), BtrDocsCatGridUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1055)", "");
		
		String style_1_data_1 = Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_1)).getText().toUpperCase();
		System.out.println(style_1_data_1);
		Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_1)).click();
		assertEquals(style_1_data_1, Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_1_page)).getText());
		Driver.navigate().back();
		
		String style_1_data_2 = Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_2)).getText().toUpperCase();
		Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_2)).click();
		assertEquals(style_1_data_2, Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_2_page)).getText());
		Driver.navigate().back();
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2220)", "");
		String style_2_data_1 = Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_2_data_1)).getText().toUpperCase();
		Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_2_data_1)).click();
		assertEquals(style_2_data_1, Driver.findElement(By.xpath(BtrDocsCatGridUtils.Locator.style_1_data_1_page)).getText());
		Driver.navigate().back();
		
		

	}
}
