package Lesson04.exercise03;

public class mobileDevice {
    private String model;
    private char os;
    private double version;
    private boolean hasFlash;
    private int price, screenWidth, screenHeight;

    public mobileDevice (String model, char os, double version, boolean hasFlash, int price, int screenWidth, int screenHeight) {
        this.model = model;
        this.os = os;
        this.version = version;
        this.hasFlash = hasFlash;
        this.price = price;

        if(screenWidth > 0)
            this.screenWidth = screenWidth;
        else
            throw new RuntimeException("Wrong width");
        if(screenHeight > 0)
            this.screenHeight = screenHeight;
        else
            throw new RuntimeException("Wrong height");

    }

    public void printParameters() {
        System.out.println(model + " " + os + " " + version + " " + hasFlash + " " + price);
    }

    public int calculateArea() {
        return screenWidth * screenHeight;
    }

    public void pictureQuality() {
        if(hasFlash)
            System.out.println("Good Quality");
        else
            System.out.println("Bad Quality");
    }

}
