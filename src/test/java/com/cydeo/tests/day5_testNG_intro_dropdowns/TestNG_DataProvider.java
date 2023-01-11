package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_DataProvider {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test (dataProvider = "searchData")
    public void test1(String keyword, String expectedTitle){
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword+ Keys.ENTER);
        Assert.assertEquals(driver.getTitle(),expectedTitle);

        driver.quit();

   }


   @DataProvider(name = "searchData")
    public Object[][] testData(){

        return  new Object[][]{

        //column 1 (keyword)  column2(expectedTitle)
        //rows
                {"selenium", "selenium - Google Search"},
                {"java", "java - Google search"},
                {"job", "job - Google search"},
                {"cydeo", "cydeo - Google search"},
        };


    }



}
