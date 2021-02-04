package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.ToggleUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.OffCanvasUtils;
import com.wpdev.ea.utils.config;

public class Toogle {
	@Test
	public static void ContentToggle() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/content-toggle/");
		System.out.println("TESTING TOGGLE");

		assertEquals(Driver.getTitle(), ToggleUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.widget_title)).getText(),
				ToggleUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.widget_desc)).getText(),
				ToggleUtils.Text.widget_desc);
		Thread.sleep(2000);
		if (config.doc_check == "YES") {
			Driver.findElement(By.xpath(ToggleUtils.Locator.doc_link)).click();
			ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
			Driver.switchTo().window(tabs2.get(1));
			// assertEquals(Driver.getTitle(), ToggleUtils.Text.doc_page_title);
			System.out.println("DOC PAGE WORKING");
			Driver.close();
			Driver.switchTo().window(tabs2.get(0));
		}
		// Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span"))
				.isDisplayed()) {
			Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}

		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1100)", "");
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.style_1_header)).getText(),
				ToggleUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.style_1_desc)).getText(),
				ToggleUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.style_1_data_1)).getText(),
				ToggleUtils.Text.style_1_data_1);
		Driver.findElement(By.xpath(ToggleUtils.Locator.style_1_toggle)).click();
		assertEquals(Driver.findElement(By.xpath(ToggleUtils.Locator.style_1_data_2)).getText(),
				ToggleUtils.Text.style_1_data_2);

		System.out.println("TOGGLE ALL OK");
		System.out.println("----------------------");
	}
}
