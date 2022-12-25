package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_cssSelector_getText_get_Attribute {
    public static void main(String[] args) {

    //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

    //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
    //3- Enter incorrect username into login box:
        // tagName[attribute='value']
        WebElement loginInput = driver.findElement(By.cssSelector("input[class='login-inp']"));
        loginInput.sendKeys("incorrect");

        //4- Click to `Reset password` button

        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetButton.click();

        //5- Verify “error” label is as expected
            //Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.cssSelector("div[class='errortext']"));

        String actualErrorLabelText = errorLabel.getText();
        String expectedErrorLabelText="Login or E-mail not found";

        System.out.println(actualErrorLabelText);

        if (actualErrorLabelText.equals(expectedErrorLabelText)){
            System.out.println("Error text verification is PASSED!");
        }else {
            System.out.println("Error text verification is FAİLED!");
        }




    }

}
/*
TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
 */