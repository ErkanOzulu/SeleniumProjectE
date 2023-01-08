package com.cydeo.tests.day8_propperties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){

        //key=value---> we provided key, it gives us value's
        //os.name = Windows 10
        //user.name = Data

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));


    }
}
