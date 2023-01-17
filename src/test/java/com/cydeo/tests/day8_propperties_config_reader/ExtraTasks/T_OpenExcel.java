package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;


import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T_OpenExcel {

    //TC #1: Checking the number of links on the page
    @Test
    public void open1(){

        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get("https://www.openxcell.com");
        //3. Count the number of the links on the page and verify
        Assert.assertEquals(Driver.getDriver().findElements(By.tagName("a")).size(),"332");
        //Expected: 332
    }
    @Test
    public void open2(){//   TC #2: Printing out the texts of the links on the page
       //1. Open Chrome browser
        //        2. Go to https://www.openxcell.com

        Driver.getDriver().get("https://www.openxcell.com");

        //3. Print out all of the texts of the links on the page
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    @Test
    public void open3(){//TC #3: Counting the number of links that does not have text


        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get("https://www.openxcell.com");
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        int count=0;
        for (WebElement link : links) {
            if (link.getText().isBlank()){
                count++;
            }
        }
        System.out.println(count);

        //3. Count the number of links that does not have text and verify
        //Expected: 109
        Assert.assertEquals(count,"109");
    }
}

/*
TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332
TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page
TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109
NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
VERIFICATION.
 */

