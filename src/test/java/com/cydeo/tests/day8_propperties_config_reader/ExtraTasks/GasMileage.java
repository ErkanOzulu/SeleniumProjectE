package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileage {
//Task #: Gas Mileage Calculator Automation Test
    //1. Add a new class GasMileageCalculatorTest
    @Test
    public void GasMileageCalculator(){
        //2. Go to https://www.calculator.net
        Driver.getDriver().get("https://www.calculator.net");
//3. Search for “gas mileage” using search box
        Driver.getDriver().findElement(By.xpath("//input[@id='calcSearchTerm']")).sendKeys("gas mileage");


//4. Click on the “Gas Mileage Calculator” link
        Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']")).click();
//5. On Next page verify:

//a. Title equals: “Gas Mileage Calculator”
        Assert.assertEquals(Driver.getDriver().getTitle(),"Gas Mileage Calculator");


//b. “Gas Mileage Calculator” label is displayed
       Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id='content']//h1")).isDisplayed());

//6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mucodreading']"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");


//7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mupodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

//8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = Driver.getDriver().findElement(By.xpath("//input[@id='mugasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");



//9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.xpath("//input[@id='mugasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");


//10. Click on Calculate button
        Driver.getDriver().findElement(By.xpath("//table[@id='metric']/tbody/tr/td//input[@value='Calculate']"))
                .click();
//11. Verify mpg value is as expected:
//Expected value:  “23.44 mpg”

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//p[@class='verybigtext']//span")).getText(),"(23.44 mpg)");


    }
}
/*
Task #: Gas Mileage Calculator Automation Test
1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link
5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed
6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mp
 */