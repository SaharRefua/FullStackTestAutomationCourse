package Lesson04.exercise04;

import Lesson04.exercise04.child1;
import Lesson04.exercise04.child2;

public class main {

    public static void main(String[] args) {
        child1 c1 = new child1();
        child2 c2 = new child2();
        System.out.println(c1.firstName + " " + c1.lastName);
        System.out.println(c2.firstName + " " + c2.lastName);
    }


}
