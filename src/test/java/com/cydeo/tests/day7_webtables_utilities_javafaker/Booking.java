package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Booking {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){

        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }
    @Test
    public void multipleWindows() {
        driver.get("https://booking.com");

        //Clicking on the image

      driver.findElement(By.xpath("//div[@role='dialog']//span")).click();


        driver.findElement(By.xpath("//span[contains(.,' for your next trip')]")).click();

        //Get the handles of all the windows that are currently open using the command:
        Set<String> allWindowHandles = driver.getWindowHandles(); //which returns the set of handles.

        //Iterate all the windows
        Iterator it = allWindowHandles.iterator();

        //Storing parent ID window
        String parentID = (String) it.next();

        //Storing child ID
        String childID = (String) it.next();

        //Switching the attention of driver to child class
        driver.switchTo().window(childID);

        //Enter the destination where you want to go and type Egypt
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Egypt");

        driver.findElement(By.xpath("//td[@data-date='2023-07-12']")).click();
        driver.findElement(By.xpath("//td[@data-date='2023-07-13']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();

        //
        String actualText = driver.findElement(By.xpath("//h1[@aria-live=\"assertive\"]")).getText();
        System.out.println(actualText);
        String expectedText = "Egypt: 5,804 properties found";

        char[] ch = actualText.toCharArray();

        String gettingNumberFromTheText = "";
        for (int i = 0; i < actualText.length(); i++) {
            if (Character.isDigit(ch[i])) {
                gettingNumberFromTheText += ch[i];
            }
        }
        System.out.println("gettingNumberFromTheText = " + gettingNumberFromTheText);

        int difference = Integer.parseInt(gettingNumberFromTheText) -5034;
        System.out.println("difference = " + difference);

        //Go back to previous window
        driver.switchTo().window(parentID);
        Assert.assertEquals(actualText,expectedText);

    }

}
