package Lesson01;

public class nonPrimitiveDataTypes {
    public static void main(String[] args) {
    String MyName = "Sahar";
    System.out.println(MyName.concat(" Refua"));
    //Or
    System.out.println("Sahar"+" " + "Refua");
        if (MyName.equals("sahar")){
            System.out.println("The names are equals");
        }
        else {
            System.out.println("The names are NOT equals");
        }
        if (MyName.equalsIgnoreCase("sAhAr")) {
            System.out.println("The names are equals - tested with Ignore Case");
            System.out.println("Name length is :" + MyName.length());
            System.out.println("The chart in the 2 potion is :"+ MyName.charAt(2));
        }
        String str = "iPhone is the best , we love iPhone";
        System.out.println(str.replace('e','*'));// Charts only !!!!!!
        System.out.println(str.replaceAll("iPhone","Android"));
        System.out.println(str.replaceFirst("iPhone","Android"));
        System.out.println("To lower case :"+str.toLowerCase());
        System.out.println("To UPPER case :"+str.toLowerCase());

        //Casting int to string
        int age = 22;
        String MyAge = Integer.toString(age);
        // Or
        System.out.println(""+age);



        //Array
        //  An array is a data structure
        //  Static structure
        //  Can not change its size while running
        //  All values must be with the same data type
        //init array
        String[] names = new String[3];
        int[] numbers = new int [7];
        //Add data to array
        numbers[0]=10;
        numbers[1]=-8;
        numbers[2]=6;
        //Or create and assign data
        //index of array stat with 0
        int[] numbers2 = {1,2,3,4,5,6,7,8,9,0};
        //Update the Third value
        numbers2[2]= 99;


        //2 Dimensional Array
        int[][]lotoNumbers = new int[2][7];
        lotoNumbers[0][0]=10;
        lotoNumbers[0][1]=42;
        lotoNumbers[1][2]=7;

        //Split
        String date = "31/12/1955";
        String[] array = date.split("/");
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        // 1-1
        String firstName= "Sahar";
        String lastName= "Refua";
        //1-2
        int myAge = 23;
        String myAgeStr= Integer.toString(myAge);
        System.out.println(myAgeStr);
        //1-3
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
        //1-4
        System.out.println(fullName.toUpperCase());
        //1-5
        System.out.println(fullName.length());
        //1-6
        System.out.println(myAgeStr.equals(fullName));

        //2-1
        int[] myArray = {1,2,3,4,5};
        System.out.println(myArray[0]);
        System.out.println(myArray[3]);
        //2-2
        System.out.println(myArray[0]+myArray[1]);

        //3-1
        String[] names3 = {"Sahar","Idan","Matan","Sigal","Shimshon"};
        System.out.println(names3[0].toUpperCase());
        System.out.println(names3[1].toUpperCase());
        System.out.println(names3[2].toUpperCase());
        System.out.println(names3[3].toUpperCase());
        System.out.println(names3[4].toUpperCase());

        //3-2
        System.out.println(names3[0].length());


        //3-3
        System.out.println(names3[3] + names3[4]);


        //3-4
        System.out.println(names3[0].charAt(0));
        System.out.println(names3[1].charAt(0));
        System.out.println(names3[2].charAt(0));
        System.out.println(names3[3].charAt(0));
        System.out.println(names3[4].charAt(0));

        //4-1
        String[][] employess = new String[2][3];
        employess[0][0]="Moshe";
        employess[0][1]="22";
        employess[0][2]="Jerusalem";
        employess[1][0]="Joseph";
        employess[1][1]="45";
        employess[1][2]="London";
        System.out.println(employess[0][2]);
        //5-1
        String[] MyArray2=new String[8];
        MyArray2[0]="Java";
        MyArray2[1]="is";
        MyArray2[2]="a";
        MyArray2[3]="general";
        MyArray2[4]="purpose";
        MyArray2[5]="computer";
        MyArray2[6]="programming";
        MyArray2[7]="language";

        System.out.println(MyArray2[(MyArray2.length-1)]);
        System.out.println(MyArray2[(MyArray2.length-2)]);
        System.out.println(MyArray2[(MyArray2.length-3)]);
        //5-2
        String MyString2= "Java is a general purpose computer programming language";
        String[] MyArray3= MyString2.split(" ");

        System.out.println(MyArray3[(MyArray3.length-1)]);
        System.out.println(MyArray3[(MyArray3.length-2)]);
        System.out.println(MyArray3[(MyArray3.length-3)]);

        //6-1
        String bonJovi = "Shot through the heart and you're to blame darling you give love a bad name";
        System.out.println(bonJovi.replaceAll(" ",""));
        //6-2
        String[] words = bonJovi.split(" ");
        System.out.println(words.length-1);

        //6-3
        System.out.println(words[0].toUpperCase());
        System.out.println(words[words.length-1].toUpperCase());




    }
}
