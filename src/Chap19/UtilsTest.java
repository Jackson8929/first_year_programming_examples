package Chap19;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest
{

    @org.junit.jupiter.api.Test
    void convertToArray()
    {
        ArrayList<String> sLstVals = new ArrayList<>();
        sLstVals.add("hello");
        sLstVals.add("bruh");

        String[] saVals = Utils.convertToArray(sLstVals);
        String[] saExpected = {"hello","bruh"};

        assertArrayEquals(saVals,saExpected);

        ArrayList<Integer> lstVals = new ArrayList<>();

        lstVals.add(12);
        lstVals.add(10);
        lstVals.add(13);

        Integer[] aVals = {12,10,13};

        assertArrayEquals(aVals, Utils.convertToArray(lstVals));

        //Convert an Array as a list
        ArrayList<Integer> lstNVals = new ArrayList<>(Arrays.asList(aVals));
    }
}