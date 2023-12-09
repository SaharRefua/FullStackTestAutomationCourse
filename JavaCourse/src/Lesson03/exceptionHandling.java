package Lesson03;

public class exceptionHandling {
    public static void main(String[] args) {
        String temp = "Null";
        String[] array = {"Hello", "World"};
        try {
            temp = array[4];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array on the 4th index is: " + temp);
        }
    }
}

