package Chap13;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class TestCloneArrays {
    public static void main(String[] args) {
        ArrayList<Double> lst1 = new ArrayList<>();
        lst1.add(1.5);
        lst1.add(2.5);
        lst1.add(3.5);
        //create clone
        ArrayList<Double> lst2 = (ArrayList<Double>) lst1.clone();
        ArrayList<Double> lst3 = lst1;

        lst2.add(4.5);
        lst3.remove(1.5);

        System.out.printf("List 1: %s\n",lst1);
        System.out.printf("List 2: %s\n",lst2); // clone of lst1, completely separate data in Heap
        System.out.printf("List 3: %s\n",lst3); // Reference lst1, points to same memory address of lst1 on heap

        //same principle applies to standard array.
        int[] naVal1 = {1,2};
        int[] naVal2 = naVal1.clone();
    }

}
