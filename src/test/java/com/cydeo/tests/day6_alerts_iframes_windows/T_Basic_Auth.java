package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T_Basic_Auth {

    @Test
    public void test() {

        WebDriver driver = Driver.getDriver();

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.findElement(By.linkText("Basic Auth")).click();

        //todo

        // Explanations:  https://www.browserstack.com/docs/automate/selenium/basic-http-authentication#Selenium_4_W3C
        //https://www.youtube.com/watch?v=fGAggGbvtw4

        //https://medium.com/automationmaster/handling-basic-authentication-window-with-selenium-webdriver-and-devtools-api-ec716965fdb6





    }

}
