package Chap19;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice
{
    private static ArrayList<TreeSpecies>loadList(String sFileName) throws IOException
    {
        ArrayList<TreeSpecies> lstReturn = new ArrayList<>();

        File obFile = new File(sFileName);
        Scanner obIn = new Scanner(obFile);
        obIn.nextLine();

        while (obIn.hasNextLine())
        {
            String sVal=obIn.nextLine();
            String[] saVal = Utils.parseCSVLine(sVal);
            lstReturn.add(new TreeSpecies(saVal));
        }
        return lstReturn;

    }

    public static void main(String[] args) throws IOException
    {
        ArrayList<TreeSpecies>lstTrees = loadList("files/Trees.csv");
/*        for (TreeSpecies obTreeSpecies : lstTrees)
        {
            System.out.println(obTreeSpecies);
        }*/

        Collections.sort(lstTrees,new CompHeight());
        for (TreeSpecies obTreeSpecies : lstTrees)
        {
            System.out.println(obTreeSpecies);
        }

        BinaryTree<TreeSpecies>forest=new BinaryTree<>();
        forest.transfer(lstTrees);
    }
}
