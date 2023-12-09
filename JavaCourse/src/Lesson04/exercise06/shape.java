package Lesson04.exercise06;
abstract public class shape {
    abstract double GetArea(double length);
    abstract double GetPerimeter(double length);

    public void printDetails(){
        System.out.println("Shape of is a geometric figure");
    }
}
