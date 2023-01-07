package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class T6_SelectingDateOnDropdown {

    public WebDriver driver;

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
    public void selectingDateOnDropdown()  {

        //3. Select “December 1st, 1923” and verify it is selected.

        Select yearDropdown=new Select(driver.findElement(By.id("year")));//select[@id='year']
        //Select year using : visible text

        try {
            yearDropdown.selectByVisibleText("1923");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        //TODO problem cannot solved



        //Select month using : value attribute
        Select monthDropdown=new Select(driver.findElement(By.id("month")));//select[@id='month']
        monthDropdown.selectByValue("11");


        //Select day using : index number
        Select dayDropdown=new Select(driver.findElement(By.id("day")));//select[@id='day']
        dayDropdown.selectByIndex(0);
        //verify it is selected
        Assert.assertTrue(dayDropdown.getFirstSelectedOption().getText().equals("1"));
        System.out.println(dayDropdown.getFirstSelectedOption().getText());

        Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(),"December");
        System.out.println(monthDropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(),"1923","No year 1923 in the year dropdown");
        System.out.println(yearDropdown.getFirstSelectedOption().getText());

    }

}
/*TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number

 */
