package assign3.Tests;

import assign3.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest
{

    @Test
    void toArray()
    {
        BinaryTree<Integer> lstInt = new BinaryTree<>();
        lstInt.insert(4);
        lstInt.insert(1);
        lstInt.insert(7);
        lstInt.insert(2);
        lstInt.insert(10);

        Integer[] obLst = lstInt.toArray();;

        for (Integer h : obLst)
        {
            System.out.println(h);
        }

        Integer[] obExpected = {2,1,4,7,10};
       assertArrayEquals(obExpected, lstInt.toArray());
    }
}