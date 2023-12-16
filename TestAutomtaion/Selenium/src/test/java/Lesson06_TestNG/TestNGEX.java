package Lesson06_TestNG;


import org.testng.annotations.*;

public class TestNGEX {
    @BeforeClass
    public  void beforeClass() {
        System.out.println("BeforeClass - This will run once before all tests");
    }

    @Test
    public void test01() {
        System.out.println("Test - 01");
    }

    @Test
    public void test02() {
        System.out.println("Test - 02");
    }

    @BeforeMethod
    public  void beforeMethod() {
        System.out.println("BeforeMethod - This will run once before each test");
    }

    @AfterMethod
    public  void afterMethod() {
        System.out.println("AfterMethod - This will run once after each test");
    }

    @AfterClass
    public  void afterClass() {
        System.out.println("AfterClass - This will run once after all tests");
    }
}