package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_SelectingFromMultipleSelectDropdown {

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
    public void SelectingFromMultipleSelectDropdown(){
        //3. Select all the options from multiple select dropdown.
        Select multipleSelectDropdown=new Select(driver.findElement(By.name("Languages")));

        System.out.println("multipleSelectDropdown.isMultiple() = " + multipleSelectDropdown.isMultiple());
        multipleSelectDropdown.selectByIndex(0);
        multipleSelectDropdown.selectByIndex(1);
        multipleSelectDropdown.selectByIndex(2);
        multipleSelectDropdown.selectByIndex(3);
        multipleSelectDropdown.selectByIndex(4);
        multipleSelectDropdown.selectByIndex(5);


        //4. Print out all selected values.

        List<WebElement> allSelectedOptions = multipleSelectDropdown.getAllSelectedOptions();

        for (WebElement each : allSelectedOptions) {
            System.out.println(each.getText());
        }


        //5. Deselect all values
        multipleSelectDropdown.deselectAll();


    }

//TC #8: Selecting value from multiple select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Select all the options from multiple select dropdown.
//4. Print out all selected values.
//5. Deselect all values


}
