package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedDataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.PostTimelineUtils;
import com.wpdev.ea.utils.config;

public class PostTimeline {
	@Test
	public static void PostTimeline() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/post-timeline/");
		System.out.println("Now Testing Post Timeline Page");

		assertEquals(Driver.getTitle(), PostTimelineUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.widget_title)).getText(),
				PostTimelineUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.widget_desc)).getText(),
				PostTimelineUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(PostTimelineUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), PostTimelineUtils.Text.doc_page_title);
		System.out.println("Documentation Page working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.style_1_header)).getText(), PostTimelineUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.style_1_desc)).getText(), PostTimelineUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.style_1_data_1)).getText(), PostTimelineUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(PostTimelineUtils.Locator.style_1_lmore)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(PostTimelineUtils.Locator.style_1_data_2)).getText(), PostTimelineUtils.Text.style_1_data_2);
	}
}
