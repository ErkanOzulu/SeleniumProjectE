package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_GetText_GetAttribute {

    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        //3- Verify header text is as expected:
        WebElement headerText=driver.findElement(By.tagName("h2"));
        //Expected: Registration form

        String expectedHeaderText="Registration form";
        String actualHeaderText=headerText.getText();
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("HeaderText verification is PASSED!");
        }else {
            System.out.println("HeaderText verification is FAİLED!");
        }

        //4- Locate “First name” input box
        // we are locating the web element using "name" locator
        // name attribute has "firstname" value
        //WebElement firstNameInput = driver.findElement(By.name("firstname"));

       WebElement firstElementInput=driver.findElement(By.className("form-control"));
      //  WebElement firstElementInput=driver.findElement(By.name("firstname"));
        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String actualPlaceHolder =firstElementInput.getAttribute("placeholder");
        String expectedPlaceHolder="first name";
        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder verification is PASSED!");
        }else {
            System.out.println("Placeholder verification  is FAİLED!");
        }
        driver.close();

    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
 */