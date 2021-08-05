package com.java.myntra;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.config.Configs;

public class PurchasingTheProduct extends Configs{
	@Test
	public void GoingIntoBag() throws InterruptedException {
	Thread.sleep(3000);	
	driver.findElement(By.xpath("//span[contains(text(),'Bag')]")).click();
	
	}
	@Test(dependsOnMethods ="GoingIntoBag")
	public void FillingInformation() throws InterruptedException, AWTException {
	Thread.sleep(2000);
	Actions actions = new Actions(driver);
	Robot robot = new Robot();
	robot.mouseMove(50,50);
	actions.click().build().perform();
	driver.findElement(By.xpath("//div[contains(text(),'Place Order')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("name")).sendKeys("sumanth");
	driver.findElement(By.id("mobile")).sendKeys("8331885819");
	driver.findElement(By.id("pincode")).sendKeys("524002");
	driver.findElement(By.id("streetAddress")).sendKeys("28/2/464,satyanarayana puram");
	driver.findElement(By.id("locality")).sendKeys("Stonehousepet");
	driver.findElement(By.xpath("//div[contains(text(),'ADD ADDRESS')]")).click();
	}
	@Test(dependsOnMethods = {"GoingIntoBag","FillingInformation"})
	public void ConfirimigTheOrder() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='placeOrderButton']")).click();
	Thread.sleep(7000);
	try {
	driver.findElement(By.id("action-cod")).submit();
	}catch(NoSuchElementException e)
	{
		System.out.println("The element is not found");
	}
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
