package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.TestimonialsUtils;
import com.wpdev.ea.utils.config;

public class Testimonials {
	@Test
	public static void Testimonials() throws InterruptedException {
		
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		
		Driver.get(config.base_url + "/testimonials/");
		System.out.println("TESTING TESTIMONIALS");

		assertEquals(Driver.getTitle(), TestimonialsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.widget_title)).getText(),
				TestimonialsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.widget_desc)).getText(),
				TestimonialsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TestimonialsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_1_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_1_name)).getText(), TestimonialsUtils.Text.style_1_name);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_1_desg)).getText(), TestimonialsUtils.Text.style_1_desg);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_1_desc)).getText(), TestimonialsUtils.Text.style_1_desc);
		
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1800)");
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_2_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_2_name)).getText(), TestimonialsUtils.Text.style_2_name);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_2_desg)).getText(), TestimonialsUtils.Text.style_2_desg);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_2_desc)).getText(), TestimonialsUtils.Text.style_2_desc);
		
		JavascriptExecutor Style_3 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,2980)");
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_4_icon)).isDisplayed();
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_4_name)).getText(), TestimonialsUtils.Text.style_4_name);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_4_desg)).getText(), TestimonialsUtils.Text.style_4_desg);
		assertEquals(Driver.findElement(By.xpath(TestimonialsUtils.Locator.style_4_desc)).getText(), TestimonialsUtils.Text.style_4_desc);
	
	}
}
