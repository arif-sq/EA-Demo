package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.config;
import com.wpdev.ea.utils.FlipBoxUtils.Locator;
import com.wpdev.ea.utils.StaticProductUtils;

public class StaticProduct {
	@Test
	public static void StaticProduct() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/static-product/");
		System.out.println("TESTING STATIC PRODUCT");

		assertEquals(Driver.getTitle(), StaticProductUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.widget_title)).getText(),
				StaticProductUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.widget_desc)).getText(),
				StaticProductUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(StaticProductUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), StaticProductUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		//STYLE 1
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1038)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_header)).getText(),StaticProductUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_desc)).getText(),StaticProductUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_1_title)).getText(),StaticProductUtils.Text.style_1_data_1_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_1_price)).getText(),StaticProductUtils.Text.style_1_data_1_price);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_2_title)).getText(),StaticProductUtils.Text.style_1_data_2_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_2_price)).getText(),StaticProductUtils.Text.style_1_data_2_price);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_3_title)).getText(),StaticProductUtils.Text.style_1_data_3_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_1_data_3_price)).getText(),StaticProductUtils.Text.style_1_data_3_price);
	
		//STYLE 2
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1880)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_header)).getText(),StaticProductUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_desc)).getText(),StaticProductUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_1_title)).getText(),StaticProductUtils.Text.style_2_data_1_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_1_price)).getText(),StaticProductUtils.Text.style_2_data_1_price);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_2_title)).getText(),StaticProductUtils.Text.style_2_data_2_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_2_price)).getText(),StaticProductUtils.Text.style_2_data_2_price);	
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_3_title)).getText(),StaticProductUtils.Text.style_2_data_3_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_2_data_3_price)).getText(),StaticProductUtils.Text.style_2_data_3_price);
		
		//STYLE 3
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,2660)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_header)).getText(),StaticProductUtils.Text.style_3_header);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_desc)).getText(),StaticProductUtils.Text.style_3_desc);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_data_1_title)).getText(),StaticProductUtils.Text.style_3_data_1_title);
		//assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_data_1_desc)).getText(),StaticProductUtils.Text.style_3_data_1_desc);	
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_data_2_title)).getText(),StaticProductUtils.Text.style_3_data_2_title);
		assertEquals(Driver.findElement(By.xpath(StaticProductUtils.Locator.style_3_data_2_desc)).getText(),StaticProductUtils.Text.style_3_data_2_desc);
	
		System.out.println("STATIC PRODUCT ALL OK");
		System.out.println("---------------------");
		
	}

}
