package com.cydeo.tests.day10_upload_actions_JSexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T6_JsDifferent {
    //TC #6: Scroll using JavascriptExecutor
    @Test
    public void scrolWithJS(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        WebElement home = Driver.getDriver().findElement(By.linkText("Home"));

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        for (int i = 0; i <10 ; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }

      js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()",home);

    }


    //3- Use below JavaScript method and scroll
    //a. 750 pixels down 10 times.
    //b. 750 pixels up 10 times
    //JavaScript method to use : window.scrollBy(0,0
}
