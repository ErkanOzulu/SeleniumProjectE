package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SmartBear {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void smartBear3(){ //TC#3: Smartbear software order verification

       // SmartBearUtils.loginToSmartBear("chrome");
        //1. Open browser and login to Smartbear software

        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //2. Click on View all orders

       driver.findElement(By.xpath("//a[.='View all orders']")).click();


        //3. Verify Susan McLaren has order on date “01/05/2010”
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[.='Susan McLaren']/..//td[5]")).getText(),"01/05/2010");
    }
}
