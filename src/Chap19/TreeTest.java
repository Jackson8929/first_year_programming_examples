package Chap19;

import Chap19.BinaryTree;

public class TreeTest
{
    public static void main(String[] args)
    {
        BinaryTree<String> treeNames = new BinaryTree<>();

        treeNames.insert("Michael");
        treeNames.insert("Derrick");
        treeNames.insert("Harold");
        treeNames.insert("Frank");
        treeNames.insert("Bryce");
        treeNames.insert("Coralee");
        treeNames.insert("Ron");
        treeNames.insert("Rick");
        treeNames.insert("Wade");
        treeNames.insert("Dave");

        System.out.println(treeNames.inOrder());
        System.out.println(treeNames.postOrder());
        System.out.printf("The height of the tree is %d\n", treeNames.height());





    }
}
