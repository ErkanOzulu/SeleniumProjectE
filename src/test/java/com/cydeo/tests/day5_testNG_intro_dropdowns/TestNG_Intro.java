package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupMethod() {
        System.out.println("---> Before class is running!");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("---> Before method is running!");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("-----> AfterClass is running!");

    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("--> AfterMethod is running!");
    }

    @Test(priority = 1)
    public void test1() {

        System.out.println("Test1 is running...");

        //ASSERT EQUALS: compare 2 of the same things
        String actual="apple";
        String expected="apple1";
        Assert.assertEquals(actual,expected);

    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test2 is running...");
        String actual="apple";
        String expected="apple";
        Assert.assertTrue(actual.equals(expected));

    }


}
