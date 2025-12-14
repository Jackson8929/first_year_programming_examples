package Chap19;

/**
 * An implementation of and unordered linked list
 * @param <T>
 */
public class LList<T>
{
    private Node<T> head;
    private boolean deleted;

    public LList()
    {
        this.head = null;
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Recursive starter routine for adding a new element
     * @param obData
     */
    public void add(T obData)
    {
        head = recAdd(head,obData);

    }
    public Node<T> recAdd(Node<T> obCurrent, T obData)
    {
        if (obCurrent == null)
        {
            return new Node(obData);
        }

        //Rec case
        obCurrent.setNext(recAdd(obCurrent.getNext(),obData));
        return obCurrent;

    }

    @Override
    public String toString()
    {
        String sReturn = recToString(head);
        return sReturn.substring(0,sReturn.length()-2);
    }

    private String recToString(Node<T>obCurrent)
    {
        if (obCurrent ==null)
        {
            return "";
        }
        return obCurrent.getData().toString()+": " + recToString(obCurrent.getNext());
    }

    /**
     *
     * @param obData
     */
    public T Search(T obData)
    {
        return recSearch(head,obData);
    }

    private T recSearch(Node<T> obCurrent, T obData)
    {
        //Base case off the end
        if (obCurrent == null)
        {
            return null;
        }

        //element we found
        if (obCurrent.getData().equals(obData))
        {
            return obCurrent.getData();
        }

        //Recursive forward
        return recSearch(obCurrent.getNext(),obData);

    }

    public boolean remove(T obData)
    {
        deleted = false;
        head = recRemove(head,obData);

        return deleted;
    }

    private Node<T> recRemove(Node<T> obCurrent, T obData)
    {
        //base case 1
        if (obCurrent == null)
        {
            return null;
        }

        //Base Case 2: element found
        if (obCurrent.getData().equals(obData))
        {
            deleted = true;
            return obCurrent.getNext();
        }

        //Recursion
        obCurrent.setNext(recRemove(obCurrent.getNext(),obData));
        return obCurrent;
    }

    public LList<T>gatherReverse()
    {
        LList<T>lstReturn=new LList<>();
        recReverse(head,lstReturn);
        return lstReturn;
    }

    private void recReverse(Node<T> obCurrent, LList<T>lstReturn)
    {
        // At end of list
        if (obCurrent == null)
        {
            return;
        }

        recReverse(obCurrent.getNext(),lstReturn);
        lstReturn.add(obCurrent.getData());
        return;

    }
}
