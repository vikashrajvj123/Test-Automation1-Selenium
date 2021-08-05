package com.java.myntra;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.config.Configs;

public class ForAnotherBrowser extends Configs {
	@Test
	public void ForDifferentBrowser() throws InterruptedException {
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//span[contains(text(),'Bag')]")).click();
		Thread.sleep(2000);
		try {
		driver.findElement(By.xpath("//div[contains(text(),'Place Order')]")).click();
		}catch(ElementNotVisibleException e)
		{
			System.out.println("The element is not found");
		}
		driver.findElement(By.id("placeOrderButton")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("action-cod")).submit();
		Thread.sleep(7000);
		String conform=driver.findElement(By.xpath("//div[contains(text(),'Order confirmed')]")).getText();
		String acutual="Order confirmed";
		//if(conform.equalsIgnoreCase(acutual))
		//{
		//	System.out.println("The order is done");
		//}
		Assert.assertEquals(conform,acutual);
		System.out.println("The order is done");
		driver.findElement(By.xpath("//div[contains(text(),'VIEW ORDER')]")).click();
		}
	}


