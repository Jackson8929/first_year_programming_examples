package assign3;

import Chap19.LList;

import java.lang.reflect.Array;
import java.util.Iterator;

public class OLList <T extends Comparable<T>> implements Iterable<T>
{
    private Node<T> head;
    private boolean deleted;
    public OLList()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public boolean remove(T obData)
    {
        deleted = false;
        head = recRemove(head, obData);
        return deleted;
    }

    public Node<T> recRemove(Node<T> obCurrent, T obData)
    {
        //base case 1
        if (obCurrent == null)
        {
            return null;
        }

        int nComp = obCurrent.getData().compareTo(obData);

        //Base Case 2
        if (nComp == 0)
        {
            deleted = true;
            return obCurrent.getNext();
        }

        //Base Case 3
        if (nComp > 0)
        {
            return obCurrent;
        }

        //Recursion
        obCurrent.setNext(recRemove(obCurrent.getNext(), obData));
        return obCurrent;




    }

    public void add(T obData)
    {
        head = recAdd(head, obData);
    }

    public Node<T> recAdd(Node<T> obCurrent, T obData)
    {
        //base Case
        if (obCurrent == null)
        {
            return new Node<>(obData);

        }

        //Base Case 2 insertion point
        if (obCurrent.getData().compareTo(obData) > 0)
        {
            //this is the isertion point
            Node<T> newNode = new Node<>(obData);
            newNode.setNext(obCurrent);
            return newNode;

        }

        obCurrent.setNext(recAdd(obCurrent.getNext(), obData));
        return obCurrent;


    }


    @Override
    public String toString()
    {
        String sReturn = recToString(head);
        return sReturn.substring(0, sReturn.length()-1);

    }

    public String recToString(Node<T> obCurrent)
    {
        //Base Case dropped off end of list
        if (obCurrent == null)
        {
            return "";

        }

        return obCurrent.getData().toString() + ":" + recToString(obCurrent.getNext());

    }

    /**
     * Get the number of elements in the list
     * @return
     */
    public int size()
    {
        return recSize(head);
    }

    public int recSize(Node<T> obCurrent)
    {
        //base case
        if (obCurrent == null)
        {
            return 0;
        }

        return 1 + recSize(obCurrent.getNext());
    }

    @SuppressWarnings("unchecked")
    public T[] toArray()
    {
        if (head == null)
        {
            return null;
        }
        T[] aVals = (T[]) Array.newInstance(head.getData().getClass(), size());

        recToArray(head, aVals, 0);

        return aVals;


    }

    public void recToArray(Node<T> obCurrent, T[] aVals, int nCurPos)
    {
        if (obCurrent == null)
        {
            return;
        }

        //Set the current position in the array to have the data element
        aVals[nCurPos] = obCurrent.getData();

        //Tell the rest of the linked list to fill in additional array values
        recToArray(obCurrent.getNext(), aVals, nCurPos+1);



    }


    @Override
    public Iterator<T> iterator()
    {
        return new OLLIt<>(head);

    }

    /**
     * Will return a link list at the specified node to split at.
     * @param obSplit
     * @return
     */
    public OLList<T> split(T obSplit)
    {
        Node<T> getList = recSplit(this.head,obSplit);

        OLList<T> obReturn = new OLList<T>();
        obReturn.head = getList;

        return obReturn;
    }

    /**
     * Helper Method for split
     *
     * @param current
     * @return
     */
    private Node<T> recSplit(Node<T> current, T obFind)
    {
        //current is null
        if (current == null)
        {
            return null;
        }

        //first case found current node is what we are looking for
        if (current.getData().equals(obFind))
        {
            return current;
        }

        return recSplit(current.getNext(),obFind);
    }

    /**
     * This method will append another OLList to the a copy of the current OLList and return a new one.
     * @param other
     * @return
     */
    public OLList<T> join(OLList<T> other)
    {
        OLList<T> obNew = this;

        OLLIt<T> ObIt = new OLLIt<>(other.head);

        while (ObIt.hasNext())
        {
            T obCurrent = ObIt.next();
            obNew.add(obCurrent);

        }

        return obNew;
    }

    /**
     * This method will add the array to the current OLList object.
     * @param aVals
     */
    public void addArray(T[] aVals)
    {
        for (T obVals : aVals)
        {
            add(obVals);
        }
    }

    public boolean equals(LList<T> obOther)
    {

        return false;
    }

    /**
     * This method will return a new ordered list with values including and after the nStart
     * @param nStart
     * @return
     */
    public OLList<T> subList(int nStart)
    {
        OLList<T> lstReturn = new OLList<>();

        recSubList(this.head,lstReturn,0,nStart);

        return lstReturn;
    }

    /**
     * This method will return a new ordered list with values including and after the nStart. Until and Excluding nIndex
     * @param nStart
     * @param nIndex
     * @return
     */
    public OLList<T> subList(int nStart,int nIndex)
    {
        OLList<T> lstReturn = new OLList<>();

        recSubList(this.head,lstReturn,0,nStart,nIndex);

        return lstReturn;
    }

    /**
     * Helper method for sublist
     * @param obCurrent
     * @param lstReturn
     * @param nPosition
     * @param nStart
     */
    private void recSubList(Node<T> obCurrent,OLList<T> lstReturn, int nPosition, int nStart)
    {
        //null
        if (obCurrent == null)
        {
            return;
        }

        //Check to see if at start
        if (nPosition >= nStart)
        {
            lstReturn.add(obCurrent.getData());
        }

        nPosition++;
        recSubList(obCurrent.getNext(), lstReturn, nPosition, nStart);
    }

    /**
     * Helper method for sublist with nIndex
     * @param obCurrent
     * @param lstReturn
     * @param nPosition
     * @param nStart
     * @param nIndex
     */
    private void recSubList(Node<T> obCurrent,OLList<T> lstReturn, int nPosition, int nStart, int nIndex)
    {
        //null
        if (obCurrent == null)
        {
            return;
        }

        //Check to see if at start
        if (nPosition >= nStart && nPosition < nIndex)
        {
            lstReturn.add(obCurrent.getData());
        }

        nPosition++;
        recSubList(obCurrent.getNext(), lstReturn, nPosition, nStart, nIndex);
    }

    //remove question
    //You will provide the following method for accessing and removing the following  elements from an ordered linked list.
    // They will respectively remove the middle, first and last elements from a linked list.
    // Note that  you will have to “mark” these elements somehow when removing them
    // (you must maintain the rest of the linked list

    public T deQueueMiddle()
    {
        int nIndex = this.size() / 2;
        T obReturn = indexAt(this.head,1,nIndex);
        remove(obReturn);

        return obReturn;
    }
    public T deQueueFirst()
    {
        T obReturn = this.head.getData();
        remove(obReturn);
        return obReturn;
    }

    public T deQueueLast()
    {
        int nIndex = this.size();
        T obReturn = indexAt(this.head,1,nIndex);
        remove(obReturn);
        return obReturn;
    }

    /**
     * Will find the data associated at the index given.
     * @param obCurrent
     * @param nPos Should always be 1
     * @param nIndex
     * @return
     */
    private T indexAt(Node<T> obCurrent,int nPos,int nIndex)
    {
        //null
        if (obCurrent == null)
        {
            return null;
        }

        if (nIndex == nPos)
        {
            return obCurrent.getData();
        }
        nPos++;

        return indexAt(obCurrent.getNext(),nPos,nIndex);
    }
}
