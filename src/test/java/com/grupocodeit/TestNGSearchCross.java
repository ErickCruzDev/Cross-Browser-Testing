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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGSearchCross {
	private WebDriver driver = null;
	By videoLocator = By.xpath("//a[@href=\"https://www.youtube.com/channel/UCYJHp2KBXoViGp3YnKICv1Q\"]"); 
	 
	  
	  @BeforeClass
	  @Parameters ({"URL", "BrowserType"})
	  public void beforeClass(String url, String browserType) {
		  
		  if (browserType.equalsIgnoreCase("Chrome")) {
			  	System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver/chromedriver.exe"); 		
				driver = new ChromeDriver();
		  }else if (browserType.equalsIgnoreCase("Firefox")) {
			  System.setProperty("webdriver.gecko.driver", "./src/test/FFDriver/geckodriver.exe"); 		
			  driver = new FirefoxDriver();
		  }else if (browserType.equalsIgnoreCase("Internet Explorer")) {
		  	System.setProperty("webdriver.ie.driver", "./src/test/IEDriver/IEDriverServer.exe"); 		
			driver = new InternetExplorerDriver();			  
		  }
		  
	    driver.manage().window().maximize();
		driver.get(url);
		
		System.out.println("Opening: " + browserType);
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
