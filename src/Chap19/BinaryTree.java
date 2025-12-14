package Chap19;

import Chap19.BNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree<T extends  Comparable<T>>

{

    BNode<T> root ;

    public  BinaryTree()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void insert(T obData, Comparator<T> obComp)
    {
        if (root == null)
        {
            root = new BNode<>(obData);
            return;
        }
        recInsert(root,obData,obComp);
    }

    private BNode<T> recInsert(BNode<T>current,T obData, Comparator<T> obComp)
    {
        if (current == null)
        {
            return new BNode<>(obData);
        }

        if(obComp.compare(current.getData(), obData) > 0 )
        {
            current.setLeft(recInsert(current.getLeft(), obData,obComp));
        }
        else
        {
            current.setRight(recInsert(current.getRight(),obData,obComp));
        }

        return current;
    }

    public void insert(T obData)
    {
        if (root == null)
        {
            root = new BNode<>(obData);
            return;

        }
        recInsert(root, obData);
    }

    public BNode<T > recInsert (BNode<T> current, T obData)
    {
        if (current == null)
        {
            return new BNode<>(obData);
        }

        if (current.getData().compareTo(obData) > 0)
        {
            current.setLeft(recInsert(current.getLeft(), obData));
        }
        else
        {
            current.setRight(recInsert(current.getRight(),obData));
        }

        return current;

    }

    /**
     * Method returns a string which comprizes the toString values for each of the data elements expressed in an inorder fashion
     * @return
     */
    public String inOrder()
    {
        return recInOrder(root.getLeft()) + " " + root.getData() + " " + recInOrder(root.getRight());

    }

    public String recInOrder(BNode<T> current)
    {
        //Base case
        if (current == null)
        {
            return "";
        }

        return recInOrder(current.getLeft()) + " " + current.getData() + " " + recInOrder(current.getRight());


    }

    public String postOrder()
    {
        return recPostOrder(root.getLeft()) + " " + recPostOrder(root.getRight()) + " " + root.getData();

    }

    public String recPostOrder(BNode<T> current)
    {
        if (current == null)
        {
            return "";
        }

        return recPostOrder(current.getLeft()) + " " + recPostOrder(current.getRight()) + " " +  current.getData();

    }

    public int height()
    {
        return Math.max(recHeight(root.getLeft()), recHeight(root.getRight()));

    }

    public int recHeight(BNode<T> current)
    {
        if (current == null)
        {
            return 0;
        }

        return 1 + Math.max(recHeight(current.getLeft()), recHeight(current.getRight()));


    }

    /**
     * This method will take in an array of values of type T and placed these values into a binary tree that  will be
     * balanced (Essentially all height will be within 1 of each other)
     * @param aVals
     */
    public void transfer(ArrayList<T> aVals)
    {

            int nMid = aVals.size()/2;

            root = new BNode<>(aVals.get(nMid));

            root.setLeft(recTransfer(aVals.subList(0,nMid)));
            root.setRight(recTransfer(aVals.subList(nMid+1, aVals.size())));

    }


    public BNode<T> recTransfer(List<T> obList)
    {

        //Base Case
        if (obList.size() == 0)
        {
            return null;
        }

        if (obList.size() ==1)
        {
            return new BNode<>(obList.get(0));
        }

        //int nMid = obList.size() % 2 == 0 ? obList.size() /2 -1 : obList.size()/2;
        int nMid = obList.size() / 2;

        BNode current = new BNode( obList.get(nMid));
        current.setLeft(recTransfer(obList.subList(0,nMid)));
        current.setRight(recTransfer(obList.subList(nMid+1, obList.size())));

        return current;

    }


    /**
     * This method will attempt to search for an element in the binary tree using a recursive methodlogy
     * @param obData
     * @return
     */
    public T search(T obData)
    {

        return recSearch (root, obData);



    }

    public T recSearch(BNode<T> current, T obData)
    {
        if (current == null)
        {
            return null;
        }

        if (current.getData().equals(obData))
        {
            return current.getData();
        }

        if (current.getData().compareTo(obData) > 0)
        {
            return recSearch(current.getLeft(), obData);
        }

        return recSearch(current.getRight(), obData);
    }




}
