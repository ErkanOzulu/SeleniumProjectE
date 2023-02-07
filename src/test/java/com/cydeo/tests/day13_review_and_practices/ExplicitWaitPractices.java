package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod() {

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();


    }

    @Test
    public void remove_button_test() {
        //TC #2: Explicit wait practice

        //3- Click to “Remove” button

        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibtyOf(dynamicControlsPage.loadingBar);

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //5- Verify:
        // a. Checkbox is not displayed

        try {

            //assertFalse method will pass the test if the boolean value returned is: false
            Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());

        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);

        }

        //b. “It’s gone!” message is displayed.


        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));


        //NOTE: FOLLOW POM

    }


}
