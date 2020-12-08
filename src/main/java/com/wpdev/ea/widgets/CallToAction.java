package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CallToActionUtils;
import com.wpdev.ea.utils.DataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.PricingTableUtils;
import com.wpdev.ea.utils.config;

public class CallToAction {
	@Test
	public static void PricingTable() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/call-to-action/");
		System.out.println("Now Testing Call To Action Page ");
		assertEquals(Driver.getTitle(), CallToActionUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.widget_title)).getText(),
				CallToActionUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.widget_desc)).getText(),
				CallToActionUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(CallToActionUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), CallToActionUtils.Text.doc_page_title);
		System.out.println("Documentation Page Working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_1_header)).getText(), CallToActionUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_1_desc)).getText(), CallToActionUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_1_data_1)).getText(), CallToActionUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_1_btn)).getText(), CallToActionUtils.Text.style_1_btn);
		
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,1650)");
		
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_2_data_1)).getText(), CallToActionUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(CallToActionUtils.Locator.style_2_btn)).getText(), CallToActionUtils.Text.style_2_btn);
	}
}
