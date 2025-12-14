package Chap19;

import java.util.Iterator;

public class TestOLList
{
    public static void main(String[] args)
    {
        OLList<String>lstNames = new OLList<>();
        lstNames.add("Rick");
        lstNames.add("Bryce");
        lstNames.add("Ron");


        System.out.println("The size of the list is: "+ lstNames.size());

//        String[] obList = lstNames.toArray();
//
//        for (String sVals : obList)
//        {
//            System.out.println(sVals);
//        }

        //using the while loop construct
        Iterator obIt = lstNames.iterator();;

        while (obIt.hasNext())
        {
            System.out.println(obIt.next());
        }

        for (String sVal : lstNames)
        {
            System.out.println("EL: "+sVal);
        }

    }
}
