package Lesson18;

import org.testng.annotations.Test;

public class MyTestNG1 {
    @Test(groups="Sanity")
    public static void test01(){
        System.out.println("File 1 - Test01");
    }
    @Test
    public static void test02(){
        System.out.println("File 1 - Test02");
    }

    @Test(groups="Sanity")
    public static void test03(){
        System.out.println("File 1 - Test03");
    }

    @Test
    public static void test04(){
        System.out.println("File 1 - Test04");
    }

    @Test(groups="Regression")
    public static void test05(){
        System.out.println("File 1 - Test05");
    }

    @Test(groups="Regression")
    public static void test06(){
        System.out.println("File 1 - Test06");
    }



}