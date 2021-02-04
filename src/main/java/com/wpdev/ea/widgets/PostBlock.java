package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.PostBlockUtils;
import com.wpdev.ea.utils.config;

public class PostBlock {
	@Test
	public static void PostBlock() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/post-block/");
		System.out.println("TESTING POST BLOCK");

		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.widget_title)).getText(),
				PostBlockUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.widget_desc)).getText(),
				PostBlockUtils.Text.widget_desc);
		Thread.sleep(2000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(PostBlockUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), PostBlockUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}

		if (Driver.findElement(By.xpath(config.crisp_close)).isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1150)", "");
		String style_1_data_1_text = Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_1)).getText();	
		Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_1)).click();
		String style_1_data_1_page = Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_1_page)).getText();
		assertEquals(style_1_data_1_text, style_1_data_1_page);
		Driver.navigate().back();
		
		String style_1_data_2_text = Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_2)).getText();	
		Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_2)).click();
		String style_1_data_2_page = Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_2_page)).getText();
		assertEquals(style_1_data_2_text, style_1_data_2_page);
		Driver.navigate().back();
		
		System.out.println("POST BLOCK ALL OK");
		System.out.println("----------------------");
	}
}
