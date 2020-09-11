package com.grupocodeit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleTest {
	private WebDriver driver = null;
	By videoLocator = By.xpath("//a[@href=\"https://www.youtube.com/channel/UCYJHp2KBXoViGp3YnKICv1Q\"]"); 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver/chromedriver.exe"); 		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.sv/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.clear();
		txtSearch.sendKeys("El Crumer");
		txtSearch.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator));
		assertTrue(driver.findElement(videoLocator).isDisplayed());
		
	}

}
