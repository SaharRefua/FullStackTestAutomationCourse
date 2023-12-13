package FinalExerises;

public class FinalMain {
    public static void main (String[] args) {
        FinalFunctions ff = new FinalFunctions();
        System.out.println("========= Part 1 ===========");
        System.out.println(ff.sortIntNumber(12345));
        System.out.println("========= Part 2 ===========");
        System.out.println(ff.sortDoubleNumber(123.45));
        System.out.println("========= Part 3 ===========");
        double[] numbers= {12, 9, 8, 5, 2, 1};
        ff.muliptlLowerThan10(numbers);
        System.out.println("========= Part 4 ===========");
        ff.calAvg(numbers);
        System.out.println("========= Part 5 ===========");
        ff.calculator(1,"+",2);
        ff.calculator(6,"*",5);
        ff.calculator(10,"/",2);
        System.out.println("========= Part 6 ===========");
        double[] evenNumbers= {2,3,4,5,67,8,10};
        ff.checkArray(evenNumbers);
        System.out.println("========= Part 7 ===========");
        ff.middleNumber(numbers);

    }
}
