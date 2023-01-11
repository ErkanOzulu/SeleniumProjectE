package com.cydeo.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoft_Assertion {



    @Test(priority = 2)
    public void hardAssertion(){

        Assert.assertEquals("apple", "app"); //if it fails, then it won't execute the following  part
        System.out.println("After assertion failed");
        Assert.assertTrue("orange".equals("oranger"));
        System.out.println("After assertion failed");

   }

   @Test(priority = 1)
    public void softAssertion(){


       SoftAssert softAssert=new SoftAssert(); // we have to create softAssert object from SoftAssert class
       softAssert.assertEquals("apple","app");
       System.out.println("After assertion failed");
       softAssert.assertTrue("orange".equals("oranger"));
       System.out.println("After assertion failed");
       softAssert.assertAll();// if we write this line, it shows us the "The following asserts failed:
       //expected [app] but found [apple]
       //expected [true] but found [false]




   }



}
