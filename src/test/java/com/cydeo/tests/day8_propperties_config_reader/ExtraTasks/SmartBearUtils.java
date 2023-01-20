package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public  class SmartBearUtils {

    public static WebDriver driver;


    @Test
    public void smart(){
        //I used a method called loginToSmartBear to open to website
      loginToSmartBear("chrome");
    }
/*
    private void loginToSmartBear(WebDriver driver) {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }


 */

    public static WebDriver loginToSmartBear(String WebDriverType) {

        driver = WebDriverFactory.getDriver(WebDriverType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        return driver;
    }





/*
    public static void loginToSmartBear(String WebDriverType) {

        driver = WebDriverFactory.getDriver(WebDriverType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }


 */



}

    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter







