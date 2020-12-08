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

import com.wpdev.ea.utils.AdvancedDataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.ImageComparisonUtils;
import com.wpdev.ea.utils.config;

public class ImageComparison {
	@Test
	public static void ImageComparison() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "image-comparison");
		System.out.println("Now Testing Image Comparison Page");

		//assertEquals(Driver.getTitle(), ImageComparisonUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ImageComparisonUtils.Locator.widget_title)).getText(),
				ImageComparisonUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ImageComparisonUtils.Locator.widget_desc)).getText(),
				ImageComparisonUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ImageComparisonUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), ImageComparisonUtils.Text.doc_page_title);
		System.out.println("Documentation Page working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1170)");
		
		Actions mousehover = new Actions(Driver);
		WebElement style_1_box= Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1));
		mousehover.moveToElement(style_1_box).build().perform();
		
		assertEquals(Driver.findElement(By.xpath(ImageComparisonUtils.Locator.style_1_after)).getText(), ImageComparisonUtils.Text.style_1_after);
	
	
	}

}
