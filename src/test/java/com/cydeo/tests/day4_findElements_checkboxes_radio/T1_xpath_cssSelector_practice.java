package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {


        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //Locate homeLink using cssSelector, class value
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate homeLink using cssSelector syntax #2
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate homeLink using cssSelector, href value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));



        //b. “Forgot password” header
        //Locate header using cssSelector: locate parent element and move down to h2
        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example>h2"));

        //Locate header using xpath, and using web elements text "Forgot Password"
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement header_ex3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text

        WebElement labelEmail_ex1 = driver.findElement(By.cssSelector("label[for='email']"));

        WebElement labelEmail_ex2 = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

        //Locate inputBox using xpath contains method

        //tagName[contains(@attribute,'value')]

        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z' )]"));
        WebElement inputBox_ex3= driver.findElement(By.cssSelector("input[type='text']"));


        //e. “Retrieve password” button

        WebElement retrieveButton_ex1 = driver.findElement(By.xpath("//button[@id='form_submit']"));
        WebElement retrieveButton_ex2 = driver.findElement(By.xpath("//button[@class='radius']"));


        //f. “Powered by Cydeo text

        WebElement powerdByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println(powerdByCydeoText.getText());

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("labelEmail_ex1.isDisplayed() = " + labelEmail_ex1.isDisplayed());
        System.out.println("inputBox_ex1.isDisplayed() = " + inputBox_ex1.isDisplayed());
        System.out.println("retrieveButton_ex1.isDisplayed() = " + retrieveButton_ex1.isDisplayed());
        System.out.println("powerdByCydeoText.isDisplayed() = " + powerdByCydeoText.isDisplayed());

    }

}
/*
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
 */