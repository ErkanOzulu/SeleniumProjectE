package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cydeo.tests.day8_propperties_config_reader.ExtraTasks.SmartBearUtils.driver;

public class SmartBearWithMethod {

    @Test
    public void autoLogin(){

     SmartBearUtils.loginToSmartBear("chrome");

        //2. Click on View all orders

        driver.findElement(By.xpath("//a[.='View all orders']")).click();

        System.out.println(driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[.='Susan McLaren']/..//td[5]")).getText());
        //3. Verify Susan McLaren has order on date “01/05/2010”
        Assert.assertEquals(driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[.='Susan McLaren']/..//td[5]")).getText(),"01/05/2010");



    }





}
