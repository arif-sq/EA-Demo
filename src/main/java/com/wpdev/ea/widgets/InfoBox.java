package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.InfoBoxUtils;
import com.wpdev.ea.utils.config;

public class InfoBox {
	
	@Test
	public static void InfoBox() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/info-box/");
		System.out.println("TESTING INFO BOX");
		

		assertEquals(Driver.getTitle(), InfoBoxUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.widget_title)).getText(),
				InfoBoxUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.widget_desc)).getText(),
				InfoBoxUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), InfoBoxUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}
		
		//STYLE 1
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,979)", "");
		Thread.sleep(2000);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_header)).getText(), InfoBoxUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_desc)).getText(), InfoBoxUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_data_1)).getText(), InfoBoxUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_data_2)).getText(), InfoBoxUtils.Text.style_1_data_2);
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_icon_1)).isDisplayed();
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_1_icon_2)).isDisplayed();
		
		
		//STYLE 2
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1573)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_header)).getText(),
				InfoBoxUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_desc)).getText(), InfoBoxUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_data_1)).getText(), InfoBoxUtils.Text.style_2_data_1);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_data_2)).getText(), InfoBoxUtils.Text.style_2_data_2);
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_icon_1)).isDisplayed();
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_2_icon_2)).isDisplayed();
		
		
		//STYLE 3
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,3760)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_header)).getText(),
				InfoBoxUtils.Text.style_3_header);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_desc)).getText(), InfoBoxUtils.Text.style_3_desc);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_data_1)).getText(), InfoBoxUtils.Text.style_3_data_1);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_data_2)).getText(), InfoBoxUtils.Text.style_3_data_2);
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_icon_1)).isDisplayed();
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_3_icon_2)).isDisplayed();
	
		
		//STYLE 4
		JavascriptExecutor style_4 = (JavascriptExecutor) Driver;
		style_4.executeScript("window.scrollTo(0,5436)", "");
		Thread.sleep(2000);
		
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_header)).getText(),
				InfoBoxUtils.Text.style_4_header);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_desc)).getText(), InfoBoxUtils.Text.style_4_desc);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_data_1)).getText(), InfoBoxUtils.Text.style_4_data_1);
		assertEquals(Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_data_2)).getText(), InfoBoxUtils.Text.style_4_data_2);
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_icon_1)).isDisplayed();
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_icon_2)).isDisplayed();
		Driver.findElement(By.xpath(InfoBoxUtils.Locator.style_4_image)).isDisplayed();
		
		System.out.println("INFO BOX ALL OK");
		System.out.println("---------------");
	}

}
