package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.NinjaFormsUtils;
import com.wpdev.ea.utils.WPFormsUtils;
import com.wpdev.ea.utils.config;

public class NinjaForms {
	@Test
	public static void NinjaForms() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/ninja-forms/");
		System.out.println("TESTING NINJA FORM");
		assertEquals(Driver.getTitle(), NinjaFormsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(NinjaFormsUtils.Locator.widget_title)).getText(),
				NinjaFormsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(NinjaFormsUtils.Locator.widget_desc)).getText(),
				NinjaFormsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(NinjaFormsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(NinjaFormsUtils.Locator.doc_page_title)).getText(), NinjaFormsUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1440)", "");
		
		Driver.findElement(By.xpath(NinjaFormsUtils.Locator.style_1_name)).sendKeys(NinjaFormsUtils.Text.style_1_name);
		Driver.findElement(By.xpath(NinjaFormsUtils.Locator.style_1_email)).sendKeys(NinjaFormsUtils.Text.style_1_email);
		Driver.findElement(By.xpath(NinjaFormsUtils.Locator.style_1_message)).sendKeys(NinjaFormsUtils.Text.style_1_message);
		Driver.findElement(By.xpath(NinjaFormsUtils.Locator.style_1_submit)).click();
	}
	}
