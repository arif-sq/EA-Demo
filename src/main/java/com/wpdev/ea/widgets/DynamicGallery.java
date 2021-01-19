package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.DynamicGalleryUtils;
import com.wpdev.ea.utils.FeatureListUtils;
import com.wpdev.ea.utils.config;

public class DynamicGallery {
	@Test
	public static void DynamicGallery() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/dynamic-gallery/");
		System.out.println("TESTING DYNAMIC GALLERY");

		assertEquals(Driver.getTitle(), DynamicGalleryUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.widget_title)).getText(),
				DynamicGalleryUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.widget_desc)).getText(),
				DynamicGalleryUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), DynamicGalleryUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
	
		assertEquals(Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_header)).getText(), DynamicGalleryUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_desc)).getText(), DynamicGalleryUtils.Text.style_1_desc);
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_sorting)).click();
		
		String style_1_data_1_text =Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_1)).getText();
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_1)).click();
		String style_1_data_1_page_header = Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_1_page)).getText();
		assertEquals(style_1_data_1_text,style_1_data_1_page_header);
		Driver.navigate().back();
		
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_sorting)).click();
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		String style_1_data_2_text =Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_2)).getText();
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_2)).click();
		String style_1_data_2_page_header = Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_2_page)).getText();
		assertEquals(style_1_data_2_text,style_1_data_2_page_header);
		Driver.navigate().back();
		
		JavascriptExecutor Style_1_lmore = (JavascriptExecutor) Driver;
		Style_1_lmore.executeScript("window.scrollTo(0,1800)");
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_lmore)).click();

		//Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		String style_2_data_3_text =Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_3)).getText();
		Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_2)).click();
		String style_1_data_3_page_header = Driver.findElement(By.xpath(DynamicGalleryUtils.Locator.style_1_data_3_page)).getText();
		assertEquals(style_1_data_2_text,style_1_data_3_page_header);
		Driver.navigate().back();
		
		System.out.println("DYNAMIC GALLERY ALL OK");
		System.out.println("----------------------");
		
	}
}
