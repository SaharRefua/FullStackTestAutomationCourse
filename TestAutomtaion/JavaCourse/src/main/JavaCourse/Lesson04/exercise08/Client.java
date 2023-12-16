package Lesson04.exercise08;

import java.util.Date;
import java.sql.Timestamp;

public class Client {
    public Timestamp GetDateTime(){
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        return timeStamp;
    }
}