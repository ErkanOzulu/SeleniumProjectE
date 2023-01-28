package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task_TODO {
    @Test
    public void test1(){

        //1-  go to "http://todomvc.com/

        WebDriver driver= Driver.getDriver();
        driver.get("http://todomvc.com/");

        //click within the JavaScript tab
        driver.findElement(By.xpath("//paper-tab[@data-target='js']")).click();
        //select Polymer link
        driver.findElement(By.xpath("//a[contains(@href,'polymer/')]")).click();

        //2. Add to To-do items


        WebElement input=driver.findElement(By.xpath("//input[@id='new-todo']"));

        input.sendKeys("FirstToDoItem"+ Keys.ENTER);

        input.sendKeys("SecondToDoItem"+Keys.ENTER);

        //3. Edit the content of the second To-do item

        Actions actions=new Actions(driver);
        WebElement secondLebel = driver.findElement(By.xpath("//label[.='SecondToDoItem']"));

        actions.moveToElement(secondLebel).doubleClick().doubleClick().sendKeys("editing second.."+Keys.ENTER).perform();

    }

    @Test
    public void test2(){ //applied second way

        //1-  go to "http://todomvc.com/

        WebDriver driver= Driver.getDriver();
        driver.get("http://todomvc.com/");

        //click within the JavaScript tab
        driver.findElement(By.xpath("//paper-tab[@data-target='js']")).click();
        //select Polymer link
        driver.findElement(By.xpath("//a[contains(@href,'polymer/')]")).click();

        //2. Add to To-do items


        WebElement input=driver.findElement(By.xpath("//input[@id='new-todo']"));

        input.sendKeys("FirstToDoItem"+ Keys.ENTER);

        input.sendKeys("SecondToDoItem"+Keys.ENTER);

        //3. Edit the content of the second To-do item

        Actions actions=new Actions(driver);
        WebElement secondLebel = driver.findElement(By.xpath("//label[.='SecondToDoItem']"));

        actions.doubleClick(secondLebel).perform();

        WebElement edit=driver.findElement(By.id("edit"));
        edit.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+"editing second..."+Keys.ENTER);




    }


}

