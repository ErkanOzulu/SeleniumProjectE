package com.cydeo.tests.day6_alerts_iframes_windows;

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
        //2. Go to website: http://practice.cydeo.com/javascript_alerts



    }
    @Test
    public void multipleWindows() {
        driver.get("https://booking.com");

        //Clicking on the image
        driver.findElement(By.xpath("//div[@aria-label ='Find homes for your next trip']")).click();

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

        driver.findElement(By.xpath("//td[@data-date='2023-02-02']")).click();
        driver.findElement(By.xpath("//td[@data-date='2023-02-03']")).click();
        driver.findElement(By.xpath("//button[@data-sb-id='main']")).click();

        //
        String foundText = driver.findElement(By.xpath("//h1[@class='e1f827110f d3a14d00da']")).getText();
        String actualText = "Egypt: 5,034 properties found";
        Assert.assertEquals(foundText, actualText);
        char[] ch = actualText.toCharArray();

        String gettingNumberFromTheText = "";
        for (int i = 0; i < foundText.length(); i++) {
            if (Character.isDigit(ch[i])) {
                gettingNumberFromTheText += ch[i];
            }
        }
        System.out.println("gettingNumberFromTheText = " + gettingNumberFromTheText);

        int difference = Integer.parseInt(gettingNumberFromTheText) -5034;
        System.out.println("difference = " + difference);
        //Go back to previous window
        driver.switchTo().window(parentID);
    }

}
