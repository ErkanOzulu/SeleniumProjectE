package com.cydeo.tests.day8_propperties_config_reader.ExtraTasks;

import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_2_SmartBear {

    //TC #1: Smartbear software link verification

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }


    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page

    @Test
    public void SmartBear1() {

        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //6. Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links.size() = " + links.size());

        //7. Print out each link text on this page
        for (WebElement eachLink : links) {
            System.out.println("each link text = " + eachLink.getText());
        }
    }

    @Test
    public void SmartBear2() {

        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tester");
        //4. Enter password: “test”
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //6. Click on Order
        driver.findElement(By.xpath("//a[.='Order']")).click();

        //7. Select familyAlbum from product, set quantity to 2

        WebElement selectDropDown = driver.findElement(By.xpath("//select[contains(@id,'ctl00')]"));
        Select product = new Select(selectDropDown);
        product.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.xpath("//input[contains(@id,'_txtQuantity')]")).sendKeys("2");//set quantity to 2


        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();


        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[contains(@id,'_txtName')]")).sendKeys(faker.name().fullName());//Customer name:
        driver.findElement(By.xpath("//input[contains(@id,'_TextBox2')]")).sendKeys(faker.address().streetAddress()); //Street:
        driver.findElement(By.xpath("//input[contains(@id,'_TextBox3')]")).sendKeys(faker.address().city()); //City:
        driver.findElement(By.xpath("//input[contains(@id,'_TextBox4')]")).sendKeys(faker.address().state()); //state:
        driver.findElement(By.xpath("//input[contains(@id,'_TextBox5')]")).sendKeys(faker.address().zipCode().replaceAll("-","")); //zipCode:

        //10.Click on “visa” radio button
        driver.findElement(By.xpath("//input[@value='Visa']")).click();

        //11.Generate card number using JavaFaker
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(faker.finance().creditCard().replaceAll("-",""));

        //Expire date is mandatory so, I added but the task doesn't contain this step

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys(faker.numerify("##/##"));


        // 12.Click on “Process”
        driver.findElement(By.xpath("//a[.='Process']")).click();


        //13.Verify success message “New order has been successfully added.”

        String expected="New order has been successfully added.";
        String actual=driver.findElement(By.xpath("//strong[contains(.,' New order has been successfully added.')]")).getText();
        Assert.assertEquals(actual,expected);

    }



}