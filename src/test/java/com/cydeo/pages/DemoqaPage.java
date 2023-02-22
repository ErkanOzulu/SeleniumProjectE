package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage {

    public DemoqaPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[5]")
    public WebElement interactionsTab;

    @FindBy(xpath = "(//*[@id=\"item-2\"])[4]/span")
    public WebElement resizableTab;


    @FindBy(css="#resizableBoxWithRestriction>span")
    public WebElement resizeBox1Handle;
    //span[contains(@class,'react-resizable-handle')]
    @FindBy(css="#resizable>span")
    public WebElement resizeBox2Handle;






}
