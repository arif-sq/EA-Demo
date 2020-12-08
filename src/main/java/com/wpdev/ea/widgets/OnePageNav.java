package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CreativeButtonsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.OnePageNavUtils;
import com.wpdev.ea.utils.config;

public class OnePageNav {
	@Test
	public static void OnePageNav() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/one-page-nav/");
		
		System.out.println("Now Testing One Page Navigation Page");


		assertEquals(Driver.getTitle(), OnePageNavUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.widget_title)).getText(),
				OnePageNavUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.widget_desc)).getText(),
				OnePageNavUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(OnePageNavUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), OnePageNavUtils.Text.doc_page_title);
		System.out.println("Documentation Page Working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		Driver.findElement(By.xpath(OnePageNavUtils.Locator.home)).click();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.style_1)).getText(), OnePageNavUtils.Text.style_1);
		Thread.sleep(3000);
		
		Driver.findElement(By.xpath(OnePageNavUtils.Locator.features)).click();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.style_2)).getText(), OnePageNavUtils.Text.style_2);
		Thread.sleep(3000);
		
		Driver.findElement(By.xpath(OnePageNavUtils.Locator.nx_close)).click();
		
		Driver.findElement(By.xpath(OnePageNavUtils.Locator.services)).click();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.style_3)).getText(), OnePageNavUtils.Text.style_3);
		Thread.sleep(3000);

		Driver.findElement(By.xpath(OnePageNavUtils.Locator.p_plan)).click();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.style_4)).getText(), OnePageNavUtils.Text.style_4);
		Thread.sleep(3000);

		Driver.findElement(By.xpath(OnePageNavUtils.Locator.blog)).click();
		assertEquals(Driver.findElement(By.xpath(OnePageNavUtils.Locator.style_5)).getText(), OnePageNavUtils.Text.style_5);
		Thread.sleep(3000);


	}
}
