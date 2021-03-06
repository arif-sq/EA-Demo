package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.wpdev.ea.utils.AdvanvedMenuUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class AdvancedMenu {
	@Test
	public static void AdvancedMenu() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/advanced-menu/");
		System.out.println("TESTING ADVANCED MENU");

		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.widget_title)).getText(),
				AdvanvedMenuUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.widget_desc)).getText(),
				AdvanvedMenuUtils.Text.widget_desc);
		Thread.sleep(1000);

		if (config.doc_check == "YES") {
			Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.doc_link)).click();
			ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
			Driver.switchTo().window(tabs2.get(1));
			// assertEquals(Driver.getTitle(), AdvanvedMenuUtils.Text.doc_page_title);
			System.out.println("DOC PAGE WORKING");
			Driver.close();
			Driver.switchTo().window(tabs2.get(0));
		}

		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1350)", "");
		Thread.sleep(2000);
		if (Driver.findElement(By.xpath(config.crisp_close))
				.isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}

		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_1_header)).getText(),
				AdvanvedMenuUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_1_desc)).getText(),
				AdvanvedMenuUtils.Text.style_1_desc);
		Actions mousehover = new Actions(Driver);
		WebElement style_1_menu = Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_1_menu));
		mousehover.moveToElement(style_1_menu).build().perform();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_1_submenu)).getText(),
				AdvanvedMenuUtils.Text.style_1_submenu);

		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1900)", "");
		Thread.sleep(2000);
		if (Driver.findElement(By.xpath(config.crisp_close))
				.isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}

		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_2_header)).getText(),
				AdvanvedMenuUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_2_desc)).getText(),
				AdvanvedMenuUtils.Text.style_2_desc);

		WebElement style_2_menu = Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_2_menu));
		mousehover.moveToElement(style_2_menu).build().perform();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvanvedMenuUtils.Locator.style_2_submenu)).getText(),
				AdvanvedMenuUtils.Text.style_2_submenu);

		System.out.println("ADVANCED MENU ALL OK");
		System.out.println("--------------------");

	}
}
