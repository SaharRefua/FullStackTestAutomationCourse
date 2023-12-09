package Lesson04.exercise05;

public class mainTraditional {
    public static void main(String[] args) {
        china ch = new china();
        System.out.println(ch.myTraditionalFood() + " " + ch.myTraditionalLanguage() + " " + ch.myTraditionalVacation());

        israel is = new israel();
        System.out.println(is.myTraditionalFood() + " " + is.myTraditionalLanguage() + " " + is.myTraditionalVacation());

        usa us = new usa();
        System.out.println(us.myTraditionalFood() + " " + us.myTraditionalLanguage() + " " + us.myTraditionalVacation());
    }
}
