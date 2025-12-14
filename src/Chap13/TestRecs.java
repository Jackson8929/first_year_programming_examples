package Chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestRecs {


    public static void main(String[] args) throws ParseException{
        Instructor obIns = new Instructor("Bryce Barrie", "240A.1",
                new SimpleDateFormat("yyyy-MM-dd").parse("1193-8-16"));

        Instructor obIns2 = new Instructor("Coraleee Kaben", "240A.2", new SimpleDateFormat("yyyy-MM-dd").parse("2007-08-19"));

        System.out.printf("Instructor names are \n%s\n%s\n",obIns.name(), obIns2.name());


    }



}
