package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

    //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
    //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //  2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel="Remember me on this computer";
        String actualRememberMeLabel=rememberMeLabel.getText();
        if (actualRememberMeLabel.equalsIgnoreCase(expectedRememberMeLabel)){
            System.out.println("Label verification PASSED!");
        }else {
            System.out.println("Label verification FAİLED!");
        }




        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgetPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgetPasswordLink="Forgot your password?";
        String actualForgetPasswordLink=forgetPasswordLink.getText();

        if (actualForgetPasswordLink.equals(expectedForgetPasswordLink)){

            System.out.println("Forget password link verification PASSED!");
        }else {
            System.out.println(actualForgetPasswordLink);
            System.out.println(expectedForgetPasswordLink);
            System.out.println("Forget password link verification FAİLED!");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref="forgot_password=yes";
        String actualInHrefAtributeValue=forgetPasswordLink.getAttribute("href");


        System.out.println(actualInHrefAtributeValue);

        if (actualInHrefAtributeValue.contains(expectedInHref)){

            System.out.println("HREF attribute value verification PASSED!");

        }else {
            System.out.println("HREF attribute value verification FAİLED!");
        }


    }

}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.
 */