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
import com.wpdev.ea.utils.PricingTableUtils;
import com.wpdev.ea.utils.config;

public class PricingTable {
	@Test
	public static void PricingTable() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/pricing-table/");
		System.out.println("TESTING PRICING TABLE");
		
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.widget_title)).getText(),
				PricingTableUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.widget_desc)).getText(),
				PricingTableUtils.Text.widget_desc);
		Thread.sleep(1000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(PricingTableUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), DataTableUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
	
		if (Driver.findElement(By.xpath(config.crisp_close)).isDisplayed())
		{
		Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_1_header)).getText(), PricingTableUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_1_desc)).getText(), PricingTableUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_1_data_1)).getText(), PricingTableUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_1_data_2)).getText(), PricingTableUtils.Text.style_1_data_2);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_1_data_3)).getText(), PricingTableUtils.Text.style_1_data_3);
	
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,3000)");
		Thread.sleep(2000);
		

		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_2_header)).getText(), PricingTableUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_2_desc)).getText(), PricingTableUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_2_data_1)).getText(), PricingTableUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_2_data_2)).getText(), PricingTableUtils.Text.style_2_data_2);
		assertEquals(Driver.findElement(By.xpath(PricingTableUtils.Locator.style_2_data_3)).getText(), PricingTableUtils.Text.style_2_data_3);
		Thread.sleep(2000);
		System.out.println("PRICE TABLE ALL OK");
		System.out.println("----------------------");
	}
}
