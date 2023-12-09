package Lesson03;

public class shapes {
    public static void main(String[] args) {
        rectangle rectang = new rectangle();
        rectang.height=15;
        rectang.width=15;
        rectang.calSpace(15,15);

        triangle tria = new triangle();
        tria.height=14;
        tria.width=12;
        tria.calSpace(14, 12);

        circle circ= new circle();
        circ.pi=3.414231;
        circ.radius=5.432;
        circ.calSpace(circ.pi, circ.radius);
    }
}
