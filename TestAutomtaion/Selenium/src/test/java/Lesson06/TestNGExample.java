package Lesson06;

import org.testng.annotations.*;

public class TestNGExample {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @Test
    public void test01() {
        System.out.println("Test 01");
    }

    @Test
    public void test02() {
        System.out.println("Test 02");
    }

    @Test
    public void test03() {
        System.out.println("Test 03");
    }

    @Test
    public void test04() {
        System.out.println("Test 04");
    }
}
