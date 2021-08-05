package com.java.myntra;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.config.Configs;

public class ChoosingTheProduct extends Configs{
	
	@Test
	public void search() throws InterruptedException {
        
        Thread.sleep(4000);
        // searching for a product
        try {
        driver.findElement(By.className("desktop-searchBar")).sendKeys("Louis Shirts");
        }catch(ElementNotVisibleException e)
        {
        	System.out.println("The element is not visible at the point");
        }
        driver.findElement(By.className("desktop-searchBar")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
	}
	@Test(dependsOnMethods ="search")
	public void selectfirstproduct() throws InterruptedException {
		String  Expected = "WISHLISTED";
        Thread.sleep(4000);
        // selecting the desired product
        String mainWindow = driver.getWindowHandle();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='results-base']//li[2]//a/div[1]//div//div//div//picture//img"))
                .click();
        String first = driver.findElement(By.xpath("//*[@class='results-base']//li[2]//a/div[1]//div//div//div//picture//img")).getAttribute("title");
//System.out.println(first);    
//        opening in new window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i1 = windows.iterator();
        while (i1.hasNext()) {
            String childWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
//                validating if correct product was opened or not
                Thread.sleep(4000);
                String ExpFirstOne= driver.findElement(By.xpath("//*[@class='pdp-title']")).getText();
                String ExpFirstSec= driver.findElement(By.xpath("//*[@class='pdp-name']")).getText();
                String ExpFirst = ExpFirstOne + " " + ExpFirstSec;
                //if(first.equals(ExpFirst)) {
                //    System.out.println("Correct product opened ");
                //}
                //else {
                //    System.out.println("Wrong product was opened");
                //}
                Assert.assertEquals(first,ExpFirst);
                
                	System.out.println("correct product open");
                
//                adding to wishlist
                driver.findElement(By.xpath(
                        "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[2]"))
                        .click();
//                Check if product is successfully Wishlisted or not
                Thread.sleep(3000);
                String check = driver.findElement(By.xpath(
                        "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[2]"))
                        .getText();
                System.out.println(check);
                //if (check.equals(Expected)) {
                //    System.out.println("Product Wishlisted Successfully");
                //} else {
                //    System.out.println("unsuccessful");
                //}
                Assert.assertEquals(check,Expected);
                System.out.println("Product Whishlisted Successfully");
//                return to previous page

 

                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
	}
	@Test(dependsOnMethods = {"search","selectfirstproduct"} )
	public void selectsecondproduct() throws InterruptedException {
		String  Expected = "WISHLISTED";
        Thread.sleep(4000);

 

        // searching for second product
        driver
                .findElement(By.xpath(
                        "//*[@class='results-base']//li[5]//a[1]//div[1]//div[1]//div[1]//div[1]//picture[1]//img[1]"))
                .click();
        Thread.sleep(3000);
        String second = driver.findElement(By.xpath("//*[@class='results-base']//li[5]//a[1]//div[1]//div[1]//div[1]//div[1]//picture[1]//img[1]")).getAttribute("title");

 

//        moving to new window
        String mainWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        Set<String> windows2 = driver.getWindowHandles();
        Iterator<String> i2 = windows2.iterator();
        while (i2.hasNext()) {
            String childWindownew = i2.next();
            if (!mainWindow.equalsIgnoreCase(childWindownew)) {
                driver.switchTo().window(childWindownew);
//                validating if correct product was opened or not
                String ExpSecondOne= driver.findElement(By.xpath("//*[@class='pdp-title']")).getText();
                String ExpSecondSec= driver.findElement(By.xpath("//*[@class='pdp-name']")).getText();
                String ExpSecond = ExpSecondOne + " " + ExpSecondSec;
                //if(second.equals(ExpSecond)) {
                //    System.out.println("Correct product opened ");
                //}
                //else {
                //    System.out.println("Wrong product was opened");
                //}
//                adding to wishlist product 2
                Assert.assertEquals(second,ExpSecond);
                System.out.println("Correct Product Opened");
                driver.findElement(By.xpath(
                        "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[2]"))
                        .click();
//                Check if the second product is wishlisted or not
                Thread.sleep(3000);
                String check2 = driver.findElement(By.xpath(
                        "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[2]"))
                        .getText();
                System.out.println(check2);
                //if (check2.equals(Expected)) {
                //   System.out.println("Product two Wishlisted Successfully");
                //} else {
                //    System.out.println("unsuccessful");
                //} 
                Assert.assertEquals(check2,Expected);
                System.out.println("Product two Wishlisted Successfully");
                
//                return to previous page

 

                driver.close();

 

            }
        }
	
        driver.switchTo().window(mainWindow);
	}
    
    


}
 











