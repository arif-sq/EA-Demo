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
import com.wpdev.ea.utils.TeamMemberUtils;
import com.wpdev.ea.utils.config;

public class TeamMember {
	@Test
	public static void TeamMember() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/team-members/");
		System.out.println("Now Testing Team Member Page");

		assertEquals(Driver.getTitle(), TeamMemberUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.widget_title)).getText(),
				TeamMemberUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.widget_desc)).getText(),
				TeamMemberUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), TeamMemberUtils.Text.doc_page_title);
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		//Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollTo(0,910)", "");
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_header)).getText(), TeamMemberUtils.Text.style_1_header);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_desc)).getText(), TeamMemberUtils.Text.style_1_desc);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_1_name)).getText(), TeamMemberUtils.Text.style_1_data_1_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_1_desg)).getText(), TeamMemberUtils.Text.style_1_data_1_desg);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_2_name)).getText(), TeamMemberUtils.Text.style_1_data_2_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_2_desg)).getText(), TeamMemberUtils.Text.style_1_data_2_desg);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_3_name)).getText(), TeamMemberUtils.Text.style_1_data_3_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_3_desg)).getText(), TeamMemberUtils.Text.style_1_data_3_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_1_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_2_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_3_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_1_si)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_2_si)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_1_data_3_si)).isDisplayed();
		System.out.println("Style 1 working with all icon & image");
		
		JavascriptExecutor style_2 = (JavascriptExecutor) Driver;
		style_2.executeScript("window.scrollTo(0,1750)", "");
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_header)).getText(), TeamMemberUtils.Text.style_2_header);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_desc)).getText(), TeamMemberUtils.Text.style_2_desc);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_1_name)).getText(), TeamMemberUtils.Text.style_2_data_1_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_1_desg)).getText(), TeamMemberUtils.Text.style_2_data_1_desg);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_2_name)).getText(), TeamMemberUtils.Text.style_2_data_2_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_2_desg)).getText(), TeamMemberUtils.Text.style_2_data_2_desg);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_3_name)).getText(), TeamMemberUtils.Text.style_2_data_3_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_3_desg)).getText(), TeamMemberUtils.Text.style_2_data_3_desg);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_4_name)).getText(), TeamMemberUtils.Text.style_2_data_4_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_4_desg)).getText(), TeamMemberUtils.Text.style_2_data_4_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_1_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_2_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_3_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_4_image)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_1_si)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_2_si)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_3_si)).isDisplayed();
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_2_data_4_si)).isDisplayed();
		System.out.println("Style 2 working with all icon & image");
		
		JavascriptExecutor style_3 = (JavascriptExecutor) Driver;
		style_3.executeScript("window.scrollTo(0,3300)", "");
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_header)).getText(), TeamMemberUtils.Text.style_3_header);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_desc)).getText(), TeamMemberUtils.Text.style_3_desc);
		Actions mousehover = new Actions(Driver);
		
		WebElement style_3_data_1 = Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_box_1));
		mousehover.moveToElement(style_3_data_1).build().perform();
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_1_name)).getText(), TeamMemberUtils.Text.style_3_data_1_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_1_desg)).getText(), TeamMemberUtils.Text.style_3_data_1_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_1_si)).isDisplayed();
		
		WebElement style_3_data_2 = Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_box_2));
		mousehover.moveToElement(style_3_data_2).build().perform();
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_2_name)).getText(), TeamMemberUtils.Text.style_3_data_2_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_2_desg)).getText(), TeamMemberUtils.Text.style_3_data_2_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_2_si)).isDisplayed();
		
		WebElement style_3_data_3 = Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_box_3));
		mousehover.moveToElement(style_3_data_3).build().perform();
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_3_name)).getText(), TeamMemberUtils.Text.style_3_data_3_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_3_desg)).getText(), TeamMemberUtils.Text.style_3_data_3_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_3_si)).isDisplayed();
		
		WebElement style_3_data_4 = Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_box_4));
		mousehover.moveToElement(style_3_data_4).build().perform();
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_4_name)).getText(), TeamMemberUtils.Text.style_3_data_4_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_4_desg)).getText(), TeamMemberUtils.Text.style_3_data_4_desg);
		Driver.findElement(By.xpath(TeamMemberUtils.Locator.style_3_data_4_si)).isDisplayed();
		System.out.println("Style 3 working with all icon & image");
		System.out.println("TEAM MEMBER ALL OK");
		
		
	}
}
