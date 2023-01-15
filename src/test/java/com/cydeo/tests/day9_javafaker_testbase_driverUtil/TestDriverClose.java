package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDriverClose {


    @Test
    public void driverTest(){
        Driver.getDriver().get("https://google.com");

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Tesla"+ Keys.ENTER);



        Assert.assertTrue(Driver.getDriver().getTitle().contains("Tesla"));


    }
}
