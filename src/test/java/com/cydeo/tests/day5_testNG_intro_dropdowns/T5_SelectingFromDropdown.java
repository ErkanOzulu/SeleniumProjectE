package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_SelectingFromDropdown {

    WebDriver driver;
@BeforeMethod
public void setupMethod(){

    //1. Open Chrome browser
    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //2. Go to https://practice.cydeo.com/dropdown
    driver.get("https://practice.cydeo.com/dropdown");

}
@AfterMethod
    public void tearDown(){
    //driver.close();
}

@Test
    public void selectFromDropdown(){
    //to locate state dropdown
    WebElement stateDropdownElement = driver.findElement(By.xpath("//select[@id='state']"));
    Select stateDropdown=new Select(stateDropdownElement);

    //3. Select Illinois
    stateDropdown.selectByVisibleText("Illinois");

    //4. Select Virginia

    stateDropdown.selectByValue("VA");
    //5. Select California
    stateDropdown.selectByIndex(5);
    //6. Verify final selected option is California.
    Assert.assertTrue(stateDropdown.getFirstSelectedOption().getText().equals("California"));
    //Use all Select options. (visible text, value, index)

}


}
/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */