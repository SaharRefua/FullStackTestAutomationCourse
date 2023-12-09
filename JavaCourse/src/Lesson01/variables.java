package Lesson01;

public class variables {


// global viable - Declared in a class and will be recognized in whole class
 int x =1;
    void func1 (){
        //Local viable - Declared in a method and will be destroyed once ot ends
        int x = 2;
        System.out.println(x);
    }
    void  func2(){
        System.out.println(x);
    }


public static void main(String[] args) {
    int age = 30 ;
    char firstLetter ='S';
    double grade =95;
    boolean gender = false;

    System.out.println(age+" "+ firstLetter + " "+ grade+" " + gender);

}



}
