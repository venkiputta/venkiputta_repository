package users;

import org.testng.annotations.*;

public class UserScripts {
    @Test
    public void createUser(){
        System.out.println("User created successful");
    }
    @Test
    public void editUser(){
        System.out.println("User Edited successful");
    }
    @Test
    public void deleteUser(){
        System.out.println("User delete successful");
    }
    @BeforeSuite
    public void beforesuitdemo(){
        System.out.println("User @beforesuit example");
    }
    @AfterSuite
    public void aftersuitdemo(){
        System.out.println("User @aftersuit example");
    }
    @BeforeTest
    public void befortestdemo(){
        System.out.println("User @beforetestdemo example");
    }
    @AfterTest
    public void afteetestdemo(){
        System.out.println("User @aftertestdemo example");
    }
    @BeforeClass
    public void beforeclassdemo(){
        System.out.println("User @beforeclassdemo example");
    }
    @AfterClass
    public void afterclassdemo(){
        System.out.println("User @afterclassdemo example");
    }

}
