package com.java.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Configs {
	public static String Browser="chrome";
	public static WebDriver driver=null;
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String Browser) throws InterruptedException
	{
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\vikashrs\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vikashrs\\Downloads\\geckodriver-v0.29.1-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\vikashrs\\Downloads\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("The Browser is not Supported");
		}
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/login/password?referer=https%3A%2F%2Fwww.myntra.com%2F&show=false");
		driver.findElement(By.id("mobileNumberPass")).sendKeys("8522064210");
		driver.findElement(By.xpath("//input[@id='']")).sendKeys("Asd@12345");
		driver.findElement(By.xpath("//button[@id='']")).click();
		Thread.sleep(3000);
	}
	@AfterTest
	public void LogOut() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Logout')]")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
