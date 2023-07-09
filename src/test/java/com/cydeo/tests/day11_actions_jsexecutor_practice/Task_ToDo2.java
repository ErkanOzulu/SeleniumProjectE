package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task_ToDo2 {
    @Test
    public void todoTest() throws InterruptedException {
        //Navigating to the website
        Driver.getDriver().get("https://todomvc.com/");

        //Locating Javascript button and clicking
        WebElement javaScript = Driver.getDriver().findElement(By.xpath("//div[.='JavaScript']"));
        javaScript.click();

        //Polymer Javascript button and clicking
        WebElement polymer = Driver.getDriver().findElement(By.xpath("//a[.='Polymer']"));
        polymer.click();
        //Locating to-do list and creating 2 todos
        Thread.sleep(2000);
        WebElement todoList = Driver.getDriver().findElement(By.id("new-todo"));
        todoList.sendKeys("List1" + Keys.ENTER);
        todoList.sendKeys("List2" + Keys.ENTER);

        //Locating the second to-do list and storing the length of text in it as an int variable
        Actions action = new Actions(Driver.getDriver());
        WebElement secondTodo = Driver.getDriver().findElement(By.xpath("//li[@is='td-item'][2]//label"));
        int secondTodoTextSize = secondTodo.getText().length();

        //Double-clicking on second to-do list
        action.doubleClick(secondTodo).perform();
        WebElement secondTodoEdit = Driver.getDriver().findElement(By.cssSelector("#edit"));
        // 1. WAY
        // Removing the text with using backspace after selecting all the second to-do title

        secondTodoEdit.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
        //new to-do item instead of second to-do one
        secondTodoEdit.sendKeys("New List2" + Keys.ENTER);
        Thread.sleep(10000);
        // 2. WAY :
        // Removing the text with using backspace
//       for (int i = 0; i < secondTodoTextSize; i++) {
//           action.sendKeys(Keys.BACK_SPACE).perform();

//        }

        //Third way

//actions.moveToElement(editelement).doubleClick().keyDown(Keys.CONTROL).sendKeys("a"+Keys.BACK_SPACE).keyUp(Keys.CONTROL).sendKeys("yakup").perform();

        Driver.closeDriver();


    }
}
