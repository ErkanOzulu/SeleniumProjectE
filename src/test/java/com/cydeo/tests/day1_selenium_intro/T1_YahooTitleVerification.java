package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_YahooTitleVerification {

    public static void main(String[] args) {
        //TC #1: Yahoo Title Verification
            //do set up for browser driver
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        WebDriver driver=new ChromeDriver();

        //Make our page fullscreen
        driver.manage().window().maximize();

        //2. Go to https://www.yahoo.com

        driver.get("https://www.yahoo.com");

        //3. Verify title:
        //Expected: Yahoo

        String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        //actual title comes from the browser
        String actualTitle=driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title is as expected.Verification PASSED!");

        }else {
            System.out.println("Title is NOT as expected.Verification FAILED!");
        }


    }

}
/*
TC #1: Yahoo Title Verification

1. Open Chrome browser

2. Go to https://www.yahoo.com

3. Verify title:
Expected: Yahoo
 */
