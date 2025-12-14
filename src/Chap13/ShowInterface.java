package Chap13;

import java.util.Arrays;

public class ShowInterface {
    public static void main(String[] args) {
        String[] saVals = {"Bryce","Coralee","Wade","Erneston", "Derrick"};

        Arrays.sort(saVals);

        Integer obVal = 7;


        for (String sVal : saVals)
        {
            System.out.println(sVal);
        }
    }
}
