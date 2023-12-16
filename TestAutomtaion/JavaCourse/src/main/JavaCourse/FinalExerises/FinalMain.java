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
        System.out.println("========= Part 8 ===========");
        String friendsThemeSongLyrics =
                "So no one told you life was gonna be this way\n" +
                        "Your job's a joke, you're broke, your love life's D.O.A.\n" +
                        "It seems you're always stuck in second gear\n" +
                        "When it hasn't been your day, your week, your month, or even your year, but\n\n" +
                        "I'll be there for you\n(When the rain starts to pour)\n" +
                        "I'll be there for you\n(Like I've been there before)\n" +
                        "I'll be there for you\n('Cause you're there for me too)\n\n" +
                        "You're still in bed at ten and work began at eight\n" +
                        "You burned your breakfast so far, things are going great\n" +
                        "Your mother warned you there'd be days like these\n" +
                        "But she didn't tell you when the world has brought you down to your knees that\n\n" +
                        "I'll be there for you\n(When the rain starts to pour)\n" +
                        "I'll be there for you\n(Like I've been there before)\n" +
                        "I'll be there for you\n('Cause you're there for me too)\n\n" +
                        "No one could ever know me, no one could ever see me\n" +
                        "Seems you're the only one who knows what it's like to be me\n" +
                        "Someone to face the day with, make it through all the rest with\n" +
                        "Someone I'll always laugh with, even at my worst, I'm best with you, yeah!\n\n" +
                        "It's like you're always stuck in second gear\n" +
                        "When it hasn't been your day, your week, your month, or even your year, but\n\n" +
                        "I'll be there for you\n(When the rain starts to pour)\n" +
                        "I'll be there for you\n(Like I've been there before)\n" +
                        "I'll be there for you\n('Cause you're there for me too)\n\n" +
                        "I'll be there for you\n(When the rain starts to pour)\n" +
                        "I'll be there for you\n(Like I've been there before)\n" +
                        "I'll be there for you\n('Cause you're there for me too)";
        ff.randomSongsWords(friendsThemeSongLyrics);
        System.out.println("========= Part 9 - A ===========");
        String [] words = {"ABC", "AAAAA", "BBB", "kjhdsfkjo","JDSDFHKJH", "FGH","LXCVKJ","XLCKVJL","VCKJLK","VLK;LK","VLKL"};
        ff.returnTheLongestString(words);
        System.out.println("========= Part 9 - B ===========");
        ff.findTheWord(words,"LXCV");

        System.out.println("========= Part 10 ===========");
        String[][] grades ={
                {"David","85"},
                {"Moshe","76"},
                {"ILana","45"},
                {"Shlomo","91"},
                {"Hanna","82"}};
        ff.findTheBestStudent(grades);
        System.out.println("========= Part 11 ===========");
        ff.findSecondBestNumber(numbers);
        System.out.println("========= Part 12 ===========");
        int [] numbers2 = {1,2,3,4,5,6,7,8,9,10};
        int[] numbers3 = {10,2,3,6,5,4,7,8,9,1};
        ff.theArrayAreEqual(numbers2,numbers3);
        System.out.println("========= Part 13 ===========");
        ff.returnPrimeNumbers(numbers2);
        System.out.println("========= Part 14 ===========");
        System.out.println(ff.convertToEnglish(123));
    }
}
