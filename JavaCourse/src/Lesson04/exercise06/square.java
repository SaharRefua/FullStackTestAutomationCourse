package Lesson04.exercise06;

public class square extends shape{
    final double PI =3.14;
    double GetArea(double radius){
        return PI* radius*radius;
    }
    double GetPerimeter(double radius){
        return PI*2*radius;
    }
}
