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
import com.wpdev.ea.utils.OffCanvasUtils;
import com.wpdev.ea.utils.config;

public class OffCanvas {
	@Test
	public static void OffCanvas() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/offcanvas-content/");
		System.out.println("TESTING OFF CANVAS");

		assertEquals(Driver.getTitle(), OffCanvasUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.widget_title)).getText(),
				OffCanvasUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.widget_desc)).getText(),
				OffCanvasUtils.Text.widget_desc);
		Thread.sleep(2000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(OffCanvasUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), OffCanvasUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollTo(0,1000)");
		assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_header)).getText(), OffCanvasUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_desc)).getText(), OffCanvasUtils.Text.style_1_desc);
		Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_left_btn)).click();
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_left_data)).getText(), OffCanvasUtils.Text.style_1_left_data);
		//Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		//Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_right_btn)).click();
		Thread.sleep(2000);
		//Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[2]/span/span/span[1]/span")).click();
		//Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/div/div[1]/div/span[3]/span")).click();
		
		
		//assertEquals(Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_right_data)).getText(), OffCanvasUtils.Text.style_1_right_data);
		//Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_right_btn)).click();
		
		JavascriptExecutor Style_2 = (JavascriptExecutor) Driver;
		Style_2.executeScript("window.scrollTo(0,2000)");
		//Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_2_left_btn)).click();
		Thread.sleep(2000);

		//Driver.findElement(By.xpath(OffCanvasUtils.Locator.style_1_right_btn)).click();
		
		
		
	}

}
