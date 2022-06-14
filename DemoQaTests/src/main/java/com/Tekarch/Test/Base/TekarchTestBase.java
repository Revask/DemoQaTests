package com.Tekarch.Test.Base;

import java.time.Duration;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;


public class TekarchTestBase {
	protected static WebDriver driver = null; // creating the webdriver instance
	protected static WebElement element = null;

@Test

public static void getDriver(String choice)
	{
		choice = choice.toLowerCase();
		switch(choice)
		{
			case "chrome" :
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case  "edge" :
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			case "firefox" :
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		}
	
	}
	@Test
	
	public static void gotoUrl(String url)
	{
		driver.get(url);
	}
	public static void locate(String s1,String s2)
	{
		s1 = s1.toLowerCase();
		switch(s1)
		{
			case "id":
			{
				element = driver.findElement(By.id(s2));
				break;
			}
			case "classname":
			{
				element = driver.findElement(By.className(s2));
				break;
			}
			case "tagname":
			{
				element = driver.findElement(By.tagName(s2));
				break;
			}
			case "xpath":
			{
				element = driver.findElement(By.xpath(s2));
				break;
			}	
			case "linktext":
			{
				element = driver.findElement(By.linkText(s2));
				break;
			}	
			case "partiallinktext":
			{
				element = driver.findElement(By.partialLinkText(s2));
				break;
			}	
			case "name":
			{
				element = driver.findElement(By.name(s2));
				break;
			}
			case "cssselector":
			{
				element = driver.findElement(By.cssSelector(s2));
				break;
			}
			}
		}
	
	
	public static void setWaitExplicit()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
	}
	public static void setWaitFluent()
	{
		FluentWait fwait = new FluentWait(driver).withTimeout(Duration.ofMillis(50))
				                                 .pollingEvery(Duration.ofMillis(50)) ;
				                            
	}
	public static void setDropDown(WebElement e,int i)
	{
		Select list = new Select(e);
		list.selectByIndex(i);
	}
	public static void setDropDown(WebElement e,String s)
	{
		Select list = new Select(e);
		list.selectByVisibleText(s);
	}
	public static void switchToAlertBox()
	{
	Alert alert = driver.switchTo().alert();
	}
}
