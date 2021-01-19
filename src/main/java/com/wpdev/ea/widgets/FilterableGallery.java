package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CreativeButtonsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FilterableGalleryUtils;
import com.wpdev.ea.utils.TestimonialsUtils;
import com.wpdev.ea.utils.config;

public class FilterableGallery {
	@Test
	public static void FilterableGallery() throws InterruptedException {
		
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		
		Driver.get(config.base_url + "/filterable-gallery/");
		System.out.println("TESTING FILTERABLE GALLERY");

		assertEquals(Driver.getTitle(), FilterableGalleryUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.widget_title)).getText(),
				FilterableGalleryUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.widget_desc)).getText(),
				FilterableGalleryUtils.Text.widget_desc);
		Thread.sleep(2000);
		//Driver.findElement(By.xpath(TestimonialsUtils.Locator.doc_link)).click();
		//ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		//Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.doc_page_title);
		//System.out.println("DOC PAGE WORKING");
		//Driver.close();
		//Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1100)", "");
		Thread.sleep(2000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_1_header_1)).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_1_header_2)).click();	
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_1_header_3)).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_1_header_4)).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_1_header_5)).click();
		Thread.sleep(1000);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1800)", "");
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_2_header_2)).click();	
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_2_header_3)).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_2_header_4)).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_2_header_5)).click();
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,3600)", "");
		assertEquals(Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_1)).getText(), FilterableGalleryUtils.Text.style_3_data_1);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_1_icon)).isDisplayed();
		
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_header_2)).click();	
		assertEquals(Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_2)).getText(), FilterableGalleryUtils.Text.style_3_data_2);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_2_icon)).isDisplayed();
		
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_header_3)).click();	
		assertEquals(Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_3)).getText(), FilterableGalleryUtils.Text.style_3_data_3);
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_data_3_icon)).isDisplayed();
		
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_header_4)).click();	
		
		Driver.findElement(By.xpath(FilterableGalleryUtils.Locator.style_3_header_5)).click();	
		
		
		
	}
}
