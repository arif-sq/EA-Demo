package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.DualColorHeadingUtils;
import com.wpdev.ea.utils.PostGridUtils;
import com.wpdev.ea.utils.SmartPostListUtils;
import com.wpdev.ea.utils.config;

public class PostGrid {
	@Test
	public static void PostGrid() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/post-grid/");
		System.out.println("TESTING POST GRID");

		assertEquals(Driver.getTitle(), PostGridUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.widget_title)).getText(),
				PostGridUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.widget_desc)).getText(),
				PostGridUtils.Text.widget_desc);
		Thread.sleep(2000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(PostGridUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), PostGridUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1350)", "");
		String style_1_data_1 = Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_1)).getText();
		//Driver.findElement(By.xpath("//*[@id=\"notificationx-5feaee7be1a58\"]/div/span/svg")).click();
		Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_1)).click();
		String style_1_data_1_page = Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_1_page)).getText();
		assertEquals(style_1_data_1, style_1_data_1_page);
		Driver.navigate().back();
		Thread.sleep(2000);
		JavascriptExecutor style_1_lmore = (JavascriptExecutor) Driver;
		style_1_lmore.executeScript("window.scrollTo(0,1400)", "");
		Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_lmore)).click();
		Thread.sleep(2000);
		JavascriptExecutor style_1_more = (JavascriptExecutor) Driver;
		style_1_more.executeScript("window.scrollTo(0,2200)", "");
		String style_1_data_2 = Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_2)).getText();
		Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_2)).click();
		String style_1_data_2_page = Driver.findElement(By.xpath(PostGridUtils.Locator.style_1_data_2_page)).getText();
		assertEquals(style_1_data_2, style_1_data_2_page);
		Driver.navigate().back();
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2900)", "");
		
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_2_header)).getText(), PostGridUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_2_data_1)).getText(), PostGridUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_2_data_1_author)).getText(), PostGridUtils.Text.style_2_data_1_author);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_2_data_2)).getText(), PostGridUtils.Text.style_2_data_2);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_2_data_2_author)).getText(), PostGridUtils.Text.style_2_data_2_author);
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,5100)", "");
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_3_header)).getText(), PostGridUtils.Text.style_3_header);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_3_data_1)).getText(), PostGridUtils.Text.style_3_data_1);
		assertEquals(Driver.findElement(By.xpath(PostGridUtils.Locator.style_3_data_2)).getText(), PostGridUtils.Text.style_3_data_2);
		
		System.out.println("POST GRID ALL OK");
		System.out.println("----------------------");
		
		

		
		
	}
}
