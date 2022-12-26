package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {
    public static void main(String[] args) {
        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/checkboxes ");


        //#1- ABSOLUTE XPATH--> MAIN SYNTAX: /html/body/table/tbody/tr[2]/td/div/div/form/div[4]/button
        //#2- RELATIVE XPATH--> MAIN SYNTAX: //tagName[@attribute='value']
        //#2- RELATIVE XPATH-->  //tagName[contains(@attribute, 'value')]
        //#3- //tagName[.='text']  same as //tagName[text()='text']

        //2. Confirm checkbox #1 is NOT selected by default
        // WebElement checkbox = driver.findElement(By.locator);
        //checkbox.isSelected() --> will return true if checkbox is selected.

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        //cssSelector ---> [attribute='value']
        //cssSelector ---> tagName[attribute='value'] --> more specific way of writing css
        System.out.println("checkbox1.isSelected(), expecting false = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isSelected(),expecting true = " + checkbox2.isSelected());


        //4. Click checkbox #1 to select it.
        checkbox1.click();


        //5. Click checkbox #2 to deselect it.
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.

        System.out.println("checkbox1.isSelected(), expecting true = " + checkbox1.isSelected());
        //7. Confirm checkbox #2 is NOT selected.

        System.out.println("checkbox2.isSelected(), expecting false = " + checkbox2.isSelected());

      /*  if(checkbox1.isSelected()){
/            System.out.println("verification passed");
       }else{
           System.out.println("verification fail");
        }
       //   7. Confirm checkbox #2 is NOT selected.

       if(!checkbox2.isSelected()){
           System.out.println("verification passed");
        }else{
           System.out.println("verification fail");
      }

       */

    }
}
/*
Practice: Checkboxes
1. Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
 */