package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CreativeButtonsUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.config;

public class CreativeButtons {
	@Test
	public static void CreativeButtons() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/creative-buttons/");

		assertEquals(Driver.getTitle(), CreativeButtonsUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.widget_title)).getText(),
				CreativeButtonsUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.widget_desc)).getText(),
				CreativeButtonsUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), CreativeButtonsUtils.Text.doc_page_title);
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.style_1_header)).getText(), CreativeButtonsUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.style_1_button_1)).getText(), CreativeButtonsUtils.Text.style_1_button_1);
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.style_1_button_2_front)).getText(), CreativeButtonsUtils.Text.style_1_button_2_front);
		
		Actions mousehover = new Actions(Driver);

		WebElement style_1_button_1 = Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.style_1_button_2_front));
		mousehover.moveToElement(style_1_button_1).build().perform();
		
		assertEquals(Driver.findElement(By.xpath(CreativeButtonsUtils.Locator.style_1_button_2_back)).getText(), CreativeButtonsUtils.Text.style_1_button_2_back);
		
		
	}
}
