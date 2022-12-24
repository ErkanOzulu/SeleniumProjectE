package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {
        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");


        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //                  tagName[attribute='value']

        //locating reset password button using class attribute and its value
        //WebElement resetButton = driver.findElement(By.cssSelector("button[class='login-btn']"));

        //locating reset password button using value attribute and its value
        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));


        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password

        String expectedButtonText = "Reset password";
        String actualButtonText = resetButton.getText();
        System.out.println("actualButtonText = " + actualButtonText);

        if (actualButtonText.equals(expectedButtonText)) {
            System.out.println("Reset button verification is PASSED!");
        } else {
            System.out.println("Reset button verification is FAİLED!");
        }


    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */