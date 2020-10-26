package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DataTableUtils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class DataTable {
	@Test
	public static void DataTable() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/table/");
		assertEquals(Driver.getTitle(), DataTableUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.widget_title)).getText(),
				DataTableUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.widget_desc)).getText(),
				DataTableUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(DataTableUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), DataTableUtils.Text.doc_page_title);
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();

		// STYLE 1
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_title)).getText(),
				DataTableUtils.Text.Style_1_title);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_desc)).getText(),
				DataTableUtils.Text.Style_1_desc);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_header_1)).getText(),
				DataTableUtils.Text.style_1_header_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_header_2)).getText(),
				DataTableUtils.Text.style_1_header_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_header_3)).getText(),
				DataTableUtils.Text.style_1_header_3);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_header_4)).getText(),
				DataTableUtils.Text.style_1_header_4);
		WebElement style_1_icon_1 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_icon_1));
		WebElement style_1_icon_2 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_icon_2));
		WebElement style_1_icon_3 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_icon_3));
		WebElement style_1_icon_4 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_icon_4));

		if (style_1_icon_1.isDisplayed() && style_1_icon_2.isDisplayed() && style_1_icon_3.isDisplayed()
				&& style_1_icon_4.isDisplayed()) {
			System.out.println("Style 1 Icon Display Passed");
		}
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_data_1)).getText(),
				DataTableUtils.Text.style_1_data_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_data_2)).getText(),
				DataTableUtils.Text.style_1_data_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_data_3)).getText(),
				DataTableUtils.Text.style_1_data_3);
		Driver.findElement(By.xpath(DataTableUtils.Locator.style_1_data_3)).click();

		// STYLE 2
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_title)).getText(),
				DataTableUtils.Text.Style_2_title);

		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_header_1)).getText(),
				DataTableUtils.Text.style_2_header_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_header_2)).getText(),
				DataTableUtils.Text.style_2_header_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_header_3)).getText(),
				DataTableUtils.Text.style_2_header_3);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_header_4)).getText(),
				DataTableUtils.Text.style_2_header_4);

		WebElement style_2_icon_1 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_icon_1));
		WebElement style_2_icon_2 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_icon_2));
		WebElement style_2_icon_3 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_icon_3));
		WebElement style_2_icon_4 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_2_icon_4));

		if (style_2_icon_1.isDisplayed() && style_2_icon_2.isDisplayed() && style_2_icon_3.isDisplayed()
				&& style_2_icon_4.isDisplayed()) {
			System.out.println("Style 2 Icon Display Passed");
		}

		// STYLE 3
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.Style_3_title)).getText(),
				DataTableUtils.Text.Style_3_title);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_header_1)).getText(),
				DataTableUtils.Text.style_3_header_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_header_2)).getText(),
				DataTableUtils.Text.style_3_header_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_header_3)).getText(),
				DataTableUtils.Text.style_3_header_3);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_header_4)).getText(),
				DataTableUtils.Text.style_3_header_4);
		WebElement style_3_icon_1 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_icon_1));
		WebElement style_3_icon_2 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_icon_2));
		WebElement style_3_icon_3 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_icon_3));
		WebElement style_3_icon_4 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_icon_4));

		if (style_3_icon_1.isDisplayed() && style_3_icon_2.isDisplayed() && style_3_icon_3.isDisplayed()
				&& style_3_icon_4.isDisplayed()) {
			System.out.println("Style 3 Icon Display Passed");
		}
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_1)).getText(),
				DataTableUtils.Text.style_3_data_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_2)).getText(),
				DataTableUtils.Text.style_3_data_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_3)).getText(),
				DataTableUtils.Text.style_3_data_3);
		Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_3)).click();

		// STYLE 4
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_title)).getText(),
				DataTableUtils.Text.Style_4_title);

		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_header_1)).getText(),
				DataTableUtils.Text.style_4_header_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_header_2)).getText(),
				DataTableUtils.Text.style_4_header_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_header_3)).getText(),
				DataTableUtils.Text.style_4_header_3);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_header_4)).getText(),
				DataTableUtils.Text.style_4_header_4);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_header_5)).getText(),
				DataTableUtils.Text.style_4_header_5);

		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_data_1)).getText(),
				DataTableUtils.Text.style_4_data_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_data_2)).getText(),
				DataTableUtils.Text.style_4_data_2);
		Driver.findElement(By.xpath(DataTableUtils.Locator.style_4_data_2)).click();
		System.out.println("No Icons Availble On Style 4");

		/*
		 * // SORTING //String sorting =
		 * "//*[@id=\"eael-data-table-1c75c528\"]/thead/tr/th[2]";
		 * //Driver.findElement(By.xpath(sorting)).click(); //
		 * assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.
		 * style_4_data_1)).getText(), // DataTableUtils.Text.style_4_data_2); //
		 * assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.
		 * style_4_data_2)).getText(), // DataTableUtils.Text.style_4_data_1);
		 */
		// STYLE 5
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.Style_5_title)).getText(),
				DataTableUtils.Text.Style_5_title);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_header_1)).getText(),
				DataTableUtils.Text.style_5_header_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_header_2)).getText(),
				DataTableUtils.Text.style_5_header_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_header_3)).getText(),
				DataTableUtils.Text.style_5_header_3);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_header_4)).getText(),
				DataTableUtils.Text.style_5_header_4);
		WebElement style_5_icon_1 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_icon_1));
		WebElement style_5_icon_2 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_icon_2));
		WebElement style_5_icon_3 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_icon_3));
		WebElement style_5_icon_4 = Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_icon_4));

		if (style_5_icon_1.isDisplayed() && style_5_icon_2.isDisplayed() && style_5_icon_3.isDisplayed()
				&& style_5_icon_4.isDisplayed()) {
			System.out.println("Style 5 Icon Display Passed");
		}
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_1)).getText(),
				DataTableUtils.Text.style_3_data_1);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_2)).getText(),
				DataTableUtils.Text.style_3_data_2);
		assertEquals(Driver.findElement(By.xpath(DataTableUtils.Locator.style_3_data_3)).getText(),
				DataTableUtils.Text.style_3_data_3);
		Driver.findElement(By.xpath(DataTableUtils.Locator.style_5_data_2)).click();

	}
}
