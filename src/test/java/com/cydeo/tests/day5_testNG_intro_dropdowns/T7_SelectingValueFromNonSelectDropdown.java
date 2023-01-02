package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_SelectingValueFromNonSelectDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }



    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void SelectFromNonSelectDropdown(){

        //3. Click to non-select dropdown
        //4. Select Facebook from dropdown
        //5. Verify title is “Facebook - Log In or Sign Up"

       driver.findElement(By.id("dropdownMenuLink")).click();

        driver.findElement(By.xpath("//a[.='Facebook']")).click();


        Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");


    }
}
/*
TC #7: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up
 */