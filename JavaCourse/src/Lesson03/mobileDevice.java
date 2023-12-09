package Lesson03;

public class mobileDevice {
    String model ="";
    char os=' ';
    double version=0;
    boolean hasFlash=false;
    int price =0;
    int screenHeight=0;
    int screenWidth=0;

    void printParameters(){
        System.out.println("Model: "+ model );
        System.out.println("os: " + os);
        System.out.println("version:" + version  );
        System.out.println( "Has flash: "+ hasFlash );
        System.out.println("price: "+ price );

    }
    int calculateArea(int height, int width){
        int results=0;
        results= height*width;
        return results;
    }
    void pictureQuality(){
        if (hasFlash){
            System.out.println("God Quality");
        }
        else {
            System.out.println("Bad Quality");
        }
    }

}
