package com.cydeo.base;

import org.openqa.selenium.WebDriver;

public class TestBase {

    public WebDriver driver;

    /*

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


     */

}
