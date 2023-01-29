package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_staleElementReferenceException {
    public static void main(String[] args) {

        //1- Open a chrome browser

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));////a[text()='CYDEO'] or //a[.='CYDEO']
        System.out.println("cydeoLink.isSelected() = " + cydeoLink.isDisplayed());


        //4- Refresh the page.

        driver.navigate().refresh();

        //We are refreshing the web element reference by re-assigning (re-locating) the web element
        cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        //5- Verify it is displayed, again.

        System.out.println("cydeoLink.isSelected() = " + cydeoLink.isDisplayed());

        //todo how to handle staleElementReferenceException
    }
}
/*TC #6: StaleElementReferenceException Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate “CYDEO” link, verify it is displayed.
4- Refresh the page.
5- Verify it is displayed, again.
This is a simple StaleElementReferenceException to understand what is
this exception and how to handle it
*/
