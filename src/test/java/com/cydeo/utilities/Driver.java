package com.cydeo.utilities;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing access to the object of this class from outside  the class
    - actually we are preventing the creation of the Driver object.--->> Driver driver=new Driver(); this is impossible out of this class
     */
    private Driver() {
    }
    /*
    we make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method
     */

    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */


    public static WebDriver getDriver() {

        if (driver == null) {
            /*
            We read our browserType from configuration.properties
            This way, we can control which browser is opened from outside our code, from configuration.properties
             */

            /*
            Depending on the browserType that will return  from configuration.properties file switch statement will determine the case, and open the matching browser
             */

            String browserType=ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }
        return driver;
    }

    public static void quitDriver(){
       if(driver!=null){
           driver.quit();
           driver=null;
       }

    }
    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }

    }



    //driver.quit() ---->>nosuchsession
    //drive.close() ---->>
    //try to create a method named closeDriver

}
