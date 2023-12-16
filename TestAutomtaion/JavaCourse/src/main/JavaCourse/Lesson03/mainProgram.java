package Lesson03;

public class mainProgram {
    public static void main(String[] args) {
        mobileDevice device = new mobileDevice();
        device.price=100;
        device.version=14.2;
        device.hasFlash=true;
        device.model="Iphone 14 pro max";
        device.os='i';
        device.screenHeight=9;
        device.screenWidth=4;
        device.pictureQuality();
        int results = device.calculateArea(device.screenHeight,device.screenWidth);
        System.out.println(results);
        device.printParameters();

        mobileDevice device2 = new mobileDevice();
        device2.price=999;
        device2.version=23;
        device2.hasFlash=false;
        device2.model="Samsung s9";
        device2.os='a';
        device2.printParameters();

    }
}
