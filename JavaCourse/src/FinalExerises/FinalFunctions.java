package FinalExerises;

import java.util.Arrays;

public class FinalFunctions {

    String sortIntNumber(int number) {
        String sNumber = Integer.toString(number);
        String[] charts = sNumber.split("");
        String backWordNumber = "";
        for (int i = charts.length - 1; i >= 0; i--) {
            backWordNumber += charts[i];
        }
        return backWordNumber;
    }

    String sortDoubleNumber(double number) {
        String sNumber = Double.toString(number);
        String[] charts = sNumber.split("");
        String backWordNumber = "";
        for (int i = charts.length - 1; i >= 0; i--) {
            backWordNumber += charts[i];
        }
        return backWordNumber;
    }

    void muliptlLowerThan10(double[] numbers) {
        double[] results = new double[numbers.length];
        for (int x = 0; x < numbers.length; x++) {
            if ((numbers[x] > 1) && (numbers[x] <= 10)) {
                System.out.println(numbers[x] * numbers[x]);
            } else {
                System.out.println(numbers[x]);
            }
        }

    }

    void calAvg(double[] numbers) {
        double sum = 0, avg;
        for (double number : numbers) {
            sum += number;
        }
        avg = sum / numbers.length;
        System.out.println("Avarage is: " + avg);
    }

    void calculator(double number1,
                    String action, double number2) {
        if (action.equals("/")) {
            System.out.println("The results is: " + number1 / number2);
        } else if (action.equals("*")) {
            System.out.println("The results is: " + number1 * number2);
        } else if (action.equals("-")) {
            System.out.println("The results is: " + (number1 - number2));
        } else if (action.equals("+")) {
            System.out.println("The results is: " + (number1 + number2));
        }
    }


    void checkArray(double[] numbers) {
        double[] evenNumbers = new double[numbers.length];
        byte index = 0;
        for (int x = 0; x < numbers.length; x++) {
            if (numbers[x] % 2 == 0 && numbers[x] % 4 == 0) {
                evenNumbers[index] = numbers[x];
                index++;
            }
        }
        for (double num : evenNumbers)
            System.out.println("Even number : " + num);
    }

    void middleNumber(double[] numbers) {
        if (numbers.length % 2 == 0) {
            double middleNumber = numbers.length / 2;
        }


    }


}

