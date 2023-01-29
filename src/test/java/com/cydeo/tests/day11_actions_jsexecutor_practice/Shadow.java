package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Shadow {


    @Test
    public void test(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://letcode.in/shadow");

        JavascriptExecutor js= (JavascriptExecutor) driver;

  //Open shadow
        //first way
       // WebElement input = (WebElement) js.executeScript("document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\").value=\"erla\""); // it will turn a Object, so I downcast to WebElement

       //js.executeScript("document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\").value=\"erla\"");

        //second way with  sendKeys
        String str="return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
        WebElement fname=(WebElement) js.executeScript(str);
        fname.sendKeys("erks");

        //Closed shadowDom
 /*
        String closed="return document.querySelector(\"my-web-component\").myRoot.querySelector(\"#lname\")";//.myRoot must be added between to querySelectors


        WebElement lname = (WebElement) js.executeScript(closed);
         lname.sendKeys("ozzz");

         // we can not direct interact, we can not after store in WebElement and use sendkeys it gives ElementNotInteractableException: element not interactable
         */

        String closed="document.querySelector(\"my-web-component\").myRoot.querySelector(\"#lname\").value='ozzz'";
        js.executeScript(closed);


        // email closed shadow dom
        WebElement closedShadow = driver.findElement(By.xpath("//*[@id=\"close-shadow\"]"));



    }

}
