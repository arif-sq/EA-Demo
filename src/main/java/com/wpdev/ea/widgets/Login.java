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
import com.wpdev.ea.utils.LoginUtils;
import com.wpdev.ea.utils.TestimonialsUtils;
import com.wpdev.ea.utils.config;

public class Login {
	@Test
	public static void Login() throws InterruptedException {
		
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		
		Driver.get(config.base_url + "/login-register-form/");
		System.out.println("NOW TESTING LOGIN REGISTER PAGE");

		assertEquals(Driver.getTitle(), LoginUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(LoginUtils.Locator.widget_title)).getText(),
				LoginUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(LoginUtils.Locator.widget_desc)).getText(),
				LoginUtils.Text.widget_desc);
		Thread.sleep(2000);
		if (config.doc_check == "YES") {
		Driver.findElement(By.xpath(LoginUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		//assertEquals(Driver.getTitle(), AdvancedAccordionUtils.Text.doc_page_title);
		System.out.println("DOC PAGE WORKING");
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		}
		//Driver.findElement(By.className("nx-close")).click();
		if (Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).isDisplayed())
		{
		Driver.findElement(By.xpath("//*[@id=\"crisp-chatbox\"]/div/a/span[1]/span/span[1]/span[1]/span")).click();
		}		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,2320)", "");

		Thread.sleep(2000);
//		Driver.findElement(By.xpath(LoginUtils.Locator.style_2_uname)).clear();
		Actions cursor = new Actions(Driver);
		WebElement email = Driver.findElement(By.id("eael-user-login"));
		cursor.moveToElement(email).click().build().perform();
//		Driver.findElement(By.id("eael-user-login")).click();
//		Driver.findElement(By.id("eael-user-login")).clear();;
//		Driver.findElement(By.id("eael-user-login")).sendKeys("Hello");

//				Driver.findElement(By.xpath(LoginUtils.Locator.style_2_uname)).sendKeys(LoginUtils.Text.style_2_wuname);
		//Driver.findElement(By.xpath(LoginUtils.Locator.style_2_pass)).click();
		//Driver.findElement(By.xpath(LoginUtils.Locator.style_2_pass)).sendKeys(LoginUtils.Text.style_2_wpass);
		//Driver.findElement(By.xpath(LoginUtils.Locator.style_2_submit)).click();
	}
}
