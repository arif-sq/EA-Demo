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
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/dual-color-headline/");
		System.out.println("Now Testing Dual Color Heading Page");

		assertEquals(Driver.getTitle(), DualColorHeadingUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.widget_title)).getText(),
				DualColorHeadingUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.widget_desc)).getText(),
				DualColorHeadingUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), DualColorHeadingUtils.Text.doc_page_title);
		System.out.println("Documentation page working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollBy(0,973)", "");
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_header_1)).getText(), DualColorHeadingUtils.Text.style_1_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_header_2)).getText(), DualColorHeadingUtils.Text.style_1_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_desc)).getText(), DualColorHeadingUtils.Text.style_1_desc );
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_1_icon)).isDisplayed();
		Thread.sleep(2000);
		System.out.println("Style 1 Working");
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1313)", "");
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_header_1)).getText(), DualColorHeadingUtils.Text.style_2_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_header_2)).getText(), DualColorHeadingUtils.Text.style_2_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_desc)).getText(), DualColorHeadingUtils.Text.style_2_desc );
		Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_2_icon)).isDisplayed();
		Thread.sleep(2000);
		System.out.println("Style 2 Working");
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,2634)", "");
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_header_1)).getText(), DualColorHeadingUtils.Text.style_3_header_1 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_header_2)).getText(), DualColorHeadingUtils.Text.style_3_header_2 );
		assertEquals(Driver.findElement(By.xpath(DualColorHeadingUtils.Locator.style_3_desc)).getText(), DualColorHeadingUtils.Text.style_3_desc );
		Thread.sleep(2000);
		System.out.println("Style 3 Working");
		System.out.println("DUAL COLOR HEADING ALL OK");
		System.out.println("-------------------------");
		
		
		}

}
