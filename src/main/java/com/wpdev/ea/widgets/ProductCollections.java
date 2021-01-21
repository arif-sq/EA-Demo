package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.ProductCollectionsUtils;
import com.wpdev.ea.utils.ProductGridUtils;
import com.wpdev.ea.utils.config;

public class ProductCollections {
	@Test
	public static void ProductCollections() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/woocommerce-product-collections/");
		System.out.println("TESTING PRODUCT COLLECTION");

		assertEquals(Driver.getTitle(), ProductCollectionsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.widget_title)).getText(),
				ProductCollectionsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.widget_desc)).getText(),
				ProductCollectionsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), ProductGridUtils.Text.doc_page_title);
		System.out.println("Documentation Page working");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		Thread.sleep(2000);
		
		String style_1_data_1 = Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_1_header)).getText();
		Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_1_header)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_1_page)).getText(), style_1_data_1 );
		Driver.navigate().back();

		String style_1_data_2 = Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_2_header)).getText();
		Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_2_header)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(ProductCollectionsUtils.Locator.style_1_data_2_page)).getText(), style_1_data_2 );
		Driver.navigate().back();
		System.out.println("PRODUCT COLLECTION ALL OK");
		System.out.println("-------------------------");
		Thread.sleep(3000);
		
	}
}
