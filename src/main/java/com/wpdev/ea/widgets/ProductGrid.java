package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedTabsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.ProductGridUtils;
import com.wpdev.ea.utils.config;

public class ProductGrid {
	@Test
	public static void ProductGrid() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/woo-product-grid/");
		System.out.println("TESTING PRODUCT GRID");

		assertEquals(Driver.getTitle(), ProductGridUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.widget_title)).getText(),
				ProductGridUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.widget_desc)).getText(),
				ProductGridUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ProductGridUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), ProductGridUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,950)");
		Thread.sleep(2000);

		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_header)).getText(), ProductGridUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_1_title)).getText(), ProductGridUtils.Text.style_1_data_1_title);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_1_price)).getText(), ProductGridUtils.Text.style_1_data_1_price);
		Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_1_image)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_2_title)).getText(), ProductGridUtils.Text.style_1_data_2_title);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_2_price)).getText(), ProductGridUtils.Text.style_1_data_2_price);
		Driver.findElement(By.xpath(ProductGridUtils.Locator.style_1_data_2_image)).isDisplayed();
		

		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,1600)");
		Thread.sleep(2000);

		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_1_title)).getText(), ProductGridUtils.Text.style_2_data_1_title);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_1_price)).getText(), ProductGridUtils.Text.style_2_data_1_price);
		Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_1_image)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_2_title)).getText(), ProductGridUtils.Text.style_2_data_2_title);
		assertEquals(Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_2_price)).getText(), ProductGridUtils.Text.style_2_data_2_price);
		Driver.findElement(By.xpath(ProductGridUtils.Locator.style_2_data_2_image)).isDisplayed();
		
		System.out.println("PRODUCT GRID ALL OK");
		System.out.println("----------------------");
	
	}
}
