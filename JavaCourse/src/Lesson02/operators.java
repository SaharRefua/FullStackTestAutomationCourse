package Lesson02;

public class operators {
    public static void main(String[] args) {
        // Arithmetic Operators
        // + addition           1 + 2 = 3
        // - subtraction        3 - 2 = 1
        // * Multiplication     2 * 3 = 6
        // / Division           6 / 3 = 2
        // % Modulus            5 % 3 = 2
        // x +=2 x=x+2
        // int x= 6 ;
        // y = ++x  ==> x and y are equals to 6


        // Boolean Operators
        // && and
        // || or
        // ! not


        // Relational Operators
        // == Equal to
        // != Not equal to
        // > Greater than
        // < Less than
        // >= Greater than or equal
        // <= Less than or equal

        // Ternary Operators
        //if expression 1 is true , then expression 2 is evaluated otherwise expression 3 is evaluated
        // expression 1 ? expression 2: expression 3
        // int value = a < 5 ? 10 : 20 ;
        // String Gender = name.equals("Moshe") ? "Male" : "Female"




        // Part A:
        // 4
        // 5
        // 6
        // 6
        // 7
        // 4

        // Part B:
        int number = 7;
        int result = number % 2 == 0 ? number : -1;
        System.out.println(result);


    }
}
