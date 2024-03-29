package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Radiobutton {
    public static void main(String[] args) throws InterruptedException {

//1. Open Chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
//2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
//3. Click to “Hockey” radio button
        WebElement hockeyRadioBttn = driver.findElement(By.xpath("//input[@id='hockey']"));

       Thread.sleep(2000);

       hockeyRadioBttn.click();
//4. Verify “Hockey” radio button is selected after clicking.
        //System.out.println("hockeyRadioBttn.isSelected() = " + hockeyRadioBttn.isSelected());

        if (hockeyRadioBttn.isSelected()){
            System.out.println("Button is selected.Verification Passed!");

        }else{
            System.out.println("Button is not selected.Verification FAILED!");
        }


//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


    }
}
/*
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */