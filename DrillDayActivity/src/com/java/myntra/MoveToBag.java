package com.java.myntra;


import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.config.Configs;

public class MoveToBag extends Configs{
	@Test
	public void OpeningWishlist()
	{
		driver.findElement(By.xpath("//header/div[2]/div[2]/a[1]/span[1]")).click();
		// move to bag
		
		driver.findElement(By.xpath(
		"//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/div[1]/div[2]/div[2]/span[1]/a[1]"))
		.click();
		// select size

		driver.findElement(By.xpath(
		"//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"))
		.click();
	}
	@Test(dependsOnMethods ="OpeningWishlist")
	public void AddingBag() throws InterruptedException, AWTException {
       //Done
driver.findElement(By.xpath("//div[contains(text(),'Done')]")).click();

		
		
		driver.findElement(By.xpath("//span[contains(text(),'Bag')]")).click();
		
		String act=driver.getTitle();
		Actions actions = new Actions(driver);
		
		System.out.println(act);
		String real="SHOPPING BAG";
//		if(act.equals(real))
//		{
//			System.out.println("ok");
//		}
//		else {
//			System.out.println("why");
//		}
		Assert.assertEquals(act,real);
		System.out.println("Move To Bag Successfully");
		Robot robot = new Robot();
		robot.mouseMove(100,100);
		actions.click().build().perform();
		driver.findElement(By.className("logo-inline")).click();

}

}

