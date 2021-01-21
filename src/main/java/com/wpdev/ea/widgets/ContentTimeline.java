package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.ContentTimelineUtils;
import com.wpdev.ea.utils.DataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class ContentTimeline {
	@Test
	public static void ContentTimeline() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/content-timeline/");
		System.out.println("TESTING CONTENT TIMELINE");
		assertEquals(Driver.getTitle(), ContentTimelineUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.widget_title)).getText(),
				ContentTimelineUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.widget_desc)).getText(),
				ContentTimelineUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ContentTimelineUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), ContentTimelineUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1038)");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_1_header)).getText(), ContentTimelineUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_1_desc)).getText(), ContentTimelineUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_1_data_1)).getText(), ContentTimelineUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_1_data_2)).getText(), ContentTimelineUtils.Text.style_1_data_2);
		Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_1_icon)).click();
		
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,2320)");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_2_header)).getText(), ContentTimelineUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_2_desc)).getText(), ContentTimelineUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_2_data_1)).getText(), ContentTimelineUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_2_data_2)).getText(), ContentTimelineUtils.Text.style_2_data_2);
		Driver.findElement(By.xpath(ContentTimelineUtils.Locator.style_2_icon)).click();
		
		System.out.println("CONTENT TIMELINE ALL OK");
		System.out.println("-------------------------");
		
		
	}
}
