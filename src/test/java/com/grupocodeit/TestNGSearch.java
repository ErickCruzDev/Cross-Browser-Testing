package com.grupocodeit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGSearch {
	private WebDriver driver = null;
	By videoLocator = By.xpath("//a[@href=\"https://www.youtube.com/channel/UCYJHp2KBXoViGp3YnKICv1Q\"]"); 
	 
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver/chromedriver.exe"); 		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com.sv/");
	  }
	  
	  @Test
	  public void googleSearch() {
		  WebElement txtSearch = driver.findElement(By.name("q"));
			txtSearch.clear();
			txtSearch.sendKeys("El Crumer");
			txtSearch.submit();
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator));
			assertTrue(driver.findElement(videoLocator).isDisplayed());
	  }
	  
	  

	  @AfterClass
	  public void afterClass() {
		//driver.quit();
	  }
	  
	  
	  
  
  

  

  

  

  

  

}
