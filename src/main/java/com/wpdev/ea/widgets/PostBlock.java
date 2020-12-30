package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.PostBlockUtils;
import com.wpdev.ea.utils.config;

public class PostBlock {
	@Test
	public static void PostBlock() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/post-block/");
		System.out.println("TESTING POST BLOCK");

		assertEquals(Driver.getTitle(), PostBlockUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.widget_title)).getText(),
				PostBlockUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.widget_desc)).getText(),
				PostBlockUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(PostBlockUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), PostBlockUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_header)).getText(), PostBlockUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_1_header)).getText(), PostBlockUtils.Text.style_1_data_1_header);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_1_desc)).getText(), PostBlockUtils.Text.style_1_data_1_desc);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_2_header)).getText(), PostBlockUtils.Text.style_1_data_2_header);
		assertEquals(Driver.findElement(By.xpath(PostBlockUtils.Locator.style_1_data_2_desc)).getText(), PostBlockUtils.Text.style_1_data_2_desc);
		
		System.out.println("POST BLOCK ALL OK");
		System.out.println("----------------------");
	}
}
