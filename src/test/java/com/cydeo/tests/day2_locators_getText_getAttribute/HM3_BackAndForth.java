package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM3_BackAndForth {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement gmailTRight = driver.findElement(By.linkText("Gmail"));
        gmailTRight.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";
        if (actualTitle.contains(expectedTitle)) {

            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAİLED!");
        }

        driver.navigate().back();
        actualTitle = driver.getTitle();
        expectedTitle = "Google";

        if (actualTitle.equals(expectedTitle)) {

            System.out.println("Previous Title verification is PASSED!");
        } else {
            System.out.println("Previous verification is FAİLED!");
        }
        driver.close();
    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */