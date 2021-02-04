package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FeatureListUtils;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.config;

public class FeatureList {
	@Test
	public static void FeatureList() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/feature-list/");
		System.out.println("TESTING FEATURE LIST");
		Driver.manage().window().maximize();

		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.widget_title)).getText(),
				FeatureListUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.widget_desc)).getText(),
				FeatureListUtils.Text.widget_desc);
		Thread.sleep(1000);
		if (config.doc_check == "YES") {
			Driver.findElement(By.xpath(FeatureListUtils.Locator.doc_link)).click();
			ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
			Driver.switchTo().window(tabs2.get(1));
			// assertEquals(Driver.getTitle(), FeatureListUtils.Text.doc_page_title);
			System.out.println("DOC PAGE WORKING");
			Driver.close();
			Driver.switchTo().window(tabs2.get(0));
		}

		// STYLE 1
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,950)");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_header)).getText(),
				FeatureListUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_desc)).getText(),
				FeatureListUtils.Text.style_1_desc);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_data_1)).getText(),
				FeatureListUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_data_1_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_data_2)).getText(),
				FeatureListUtils.Text.style_1_data_2);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_1_data_2_icon)).isDisplayed();

		// STYLE 2
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,1800)");
		if (Driver.findElement(By.xpath(config.crisp_close)).isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_header)).getText(),
				FeatureListUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_desc)).getText(),
				FeatureListUtils.Text.style_2_desc);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_data_1)).getText(),
				FeatureListUtils.Text.style_2_data_1);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_data_1_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_data_2)).getText(),
				FeatureListUtils.Text.style_2_data_2);
		Driver.findElement(By.xpath(FeatureListUtils.Locator.style_2_data_2_icon)).isDisplayed();

		System.out.println("FEATURE LIST ALL OK");
		System.out.println("----------------------");

	}
}

