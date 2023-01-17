package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @Test(dataProvider = "search")
    public void search(String keyword, String expected){

        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.name("q")).sendKeys(keyword+ Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getTitle(),expected);


    }

    @DataProvider(name = "search")
    public Object[][] testData(){

        return new Object[][]{

                //column 1 (keyword)  column2(expectedTitle)
                //rows
                {"apple","apple - Google'da Ara"},
                {"samsung", "samsung - Google'da Ara"},
                {"Tesla", "Tesla - Google'da Ara"}

        };

    }



}
