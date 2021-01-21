package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.InteractivePromoUtils;
import com.wpdev.ea.utils.PriceMenuUtils;
import com.wpdev.ea.utils.config;

public class InteractivePromo {
	@Test
	public static void InteractivePromo() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/interactive-promo/");
		System.out.println("TESTING INTERACTIVE PROMO");
		assertEquals(Driver.getTitle(), InteractivePromoUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.widget_title)).getText(),
				InteractivePromoUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.widget_desc)).getText(),
				InteractivePromoUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(InteractivePromoUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), PriceMenuUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_1_header)).getText(), InteractivePromoUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_1_desc)).getText(), InteractivePromoUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_1_data_1)).getText(), InteractivePromoUtils.Text.style_1_data_1);
		
		Actions mousehover = new Actions(Driver);
		WebElement style_1_data_1 = Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_1_data_1));
		mousehover.moveToElement(style_1_data_1).build().perform();
		Thread.sleep(1500);
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_1_data_1_desc)).getText(), InteractivePromoUtils.Text.style_1_data_1_desc);
		
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,1750)");
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_2_data_1)).getText(), InteractivePromoUtils.Text.style_2_data_1);
		
		
		WebElement style_2_data_1 = Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_2_data_1));
		mousehover.moveToElement(style_2_data_1).build().perform();
		Thread.sleep(1500);
		assertEquals(Driver.findElement(By.xpath(InteractivePromoUtils.Locator.style_2_data_1_desc)).getText(), InteractivePromoUtils.Text.style_2_data_1_desc);
		
		System.out.println("INTERACTIVE PROMO ALL OK");
		System.out.println("----------------------");
	}
}
