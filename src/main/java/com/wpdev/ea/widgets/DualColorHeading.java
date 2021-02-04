package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.DualColorHeadingUtils;
import com.wpdev.ea.utils.config;

public class DualColorHeading {
	@Test
	public static void DualColorHeading() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/dual-color-headline/");
		System.out.println("TESTING DUAL COLOR HEADING");
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.widget_title)).getText(),
				DualColorHeadingUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.widget_desc)).getText(),
				DualColorHeadingUtils.Text.widget_desc);
		Thread.sleep(1000);
		
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), DualColorHeadingUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}

		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollBy(0,973)", "");
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_header_1)).getText(), DualColorHeadingUtils.Text.style_1_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_header_2)).getText(), DualColorHeadingUtils.Text.style_1_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_desc)).getText(), DualColorHeadingUtils.Text.style_1_desc );
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_icon)).isDisplayed();
		Thread.sleep(2000);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1313)", "");
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_header_1)).getText(), DualColorHeadingUtils.Text.style_2_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_header_2)).getText(), DualColorHeadingUtils.Text.style_2_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_desc)).getText(), DualColorHeadingUtils.Text.style_2_desc );
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_icon)).isDisplayed();
		Thread.sleep(2000);
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,2634)", "");
		if (Driver.findElement(By.xpath(config.crisp_close))
				.isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_header_1)).getText(), DualColorHeadingUtils.Text.style_3_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_header_2)).getText(), DualColorHeadingUtils.Text.style_3_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_desc)).getText(), DualColorHeadingUtils.Text.style_3_desc );
		Thread.sleep(2000);
		System.out.println("DUAL COLOR HEADING ALL OK");
		System.out.println("-------------------------");
		
		
		}
	}
}
