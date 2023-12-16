package Lesson01;

public class primitiveDataTypes {
    public static void main(String[] args) {
        // primitive data types
        // data type , variable , literal
        // byte a =100;
        byte by = 120; // 8 bits values: -128 -127
        short s = 2000; //16 bit size values: -32,768 up to 32,767
        int i = 20000000; // 32 bit size values: -2,147483,648 up to 2,147483,647
        long l = 2000000000; // 64 bit size values: -9,223,372,036,854,77....
        float f = 9; //32 bit size
        double d = 1.13213; //64 bit size
        char letter= 'Y';
        boolean bool=true; // 1 bit true or false
        System.out.println("" + bool );
        // casting -Changing a value from one data type to another
        // int to double widening
        // int a =100;
        //  double b = a;
        //System.out.println(b); => 100.0
        // double to int is narrowing (Explicit)
        double a = 100.91;
        int b = (int) a ;
        System.out.println(b); // => 100

    }
}
