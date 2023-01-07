package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    //TC #3: Login scenario
    @Test
    public void crm_login_test() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");


        //3. Enter valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));


        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));


        //5. Click to `Log In` button
        //6. Verify title is as expected:
        //Expected: Portal

    }


}
/*
TC #3: Login scenario
1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal
USERNAME PASSWORD
helpdesk1@cybertekschool.com UserUser
Helpdesk2@cybertekschool.com UserUse
 */