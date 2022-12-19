package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitle {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        String actualTitle = driver.getTitle(); //Facebook – log in or sign up

        String expectedTitle = "Facebook - Log In or Sign Up";

        if (actualTitle.equals(expectedTitle)) {

            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAİLED!");
        }
        driver.close();
    }
}
/*
TC #1: Facebook title verification
1.  Open Chrome browser
2.  Go to https://www.facebook.com
3.  Verify title:
Expected: “Facebook - Log In or Sign Up”
 */