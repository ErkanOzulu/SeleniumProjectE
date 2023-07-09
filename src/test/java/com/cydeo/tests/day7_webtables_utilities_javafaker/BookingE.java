package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
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
        driver.findElement(By.xpath("//div[@role='dialog']//span")).click();

        /*
        boolean displayed = false;
        do {


        try {
            WebElement element = driver.findElement(By.xpath("//div[@class='bh-awareness-campaign-index-banner__image-container']"));
             displayed = element.isDisplayed();
                 element.click();

        } catch (NoSuchElementException e) {

            //driver.get("https://booking.com");
            driver.findElement(By.xpath("//div[@class='bh-awareness-campaign-index-banner__image-container']")).click();
        }

    }while (!displayed);

         */

        WebElement picture;
        //do{
            //driver.navigate().refresh();
            try {
                picture = driver.findElement(By.xpath("//a[@target='_isblank']"));
                System.out.println("try executed");
                picture.click();
            } catch (NoSuchElementException e) {
                picture = driver.findElement(By.xpath("//a[@class='fc63351294 b8e920e088']"));
                System.out.println("catch executed");
                picture.click();
            } //}while (!picture.isDisplayed());





        Set<String> allWindowHandles = driver.getWindowHandles();

            /*
        for (String eachHandle : allWindowHandles) {
            driver.switchTo().window(eachHandle);

           if (driver.getTitle().equals(" The World's Best Vacation Rentals | Booking.com")){
               break;
           }

        }

             */

        Iterator it=allWindowHandles.iterator();
        String parent =(String) it.next();
        String child=(String)it.next();
        driver.switchTo().window(child);

        //3- Add your destination country ex: Egypt
        WebElement destinationInput = driver.findElement(By.xpath("//input[@aria-label='Type your destination']"));
        destinationInput.click();
        destinationInput.sendKeys("Egypt");


        //4-Click the date 2 Feb 2023

        driver.findElement(By.xpath("//div[contains(@class, 'checkin')]")).click();
        driver.findElement(By.xpath("//td[@data-date='2023-07-12']")).click();


        //5-Click 3 Feb 2023
        driver.findElement(By.xpath("//td[@data-date='2023-07-13']"));
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        //7-Check if you found the exact text

        //Egypt: 5,034 properties found


        WebElement headResult = driver.findElement(By.xpath("//h1[@aria-live=\"assertive\"]"));

        String actualResult=headResult.getText();
        String expectedResult="Egypt: 5,034 properties found";
        char[] chars = actualResult.toCharArray();

        String  textNumber="";

        for (char each : chars) {
            if (Character.isDigit(each)){
                textNumber+=each;

            }
        }
        int number=Integer.parseInt(textNumber);


        System.out.println(number);
        int difference=number-5034;
        System.out.println(difference);
        driver.switchTo().window(parent);

        Assert.assertEquals(actualResult,expectedResult);


    }

}
