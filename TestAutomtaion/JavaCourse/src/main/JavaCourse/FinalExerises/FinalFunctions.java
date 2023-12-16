package FinalExerises;

import java.util.Arrays;
import java.util.Random;

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
            double middleNumber = (numbers.length - 1) / 2;
        } else {
            double middleNumber = (numbers.length / 2) + 1;
        }
    }


    void randomSongsWords(String songWords) {
        // Create a Random object
        Random random = new Random();
        // Generate a random number between 0 (inclusive) and the length of the array (exclusive)
        String[] list = songWords.split(" ");

        for (int i = 0; i < list.length; i++) {
            int randomNumber = random.nextInt(list.length);
            System.out.println(list[randomNumber]);
        }
    }

    void returnTheLongestString(String[] words) {
        String longestWord = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        System.out.println("The longest word is: " + longestWord);
    }

    void findTheWord(String[] words, String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(word)) {
                System.out.println("The word " + words[i] + " is in the array");
            }
        }
    }

    void findTheBestStudent(String[][] grades) {
        int bestGrade = 0;
        String bestStudent = "";
        for (int i = 0; i < grades.length; i++) {
            if (Integer.parseInt(grades[i][1]) > bestGrade) {
                bestGrade = Integer.parseInt(grades[i][1]);
                bestStudent = grades[i][0];
            }
        }
        System.out.println("The best student is: " + bestStudent + " with grade: " + bestGrade);
    }

    void findSecondBestNumber(double[] numbers) {
        double secondBestNumber = Integer.MIN_VALUE;
        double bestNumber = Integer.MIN_VALUE;
        for (double number : numbers) {
            if (number > bestNumber) {
                secondBestNumber = bestNumber;
                bestNumber = number;
            } else if (number > secondBestNumber && number < bestNumber) {
                secondBestNumber = number;
            }
        }
        System.out.println("The second best number is: " + secondBestNumber);
    }


    void theArrayAreEqual(int[] numbers1, int[] numbers2) {
        Boolean isEqual = true;
        if (numbers1.length == numbers2.length) {
            for (int number : numbers1) {
                for (int number2 : numbers2) {
                    if (number != number2) {
                        isEqual = false;
                        break;
                    }
                }
            }
        }
        if (isEqual)
            System.out.println("The arrays are equal");
        else
            System.out.println("The arrays are not equal");
    }

    void returnPrimeNumbers(int[] numbers) {
        for (int number : numbers) {
            boolean isPrime = true;
            for (int k = 2; k <= number / 2; k++) {
                if (number % k == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println("The number: " + number + " is prime");
        }
    }

    static String convertToEnglish(int number) {
        if (number == 0) {
            return "Zero";
        }

        // Arrays to store words for numbers less than 20 and multiples of 10
        String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        // Use recursion for numbers greater than 20
        if (number < 20) {
            return belowTwenty[number];
        } else if (number < 100) {
            return tens[number / 10] + " " + convertToEnglish(number % 10);
        } else if (number < 1000) {
            return belowTwenty[number / 100] + " Hundred " + convertToEnglish(number % 100);
        } else if (number < 1000000) {
            return convertToEnglish(number / 1000) + " Thousand " + convertToEnglish(number % 1000);
        } else {
            return "Number is too large for this example.";
        }
    }






}





