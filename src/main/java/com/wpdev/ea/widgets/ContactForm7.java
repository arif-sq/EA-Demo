package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.CallToActionUtils;
import com.wpdev.ea.utils.ContactForm7Utils;
import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.config;

public class ContactForm7 {
	@Test
	public static void ContactForm7() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/contact-form-7/");
		System.out.println("TESTING CONTACT FORM 7");
	
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(ContactForm7Utils.Locator.widget_title)).getText(),
				ContactForm7Utils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(ContactForm7Utils.Locator.widget_desc)).getText(),
				ContactForm7Utils.Text.widget_desc);
		Thread.sleep(1000);
		
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.findElement(By.xpath(ContactForm7Utils.Locator.doc_page_title)).getText(), ContactForm7Utils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
		if (Driver.findElement(By.xpath(config.crisp_close)).isDisplayed())
		{
		Driver.findElement(By.xpath(config.crisp_close)).click();
		}
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,1225)", "");
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_1_uname)).sendKeys(ContactForm7Utils.Text.style_1_uname);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_1_email)).sendKeys(ContactForm7Utils.Text.style_1_email);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_1_subject)).sendKeys(ContactForm7Utils.Text.style_1_subject);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_1_message)).sendKeys(ContactForm7Utils.Text.style_1_message);
		JavascriptExecutor style_1_extended = (JavascriptExecutor) Driver;
		style_1_extended.executeScript("window.scrollTo(0,1620)", "");
		if (Driver.findElement(By.xpath(config.nx_close)).isDisplayed())
		{Driver.findElement(By.xpath(config.nx_close)).click();}
		//Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_1_submit)).click();
		Thread.sleep(2000);
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2587)", "");
		
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_2_uname)).sendKeys(ContactForm7Utils.Text.style_1_uname);
		Thread.sleep(1000);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_2_email)).sendKeys(ContactForm7Utils.Text.style_1_email);
		Thread.sleep(1000);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_2_subject)).sendKeys(ContactForm7Utils.Text.style_1_subject);
		Thread.sleep(1000);
		Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_2_message)).sendKeys(ContactForm7Utils.Text.style_1_message);
		Thread.sleep(1000);
		JavascriptExecutor style_2_extended = (JavascriptExecutor) Driver;
		style_2_extended.executeScript("window.scrollTo(0,3000)", "");
		if (Driver.findElement(By.xpath(config.nx_close)).isDisplayed())
		{Driver.findElement(By.xpath(config.nx_close)).click();}
		//Driver.findElement(By.xpath(ContactForm7Utils.Locator.style_2_submit)).click();	
		
	}
}
