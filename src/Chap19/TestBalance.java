package Chap19;

import Chap19.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestBalance
{
    public static void main(String[] args)
    {
        Integer[] aVals = {3,7,8,9,11,14,17,19,21};





        //ArrayList<Integer> listVals = new ArrayList<>( Arrays.asList(aVals));

        ArrayList<Integer> listVals = new ArrayList<>();

        Random obRandom = new Random(777);
        for (int i=0; i< 200; i++)
        {
            listVals.add(obRandom.nextInt(0,501) );

        }
        Collections.sort(listVals);

        BinaryTree<Integer> bIntTree = new BinaryTree<>();
        bIntTree.transfer(listVals);
        System.out.println(bIntTree.inOrder());
        System.out.printf("The height of the tree is %d\n", bIntTree.height());

        Integer obVal = bIntTree.search(180);


    }
}
