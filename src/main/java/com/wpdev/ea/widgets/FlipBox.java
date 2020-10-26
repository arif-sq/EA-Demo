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
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.config;

public class FlipBox {
	@Test
	public static void FlipBox() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/flip-box/");

		assertEquals(Driver.getTitle(), FlipBoxUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.widget_title)).getText(),
				FlipBoxUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.widget_desc)).getText(),
				FlipBoxUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(FlipBoxUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), FlipBoxUtils.Text.doc_page_title);
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();

		JavascriptExecutor Style_1 = (JavascriptExecutor) Driver;
		Style_1.executeScript("window.scrollBy(0,932)");

		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_header)).getText(),
				FlipBoxUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1_front)).getText(),
				FlipBoxUtils.Text.style_1_box_1_front);
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_2_front)).getText(),
				FlipBoxUtils.Text.style_1_box_2_front);
		Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1_icon)).isDisplayed();

		Actions mousehover = new Actions(Driver);

		WebElement style_1_box_1 = Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1));
		mousehover.moveToElement(style_1_box_1).build().perform();
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1_back)).getText(),
				FlipBoxUtils.Text.style_1_box_1_back);
		WebElement style_1_box_2 = Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_2));
		mousehover.moveToElement(style_1_box_2).build().perform();
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_2_back)).getText(),
				FlipBoxUtils.Text.style_1_box_2_back);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollBy(0,1680)");
		
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_header)).getText(),
				FlipBoxUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1_front)).getText(),
				FlipBoxUtils.Text.style_1_box_1_front);
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_2_front)).getText(),
				FlipBoxUtils.Text.style_1_box_2_front);
		Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_1_box_1_icon)).isDisplayed();

	

		WebElement style_2_box_1 = Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_2_box_1));
		mousehover.moveToElement(style_2_box_1).build().perform();
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_2_box_1_back)).getText(),
				FlipBoxUtils.Text.style_2_box_1_back);
		WebElement style_2_box_2 = Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_2_box_2));
		mousehover.moveToElement(style_2_box_2).build().perform();
		assertEquals(Driver.findElement(By.xpath(FlipBoxUtils.Locator.style_2_box_2_back)).getText(),
				FlipBoxUtils.Text.style_2_box_2_back);

	}

}
