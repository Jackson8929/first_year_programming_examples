package Chap19;

import java.util.ArrayList;

public class RawDemo
{
    public static void main(String[] args)
    {
        //Behind the scenes it creates an arraylist of objects
        ArrayList aVals = new ArrayList();
        aVals.add("Saskatoon");
        String sVal = (String) aVals.get(0);

        //aVals.add(22);
        //String sVal2 = (String) aVals.get(1);
        ArrayList<String> sVals = new ArrayList<>();
        sVals.add("Regina");
        //sVals.add(19);Not Allowed

    }
}
