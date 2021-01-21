package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.BtrDocsCatBoxUtils;
import com.wpdev.ea.utils.BtrDocsCatGridUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class BrtDocsCatBox {
	@Test
	public static void BrtDocsCatBox() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/betterdocs-category-box/");
		System.out.println("TESTING BETTERDOCS CATEGORY BOX");
		assertEquals(Driver.getTitle(), BtrDocsCatBoxUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.widget_title)).getText(),
				BtrDocsCatBoxUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.widget_desc)).getText(),
				BtrDocsCatBoxUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.doc_page_title)).getText(), BtrDocsCatBoxUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1150)", "");
		String style_1_data_1 = Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_1)).getText();
		System.out.println(style_1_data_1);
		Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_1)).click();
		assertEquals(style_1_data_1, Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_1_page)).getText());
		Driver.navigate().back();
		
		String style_1_data_2 = Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_2)).getText();
		Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_2)).click();
		assertEquals(style_1_data_2, Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_2_page)).getText());
		Driver.navigate().back();
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1830)", "");
		String style_2_data_1 = Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_2_data_1)).getText();
		Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_2_data_1)).click();
		assertEquals(style_2_data_1, Driver.findElement(By.xpath(BtrDocsCatBoxUtils.Locator.style_1_data_1_page)).getText());
		Driver.navigate().back();

	}
}
