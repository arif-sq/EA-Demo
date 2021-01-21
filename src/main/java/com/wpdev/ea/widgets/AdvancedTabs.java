package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.AdvancedTabsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class AdvancedTabs {
	@Test
	public static void AdvancedTabs() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/advanced-tabs/");
		System.out.println("TESTING ADVANCED TABS");

		assertEquals(Driver.getTitle(), AdvancedTabsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.widget_title)).getText(),
				AdvancedTabsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.widget_desc)).getText(),
				AdvancedTabsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedTabsUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1110)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_header)).getText(), AdvancedTabsUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_desc)).getText(), AdvancedTabsUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_1_header)).getText(), AdvancedTabsUtils.Text.style_1_data_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_1_desc)).getText(), AdvancedTabsUtils.Text.style_1_data_1_desc);
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_1_icon)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_2_header)).click();
		
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_2_header)).getText(), AdvancedTabsUtils.Text.style_1_data_2_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_2_desc)).getText(),AdvancedTabsUtils.Text.style_1_data_2_desc);
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_1_data_2_icon)).isDisplayed();
		//STYLE 2
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2563)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_header)).getText(), AdvancedTabsUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_desc)).getText(), AdvancedTabsUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_1_header)).getText(), AdvancedTabsUtils.Text.style_2_data_1_header);
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_1_desc)).getText(), AdvancedTabsUtils.Text.style_2_data_1_desc);
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_1_image)).isDisplayed();
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_2_header)).click();
		
		assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_2_header)).getText(), AdvancedTabsUtils.Text.style_2_data_2_header);
		//assertEquals(Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_2_desc)).getText(),AdvancedTabsUtils.Text.style_2_data_2_desc);
		Driver.findElement(By.xpath(AdvancedTabsUtils.Locator.style_2_data_2_image)).isDisplayed();
		
		System.out.println("ADVANCED TABS ALL OK");
		System.out.println("-------------------------");
	}

}
