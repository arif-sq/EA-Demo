package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.SmartPostListUtils;
import com.wpdev.ea.utils.config;

public class SmartPostList {
	@Test
	public static void SmartPostList() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/post-list/");
		System.out.println("Now Testing Smart Post List Page ");
		assertEquals(Driver.getTitle(), SmartPostListUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(SmartPostListUtils.Locator.widget_title)).getText(),
				SmartPostListUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(SmartPostListUtils.Locator.widget_desc)).getText(),
				SmartPostListUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(SmartPostListUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), SmartPostListUtils.Text.doc_page_title);
		System.out.println("Documentation Page Working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,900)", "");
		
	}

}
