package com.cydeo.tests.day10_upload_actions_JSexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_upload_Practice {

    @Test
    public void upload_test() {
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\Data\\OneDrive\\Masaüstü\\toPreventChromeFromRunningTest.png";



        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));//instead of choosing a file and clicking the chosen file
        fileUpload.sendKeys(path);//important point is we only send path of the file.We don't click choose file


        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadHeader.isDisplayed());


    }


}
