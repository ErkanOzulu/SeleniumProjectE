package com.cydeo.tests.day14_dryRun_tags_htmlReport2;

import com.cydeo.pages.DemoqaPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracticesDemoqa {


    @Test
    public void resizeable(){
        Driver.getDriver().get("https://demoqa.com/");



        DemoqaPage practicesPage=new DemoqaPage();
        // practicesPage.interactionsTab.click();


        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(practicesPage.interactionsTab)).click();

        //   practicesPage.resizableTab.click();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", practicesPage.resizableTab);

        BrowserUtils.sleep(2);



        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(practicesPage.resizeBox1Handle).moveByOffset(100,100).pause(1).moveByOffset(200,0).release().perform();
        js.executeScript("arguments[0].scrollIntoView(true)",practicesPage.resizeBox2Handle);


        actions.clickAndHold(practicesPage.resizeBox2Handle).moveByOffset(200,200).release().perform();


        System.out.println("practicesPage.resizableTab.getLocation() = " + practicesPage.resizableTab.getLocation());


    }

}
