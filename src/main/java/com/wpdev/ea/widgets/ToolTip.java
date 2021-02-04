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

import com.wpdev.ea.utils.AdvancedAccordionUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.ToolTipUtils;
import com.wpdev.ea.utils.config;

public class ToolTip {
	@Test
	public static void ToolTip() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/tooltip/");
		System.out.println("TESTING TOOLTIP");

		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.widget_title)).getText(),
				ToolTipUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.widget_desc)).getText(),
				ToolTipUtils.Text.widget_desc);
		Thread.sleep(2000);

		if (config.doc_check == "YES") {
			Driver.findElement(By.xpath(ToolTipUtils.Locator.doc_link)).click();
			ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
			Driver.switchTo().window(tabs2.get(1));
			// assertEquals(Driver.getTitle(), ToolTipUtils.Text.doc_page_title);
			System.out.println("DOC PAGE WORKING");
			Driver.close();
			Driver.switchTo().window(tabs2.get(0));
		}

		if (Driver.findElement(By.xpath(config.crisp_close))
				.isDisplayed()) {
			Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,900)", "");
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_header)).getText(),
				ToolTipUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_desc)).getText(),
				ToolTipUtils.Text.style_1_desc);

		Actions mousehover = new Actions(Driver);
		WebElement style_1_data_1 = Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_data_1_icon));
		mousehover.moveToElement(style_1_data_1).build().perform();
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_data_1)).getText(),
				ToolTipUtils.Text.style_1_data_1);

		WebElement style_1_data_2 = Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_data_2_icon));
		mousehover.moveToElement(style_1_data_2).build().perform();
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_data_2)).getText(),
				ToolTipUtils.Text.style_1_data_2);

		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_header)).getText(),
				ToolTipUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_1_desc)).getText(),
				ToolTipUtils.Text.style_1_desc);

		/*
		 * JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		 * style_2.executeScript("window.scrollTo(0,2700)", ""); WebElement
		 * style_2_data_1 =
		 * Driver.findElement(By.xpath(ToolTipUtils.Locator.style_2_data_2_icon));
		 * mousehover.moveToElement(style_2_data_1).build().perform();
		 * assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_2_data_1)
		 * ).getText(), ToolTipUtils.Text.style_2_data_1);
		 * 
		 * WebElement style_2_data_2 =
		 * Driver.findElement(By.xpath(ToolTipUtils.Locator.style_2_data_2_icon));
		 * mousehover.moveToElement(style_2_data_2).build().perform();
		 * assertEquals(Driver.findElement(By.xpath(ToolTipUtils.Locator.style_2_data_2)
		 * ).getText(), ToolTipUtils.Text.style_2_data_2);
		 */
		System.out.println("TOOLTIP ALL OK");
		System.out.println("----------------------");
	}
}
