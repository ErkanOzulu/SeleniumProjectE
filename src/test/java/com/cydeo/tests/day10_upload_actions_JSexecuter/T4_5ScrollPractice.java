package com.cydeo.tests.day10_upload_actions_JSexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_5ScrollPractice {
    //TC #4: Scroll practice
    @Test
    public void scrollDown() {


        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());

        //4- Scroll using Actions class “moveTo(element)” method
        WebElement cydeo = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        actions.moveToElement(cydeo).perform();
        BrowserUtils.sleep(3);

        // Scroll Up using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();


        // Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        //TODO there is a problem

        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        //actions.sendKeys(Keys.HOME).perform();

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();


    }
}
