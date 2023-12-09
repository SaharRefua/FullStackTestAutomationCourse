package Lesson02;

public class statements {
    public static void main(String[] args) {
        //1
        double x, y;
        x = 15;
        y = 18.9;
        if (x > y) {
            System.out.println(x);
        } else if (y > x) {
            System.out.println(y);
        } else {
            System.out.println(x + y);
        }
        // 2 - Part A
        int[] numbers = {8, 5, 9};
        if (numbers[0] > numbers[1]) {
            System.out.println("First One is Bigger");
        } else if (numbers[0] < numbers[1]) {
            System.out.println("Second On is bigger");
        }
        if (numbers[0] == numbers[1]) {
            System.out.println("Both are Equal");

        }
        // 2 - Part B - answer is: Both are Equal
        // 2 - Part C - answer is: First One is Bigger

        // 3 - Part A
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // 3 - Part B
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
        // 3 - Part C
        int number = 30;
        int LastNumber = 50;
        while (number <= LastNumber) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
            number++;
        }
        // 3 - Part D
        int number2 = 20;
        int LastNumber2 = 40;
        while (number2 <= LastNumber2) {
            if (number2 % 2 > 0) {
                System.out.println(number2);
            }
            number2++;
        }


        // 4 - Part A
        String[] countries = {"Austria", "Germany", "Canada", "Peru", "Israel"};
        for (String country : countries) {
            System.out.println(country);
        }
        // 4 - Part B
        for (String country : countries) {
            if (country.equals("Israel")) {
                System.out.println(country);
            }
        }
        // 4 - Part C
        if (countries[2].equals("China")) {
            System.out.println("Yes, it is there");
        } else {
            System.out.println("No, Sorry...");
        }
        // 4 - Part D
        int countryLength = countries[0].length();
        System.out.println(countryLength);


        // 5
        int age = 8;
        if (6 >= age && age > 0) {
            System.out.println("Go To Kindergarten");
        } else if (18 >= age && age > 7) {
            System.out.println("Go To School");
        } else if (67 >= age && age > 19) {
            System.out.println("Go To Work");
        } else if (67 >= age && age < 120) {
            System.out.println("Collecting Pension");
        }
        // 6
        String profession = "Taxi Driver";
        int salary;
        switch (profession) {
            case "Teacher": {
                salary = 5000;
                break;
            }
            case "Bank Teller": {
                salary = 10000;
                break;
            }
            case "QA": {
                salary = 15000;
                break;
            }
            default:
                salary = 9100;
        }
        System.out.println("Salary of " + profession + " is: " + salary);

        //7
        String[][] employess = new String[2][3];
        employess[0][0]="Moshe";
        employess[0][1]="22";
        employess[0][2]="Jerusalem";
        employess[1][0]="Joseph";
        employess[1][1]="45";
        employess[1][2]="London";

        for (int row=0;row<2;row++){
            for (int column=0;column<3;column++){
                System.out.println(employess[row][column]);
            }
        }
        //8
        int[] numberArray= {2,3,4,56,7,8,9,5,9,9,0};
        for (int number8 :numberArray){
            if (number8%2==0){
                System.out.println(number8);
            }
        }
        //9
        System.out.println("Answer 9 -------------------------");
        int[] numberArray2= {2,3,15,56,30,35,9,55,45,9,0};
        for (int number9 :numberArray2){
            if (number9%3==0 && number9%5==0){
                System.out.println(number9);
            }
        }
        //10
        System.out.println("Answer 10 -------------------------");
        String[] wordsArr= {"o","l","l","e","H"};
        int index =4;
        do {
            System.out.print(wordsArr[index]);
            index--;
        }
        while (index>=0);

        //11
        System.out.println("Answer 11 -------------------------");
        int[] numberArr= {15,2,36,20,7};
        //Part A
        if (numberArr[0]>numberArr[1]){
            if (numberArr[0]>numberArr[2]){
                System.out.println("First number is the bigger:" + numberArr[0]);
            }
            else {
                System.out.println("Third number is the bigger:" + numberArr[2]);
            }
        }
        else {
            if (numberArr[1]>numberArr[2]){
                System.out.println("Second number is the bigger:" + numberArr[1]);
            }
            else {
                System.out.println("Third number is the bigger:" + numberArr[2]);
            }

        }
        //Part B
        int max = 0;
        for (int number11 : numberArr) {
            if (number11 > max) {
                max = number11;
            }
        }
        System.out.println(max);
        // 11 - Part C
        int sum = 0;
        for (int number12 : numberArr) {
            sum += number12; //sum = sum + number;
        }
        System.out.println("The sum of the array is: " + sum);

        //12
        System.out.println("Answer 12 -------------------------");
        int isPrimeNumber = 14;
        boolean isPrime = true;
        for (int k = 2; k < isPrimeNumber / 2; i++) {
            if(isPrimeNumber % k == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println("The number: " + isPrimeNumber + " is a Prime Number");
        else
            System.out.println("The number: " + isPrimeNumber + " is NOT a Prime Number");
    }


}
