package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FlipCart1  {

WebDriver driver;
        @BeforeMethod
        public void setupMethod() {

            //1. Open browser
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.flipkart.com/");

            }


    @Test
    public void flip1()  {


        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();


        WebElement electronics = driver.findElement(By.xpath("//div[@class='eFQ30H'][4]"));

        System.out.println(electronics.getText());


        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).pause(2000).perform();

        WebElement audio = driver.findElement(By.xpath("//div[@class='eFQ30H'][4]//div[@class='_1psGvi SLyWEo']/div[2]/div[2]/div/div/div[2]/a[3]"));
        audio.click();
        System.out.println(driver.getTitle());
        //  WebElement audio = driver.findElement(By.xpath("//div[@class='eFQ30H'][4]//div[2]//div[2]//div[2]//div//div//div[1]//a[1]"));
        //System.out.println(audio.getText());
//div[@class='eFQ30H'][4]/a/div[3]/div[2]/div/div/div/a
    }

    @Test
    public void flip2() throws InterruptedException {

        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='_3704LK']"));


        searchBox.click();


        Thread.sleep(3000);

        WebElement tShirt = null;
        try {
            tShirt =driver.findElement(By.xpath("//ul[@class='col-12-12 _1MRYA1']/li[4]/div"));

            tShirt.click();
        } catch (RuntimeException e) {
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/ul/li[4]/div/a")).click();

        }

/*
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("T Shirts"));

 */

        //ul[@class='col-12-12 _1MRYA1']//li[.='t shirts']/div/a
        //ul[@class='col-12-12 _1MRYA1']/li[4]


    }
}
/*
>>Task1
-  Go to https://www.flipkart.com/
- Locate Wire Headphones

>>Task2
- Go to  https://www.flipkart.com/
- Click on the search box
- Locate t-shirts
 */