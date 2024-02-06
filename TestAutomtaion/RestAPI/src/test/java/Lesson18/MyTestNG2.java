package Lesson18;

import org.testng.annotations.Test;

public class MyTestNG2 {
    @Test(groups="Regression")
    public static void test01(){
        System.out.println("File 2 - Test01");
    }
    @Test(groups="Regression")
    public static void test02(){
        System.out.println("File 2 - Test02");
    }

    @Test(groups="Sanity")
    public static void test03(){
        System.out.println("File 2 - Test03");
    }

    @Test
    public static void test04(){
        System.out.println("File 2 - Test04");
    }

    @Test(groups="Sanity")
    public static void test05(){
        System.out.println("File 2 - Test05");
    }

    @Test
    public static void test06(){
        System.out.println("File 2 - Test06");
    }



}