package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google_9Points {


    @Test
    public void google() {
        WebDriver driver = Driver.getDriver();

        driver.get("https://google.com");
        driver.findElement(By.xpath("//a[@class='gb_e']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));

        driver.findElement(By.xpath("//ul[@class='LVal7b u4RcUd']//li[14]")).click();

        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(),"Google Photos");


    }


}
