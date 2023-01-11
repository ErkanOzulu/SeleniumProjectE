package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BookingE {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1-Go to booking.com
        driver.get("https://booking.com");
    }


    @Test
    public void multipleWindow() throws InterruptedException {

        //2-Click to this image
        Thread.sleep(3000);


        try {
          driver.findElement(By.xpath("//div[@class='bh-awareness-campaign-index-banner__image-container']")).click();

        } catch (NoSuchElementException e) {

            driver.get("https://booking.com");
            driver.findElement(By.xpath("//div[@class='bh-awareness-campaign-index-banner__image-container']")).click();
        }



        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String eachHandle : allWindowHandles) {
            driver.switchTo().window(eachHandle);

           if (driver.getTitle().equals(" The World's Best Vacation Rentals | Booking.com")){
               break;
           }

        }

        //3- Add your destination country ex: Egypt
        WebElement destinationInput = driver.findElement(By.xpath("//input[@aria-label='Type your destination']"));
        destinationInput.click();
        destinationInput.sendKeys("Egypt");


        //4-Click the date 2 Feb 2023

        driver.findElement(By.xpath("//div[contains(@class, 'checkin')]")).click();
        driver.findElement(By.xpath("//td[@data-date='2023-02-02']")).click();


        //5-Click 3 Feb 2023
        driver.findElement(By.xpath("//td[@data-date='2023-02-03']"));
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        //7-Check if you found the exact text

        //Egypt: 5,034 properties found


        WebElement headResult = driver.findElement(By.xpath("//h1[@class='e1f827110f d3a14d00da']"));

        String actualResult=headResult.getText();
        String expectedResult="Egypt: 5,034 properties found";

        Assert.assertEquals(actualResult,expectedResult);


    }

}
