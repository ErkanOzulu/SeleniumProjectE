package com.cydeo.tests.day8_propperties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make set up
        //Go to: https://practice.cydeo.com/web-tables
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_name_verify_test() {
        //Locate the cell that has Bob Martin text in it.

        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());


        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();
        Assert.assertEquals(actualBobName, expectedBobName);


        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021


        //alternative locator to boMartinDateCell //td[.='Bob Martin']/..//td[5]
        WebElement bobMartinDateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/..//td[5]"));//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]


        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinDateCell.getText();

        Assert.assertEquals(expectedBobDate, actualBobDate);



    }
    //We use the utility method we created.
    @Test
    public void tets2(){
        String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate1);
    }


    ///Using WebTableUtils.orderVerify(); method
    @Test
    public void test3(){
    WebTableUtils.orderVerify(driver,"Bart Fisher","01/16/2021");

    }

}
/*
TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */