package com.cydeo.tests.day8_propperties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Discord_MultipleWindows {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }
    @Test
    public void multipleWindows(){


        //Locating CLICK HERE link
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));

        //Opening a new window
        clickHere.click();

        //Get the handles of all the windows that are currently open using the command:
        Set<String> allWindowHandles = driver.getWindowHandles(); //which returns the set of handles.

        //Iterate all the windows
        System.out.println(allWindowHandles);
        Iterator it = allWindowHandles.iterator();

        //Storing parent ID window
        String parentID = (String) it.next();

        //Storing child ID
        String childID = (String) it.next();

        //Switching the attention of driver to child class
        driver.switchTo().window(childID);

        //Finding the header text and printing out
        String getText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("getText = " + getText);
    }
}
