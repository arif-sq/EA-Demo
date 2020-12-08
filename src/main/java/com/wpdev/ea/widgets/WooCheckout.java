package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.ProductGridUtils;
import com.wpdev.ea.utils.WooCheckoutUtils;
import com.wpdev.ea.utils.config;

public class WooCheckout {
	
	@Test
	public static void WooCheckout() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/woo-checkout/");
		System.out.println("Now Testing Woo Checkout Page");

		assertEquals(Driver.getTitle(), WooCheckoutUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(WooCheckoutUtils.Locator.widget_title)).getText(),
				WooCheckoutUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(WooCheckoutUtils.Locator.widget_desc)).getText(),
				WooCheckoutUtils.Text.widget_desc);
		Thread.sleep(2000);
//		//Driver.findElement(By.xpath(WooCheckoutUtils.Locator.doc_link)).click();
//		//ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
//		//Driver.switchTo().window(tabs2.get(1));
//		//assertEquals(Driver.getTitle(), ProductGridUtils.Text.doc_page_title);
//		System.out.println("Documentation Page working");
//		Driver.close();
//		//Driver.switchTo().window(tabs2.get(0));
//		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1120)", "");
		
		String d_1 = Driver.findElement(By.xpath(WooCheckoutUtils.Locator.data_1_price)).getText();
		
		d_1 = d_1.replace("£", "");
		System.out.println(d_1);

		String d_2 = Driver.findElement(By.xpath(WooCheckoutUtils.Locator.data_2_price)).getText();
		System.out.println(d_2);

	}
}
