package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.ContactForm7Utils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.WPFormsUtils;
import com.wpdev.ea.utils.config;

public class WPForms {
	@Test
	public static void WPForms() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/wpforms/");
		System.out.println("TESTING WP FORM");
		assertEquals(Driver.getTitle(), WPFormsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(WPFormsUtils.Locator.widget_title)).getText(),
				WPFormsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(WPFormsUtils.Locator.widget_desc)).getText(),
				WPFormsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(WPFormsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(WPFormsUtils.Locator.doc_page_title)).getText(), WPFormsUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1180)", "");
		
		Driver.findElement(By.xpath(WPFormsUtils.Locator.style_1_fname)).sendKeys(WPFormsUtils.Text.style_1_fname);
		Driver.findElement(By.xpath(WPFormsUtils.Locator.style_1_lname)).sendKeys(WPFormsUtils.Text.style_1_lname);
		Driver.findElement(By.xpath(WPFormsUtils.Locator.style_1_email)).sendKeys(WPFormsUtils.Text.style_1_email);
		Driver.findElement(By.xpath(WPFormsUtils.Locator.style_1_message)).sendKeys(WPFormsUtils.Text.style_1_message);
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		Driver.findElement(By.xpath(WPFormsUtils.Locator.style_1_submit)).click();
	}
}
