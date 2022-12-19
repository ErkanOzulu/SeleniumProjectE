package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_FacebookIncorrect {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        WebElement inputMail = driver.findElement(By.name("email"));
        inputMail.sendKeys("sdfsdfl");
        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("A123124", Keys.ENTER);
        Thread.sleep(2000);


        String actualTitle = driver.getTitle(); //Log in to Facebook
        String expectedTitle = "Log into Facebook";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED!");
        }else{
            System.out.println("Title verification is FAİLED!");
        }
        driver.close();


    }
}
/*
TC #2: Facebook incorrect login title verification
1.  Open Chrome browser
2.  Go to https://www.facebook.com
3.  Enter incorrect username
4.  Enter incorrect password
5.  Verify title changed to:
Expected: “Log into Facebook”

 */