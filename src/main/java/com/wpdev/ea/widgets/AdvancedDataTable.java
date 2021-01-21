package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.AdvancedDataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class AdvancedDataTable {
	@Test
	public static void AdvancedDataTable() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/advanced-data-table/");
		System.out.println("TESTING ADVANCED DATA TABLE");

		assertEquals(Driver.getTitle(), AdvancedDataTableUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.widget_title)).getText(),
				AdvancedDataTableUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.widget_desc)).getText(),
				AdvancedDataTableUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedDataTableUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor common = (JavascriptExecutor) Driver;
		common.executeScript("window.scrollTo(0,850)", "");
		Thread.sleep(1500);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.common_header)).getText(), AdvancedDataTableUtils.Text.common_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.common_desc)).getText(), AdvancedDataTableUtils.Text.common_desc);
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.common_header_icon_1)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.common_header_icon_2)).isDisplayed();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1500)", "");
		Thread.sleep(1500);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_header)).getText(), AdvancedDataTableUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_desc)).getText(), AdvancedDataTableUtils.Text.style_1_desc);
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_search)).click();
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_search)).sendKeys("Poulseur");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_data)).getText(), AdvancedDataTableUtils.Text.style_1_data);
		Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_1_search)).clear();
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2300)", "");
		Thread.sleep(1500);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_2_header)).getText(), AdvancedDataTableUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_2_desc)).getText(), AdvancedDataTableUtils.Text.style_2_desc);
		//Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_2_sorting)).click();
		assertEquals(Driver.findElement(By.xpath(AdvancedDataTableUtils.Locator.style_2_data)).getText(), AdvancedDataTableUtils.Text.style_2_data);
		
		System.out.println("ADVANCED DATA TABLE ALL OK");
		System.out.println("-------------------------");
		
		
	}

}
