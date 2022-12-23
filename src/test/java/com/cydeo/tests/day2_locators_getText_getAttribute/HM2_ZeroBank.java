package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM2_ZeroBank {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
       // WebElement header= driver.findElement(By.className("page-header"));
        WebElement header= driver.findElement(By.tagName("h3"));
        String actualHeaderText=header.getText();
        String expectedHeaderText="Log in to ZeroBank";

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification is PASSED!");
        } else {
            System.out.println("Header text verification is FAİLED!");
        }
        driver.close();


    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */