package Lesson04.exercise08;

import javax.print.attribute.standard.MediaSize;

public class main {
    public static void main(String[] args) {
        Android a = new Android();
        IOS i = new IOS();
        Chrome c = new Chrome();
        IE ie = new IE();
        ie.callPrint();
        c.callPrint();
        i.callPrint();
        a.callPrint();

    }
}
