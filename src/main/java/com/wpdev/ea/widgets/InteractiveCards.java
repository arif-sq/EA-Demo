package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.InteractiveCardsUtils;
import com.wpdev.ea.utils.InteractivePromoUtils;
import com.wpdev.ea.utils.config;

public class InteractiveCards {
	@Test
	public static void InteractiveCard() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/interactive-cards/");
		System.out.println("Now Testing Interactive Cards Page ");
		assertEquals(Driver.getTitle(), InteractiveCardsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.widget_title)).getText(),
				InteractiveCardsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.widget_desc)).getText(),
				InteractiveCardsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), PriceMenuUtils.Text.doc_page_title);
		System.out.println("Documentation Page Working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,900)", "");
		
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_header)).getText(), InteractiveCardsUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_desc)).getText(), InteractiveCardsUtils.Text.style_1_desc);
		
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_1_box)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_1)).getText(), InteractiveCardsUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_1_close)).click();
		
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_2_box)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_2)).getText(), InteractiveCardsUtils.Text.style_1_data_2);
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_1_data_2_close)).click();
		
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1750)", "");
		
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_header)).getText(), InteractiveCardsUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_desc)).getText(), InteractiveCardsUtils.Text.style_2_desc);
		
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_1_box)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_1)).getText(), InteractiveCardsUtils.Text.style_2_data_1);
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_1_close)).click();
		
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_2_box)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_2)).getText(), InteractiveCardsUtils.Text.style_2_data_2);
		Driver.findElement(By.xpath(InteractiveCardsUtils.Locator.style_2_data_2_close)).click();
	}
}
