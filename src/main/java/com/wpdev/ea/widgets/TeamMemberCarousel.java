package com.wpdev.ea.widgets;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.wpdev.ea.utils.DriverManager;
import com.wpdev.ea.utils.FlipBoxUtils;
import com.wpdev.ea.utils.TeamMemberCarouselUtils;
import com.wpdev.ea.utils.config;

public class TeamMemberCarousel {
	
	@Test
	public static void TeamMemberCarousel() throws InterruptedException {
		WebDriver Driver = DriverManager.Driver;
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().deleteAllCookies();
		Driver.get(config.base_url + "/team-members-carousel/");
		System.out.println("Now Testing Team Member Page");

		assertEquals(Driver.getTitle(), TeamMemberCarouselUtils.Text.page_title);
		Driver.manage().window().maximize();
		assertEquals(Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.widget_title)).getText(),
				TeamMemberCarouselUtils.Text.widget_title);
		assertEquals(Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.widget_desc)).getText(),
				TeamMemberCarouselUtils.Text.widget_desc);
		Thread.sleep(2000);
		Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.doc_link)).click();
		ArrayList<String> tabs2 = new ArrayList<String>(Driver.getWindowHandles());
		Driver.switchTo().window(tabs2.get(1));
		assertEquals(Driver.getTitle(), TeamMemberCarouselUtils.Text.doc_page_title);
		Driver.close();
		Driver.switchTo().window(tabs2.get(0));
		Driver.findElement(By.className("nx-close")).click();
		
		JavascriptExecutor style_1 = (JavascriptExecutor) Driver;
		style_1.executeScript("window.scrollBy(0,1040)", "");
		Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.style_1_arrow)).click();
		assertEquals(Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.style_1_data_1_name)).getText(),TeamMemberCarouselUtils.Text.style_1_data_1_name);
		assertEquals(Driver.findElement(By.xpath(TeamMemberCarouselUtils.Locator.style_1_data_1_desg)).getText(),TeamMemberCarouselUtils.Text.style_1_data_1_desg);
	}

}
