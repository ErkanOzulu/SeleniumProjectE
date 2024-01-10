package com.cydeo.tests.day2_locators_getText_getAttribute;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM4_Home {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/inputs");

        WebElement home=driver.findElement(By.className("nav-link"));
        home.click();


        String actualHomePageTitle=driver.getTitle();
        String expectedHomePageTitle="Practice";

        if (actualHomePageTitle.equals(expectedHomePageTitle)){
            System.out.println("Home page title verification is PASSED!");
        } else {
            System.out.println("Home page title verification is FAİLED!");
        }
        driver.close();

        //3- Click to “Home” link
        //4- Verify title is as expected:
        //Expected: Practice
        //PS: Locate “Home” link using “className” locator
        // */

    }
}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “className” locator
 */