package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    // TASK: NEW METHOD CREATION
// Method name : getDriver
// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"
    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else {
            System.out.println("Given browser type doesn't exist/or is not currently supported");
            System.out.println("Driver=null");
            return null;
        }

    }
/*
    public static WebDriver getDriver1(String browserName){

        WebDriver driver;
        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver=new FirefoxDriver();
                break;

            default:
                System.out.println("Unknown browser type "+browserName);
                driver=null;
        }
        driver.manage().window().maximize();

        return driver;
    }


 */
}
