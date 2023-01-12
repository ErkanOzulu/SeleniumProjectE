package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FlipCart2 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");
    }
    @Test
    public void task1(){

    }
}
/*
- Go to  https://www.flipkart.com/
- Click on the search box
- Locate t-shirts
 */