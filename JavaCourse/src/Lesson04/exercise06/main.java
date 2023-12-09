package Lesson04.exercise06;

public class main {
    public static void main(String[] args) {
        circle c = new circle();
        System.out.println("Circle Area is : " + c.GetArea(2.3));
        System.out.println("Circle perimeter is : " + c.GetPerimeter(2.3));

        square sq = new square();
        System.out.println("Square Area is : " + sq.GetArea(2.3));
        System.out.println("Square perimeter is : " + sq.GetPerimeter(2.3));
    }
}
