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
import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.config;

public class AdvancedAccordion {
	@Test
	public static void AdvancedAccordion() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/advanced-accordion/");
		System.out.println("Now Testing Advanced Accordion Page");

		assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.widget_title)).getText(),
				AdvancedAccordionUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.widget_desc)).getText(),
				AdvancedAccordionUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.doc_page_title);
		System.out.println("Documentation Page working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,998)", "");
		
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_header)).getText(), AdvancedAccordionUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_desc)).getText(), AdvancedAccordionUtils.Text.style_1_desc);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_1_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_1_title)).getText(), AdvancedAccordionUtils.Text.style_1_data_1_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_1_desc)).getText(), AdvancedAccordionUtils.Text.style_1_data_1_desc);
		
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_2_icon)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_2_title)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_2_title)).getText(), AdvancedAccordionUtils.Text.style_1_data_2_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_2_desc)).getText(), AdvancedAccordionUtils.Text.style_1_data_2_desc);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_3_icon)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_3_icon)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_3_title)).getText(), AdvancedAccordionUtils.Text.style_1_data_3_title);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_4_icon)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_4_title)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_4_title)).getText(), AdvancedAccordionUtils.Text.style_1_data_4_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_4_desc)).getText(), AdvancedAccordionUtils.Text.style_1_data_4_desc);
		System.out.println("Style 1 Working");
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1683)", "");
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_header)).getText(), AdvancedAccordionUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_desc)).getText(), AdvancedAccordionUtils.Text.style_2_desc);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_1_image)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_1_title)).getText(), AdvancedAccordionUtils.Text.style_2_data_1_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_1_desc)).getText(), AdvancedAccordionUtils.Text.style_2_data_1_desc);
		
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_2_title)).click();
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_2_image)).isDisplayed();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_2_title)).getText(), AdvancedAccordionUtils.Text.style_2_data_2_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_2_desc)).getText(), AdvancedAccordionUtils.Text.style_2_data_2_desc);
		
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_3_image)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_1_data_3_title)).getText(), AdvancedAccordionUtils.Text.style_1_data_3_title);
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_4_image)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_4_title)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_4_title)).getText(), AdvancedAccordionUtils.Text.style_2_data_4_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedAccordionUtils.Locator.style_2_data_4_desc)).getText(), AdvancedAccordionUtils.Text.style_2_data_4_desc);
		System.out.println("Style 2 Working");
		
		System.out.println("ADVANCED ACCORDION ALL OK");
		System.out.println("-------------------------");
		
	}

}
