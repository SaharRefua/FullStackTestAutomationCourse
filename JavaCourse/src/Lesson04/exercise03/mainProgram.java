package Lesson04.exercise03;

import Lesson04.exercise03.mobileDevice;

public class mainProgram {
    public static void main(String[] args) {
        mobileDevice device1 = new mobileDevice("Samsung Galaxy", 'A', 2.5, false , 250, 6, 10);
        device1.printParameters();
        System.out.println("Device Area is: " + device1.calculateArea());
        device1.pictureQuality();

        mobileDevice device2 = new mobileDevice("iPhone X", 'I', 14.2, true, 4500, 4, 8);
        device2.printParameters();
        System.out.println("Device Area is: " + device2.calculateArea());
        device2.pictureQuality();
    }

}
