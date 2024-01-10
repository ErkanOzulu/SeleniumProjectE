package com.cydeo.tests.day2_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM1_ETSY {
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");
        // ADD THE FOLLOWİNG LINE TO ACCEPT COOKIES ON THE POP-UP WINDOW TO BE ABLE TO MOVE FURTHER STEPS
        // driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/button")).click();

       WebElement inputSearch= driver.findElement(By.name("search_query"));
        //WebElement inputSearch= driver.findElement(By.id("global-enhancements-search-query"));
        //WebElement inputSearch= driver.findElement(By.id("search-query"));// doesn't locate the element because this ıd doesn't belong to any element only the attribute

        inputSearch.sendKeys("wooden spoon", Keys.ENTER);

        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle=driver.getTitle();  //Wooden spoon - Etsy

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification is PASSED!");
        } else {
            System.out.println("Title verification is FAİLED!");
        }
            driver.close();


    }
}
/*
TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
 */
