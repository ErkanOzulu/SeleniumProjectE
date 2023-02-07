package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

/*
In this class only general utility methods that are NOT related to some specific page.
 */
public class BrowserUtils {
    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
    - When method is called, it should switch window and verify title.

        Method info:
    • Name: switchWindowAndVerify
    • Return type: void

     This method accepts 3 arguments.
    • Arg1: WebDriver
    • Arg2: String expectedInUrl : for verify if the url contains given String.
        -If conditions matches, will break loop
    • Arg3: String expectedTitle : to be compared against actualTitle

     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL,String expectedInTitle ){

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current Url(): " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “expectedInTitle”

        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }



    /*
    This method accepts a String "expectedTitle" and Asserts if it is true

     */

    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void waitForInvisibtyOf(WebElement webElement){

        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }





}
