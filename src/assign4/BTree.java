package assign4;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BTree <T extends  Comparable<T>>

{
    private BNode<T> root;
    private int count =0;

    public boolean isEmpty()
    {
        return root == null;
    }

    public BTree()
    {
        this.root = null;
    }

    //NEW ASSIGN4 CODE

    /**
     * Balance arraylist using comparator?
     * @param obComp
     */
    public void balance(Comparator <T> obComp)
    {

        //Copy bTree to Arraylist
        ArrayList<T> obList = new ArrayList<T>(List.of(toArray()));

        //Sort Arraylist
        obList.sort(obComp);

        //Clear first Node out
        root = null;

        //Re insert
        translate(obList);

    }



    //OG CODE

    public void insert(T obData, Comparator<T> obComp)
    {
        if (root == null)
        {
            root = new BNode<>(obData);
            return;
        }

        recInsert(root, obData, obComp);

    }

    public int size()
    {
       return size(root);

    }

    private int size(BNode<T> current)
    {
        if (current == null)
        {
            return 0;
        }

        return 1 + size(current.getLeft()) + size(current.getRight());
    }

    public T[] toArray()
    {
        if (root == null)
        {
            return null;
        }
        T[] aReturn = (T[]) Array.newInstance(root.getData().getClass(), size());
        recToArray(root, aReturn);
        return aReturn;
    }

    public boolean isBalanced()
    {
       return isBalanced(root);
    }

    public boolean isBalanced(BNode<T> current)
    {
        if (current == null)
        {
            return true;
        }
        if (recHeight(current.getLeft()) - recHeight(current.getRight()) > 1)
        {
            return false;
        }

        return isBalanced(current.getLeft()) && isBalanced(current.getRight());

    }

    public void recToArray(BNode<T> current, T[] aReturn)
    {
        if (current == null)
        {
            //Do Nothing
            return;
        }
        //Go Left
        recToArray(current.getLeft(), aReturn);

        //Add Element
        aReturn[count++] = current.getData();

        //Go Righ
        recToArray(current.getRight(), aReturn);
    }


    public BNode<T> recInsert(BNode<T> current, T obData,Comparator<T> obComp)
    {
        if (current == null)
        {
            return new BNode<>(obData);
        }

        if (obComp.compare(current.getData(),obData) > 0)
        {
            current.setLeft(recInsert(current.getLeft(),obData,obComp));
        }
        else
        {
            current.setRight(recInsert(current.getRight(),obData, obComp));
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

    public BNode<T> recInsert(BNode<T> current, T obData)
    {
        if (current == null)
        {
            return new BNode<>(obData);
        }

        if (current.getData().compareTo(obData) > 0)
        {
            current.setLeft(recInsert(current.getLeft(),obData));
        }
        else
        {
            current.setRight(recInsert(current.getRight(),obData));
        }

        return current;


    }

    /**
     * This is a method that will attempt to create a balanced tree given an ArrayList of T which is assumeed to
     * be sorted
     * @param sList
     */
    public void translate(ArrayList<T> sList)
    {
        //What is our root Node to be?
        //This is the mid point of the array the way we do this is based upon whether or not the
        //size of the array is an even number
        int nMid =  sList.size() %2 == 1 ? sList.size()/2 : sList.size()/2 -1 ;

        root = new BNode<>(sList.get(nMid));

        //Now give the LHS side of tree elements from the first half of the lsit
        root.setLeft(recTranslate(sList.subList(0, nMid)));
        root.setRight(recTranslate(sList.subList(nMid +1, sList.size())));


    }

    /**
     * Select the mid pont of the list as the root node of the subtree
     * Set the Left hand size to all Contents from the list up to that midpoing
     * Set the right hand side of the list to all the contents for the list past the midpoint
     * @param sList
     * @return
     */
    public BNode<T> recTranslate(List<T> sList)
    {
        //Base case 1
        if (sList == null || sList.size() == 0)
        {
            return null;
        }

        if (sList.size() == 1)
        {
            return new BNode<>(sList.get(0));
        }
        int nMid =  sList.size() %2 == 1 ? sList.size()/2 : sList.size()/2 -1 ;

        BNode<T> current = new BNode<>(sList.get(nMid));

        current.setLeft(recTranslate(sList.subList(0,nMid)));
        current.setRight(recTranslate(sList.subList(nMid+1, sList.size())));
        return current;





    }


    /**
     * We go left as far as we can and then add to a string as we come back out
     * @return
     */
    public String inOrder()
    {
        return recInOrder(root.getLeft()) + root.getData() + recInOrder(root.getRight());

    }

    public String recInOrder(BNode<T> obCurrent)
    {
        //Base Case
        if (obCurrent == null)
        {
            return "";
        }
        return recInOrder(obCurrent.getLeft()) + " "
               + obCurrent.getData() + " " + recInOrder(obCurrent.getRight());
    }

    public String preOrder()
    {
        return root.getData() + " " + recPreOrder(root.getLeft()) + " " + recPreOrder(root.getRight());

    }

    public String recPreOrder(BNode<T> current)
    {
        if (current == null)
        {
            return "";
        }
        return current.getData() + " " + recPreOrder(current.getLeft()) + " " +
                recPreOrder(current.getRight());
    }

    public String postOrder()
    {
        return  recPostOrder(root);
    }

    public String recPostOrder(BNode<T> current)
    {
        if (current == null)
        {
            return "";
        }

        return recPostOrder(current.getLeft()).trim() + " " + recPostOrder(current.getRight()).trim() + " " + current.getData();
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

    public T search(T obData)
    {
        return recSearch(root, obData);
    }

    /**
     * This method will undertake a recursive search on the binary tree for the given value.
     *
     * Simple
     * @param current
     * @param obData
     * @return
     */
    private T recSearch(BNode<T> current, T obData)
    {
        //base case
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
        else
        {
            return recSearch(current.getRight(), obData);
        }



    }

    /**
     * Method for returning an ArrayList of inorder values to the
     * @return
     */
    public ArrayList<T>  toList()
    {
        ArrayList<T> obRet = new ArrayList<>();
        recToList(this.root, obRet);

        return obRet;
    }

    public void recToList(BNode<T> current, ArrayList<T> obList)
    {
        if (current == null)
        {
            return;
        }
        recToList(current.getLeft(), obList);
        obList.add(current.getData());
        recToList(current.getRight(), obList);
    }






}
