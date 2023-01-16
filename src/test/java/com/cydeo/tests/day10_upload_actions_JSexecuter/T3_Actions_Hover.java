package com.cydeo.tests.day10_upload_actions_JSexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    //TC #3: Hover Test
    WebDriver driver=Driver.getDriver();
    @Test
    public void hovering_test(){

        //1. Go to https://practice.cydeo.com/hovers

        driver.get("https://practice.cydeo.com/hovers");

        //locate all images under here:
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        WebElement user1 = driver.findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = driver.findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = driver.findElement(By.xpath("//h5[.='name: user3']"));


        Actions actions=new Actions(driver);

        //2. Hover over to first image
        actions.moveToElement(img1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());


        //4. Hover over to second image
        actions.moveToElement(img2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());


        //6. Hover over to third image
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());




    }
}
