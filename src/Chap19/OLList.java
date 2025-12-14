package Chap19;


import java.lang.reflect.Array;
import java.util.Iterator;

public class OLList < T extends Comparable<T>> implements Iterable<T>
{
    private Node<T>head;
    private boolean deleted;

    @Override
    public String toString()
    {
        String sReturn = recToString(head);
        return sReturn.substring(0,sReturn.length()-2);
    }

    public boolean remove(T obData)
    {
        deleted = false;
        head = recRemove(head,obData);
        return deleted;
    }

    private Node<T>recRemove(Node<T>obCurrent, T obData)
    {
        if (obCurrent == null)
        {
            return null;
        }

        int nComp = obCurrent.getData().compareTo(obData);

        if (nComp == 0)
        {
            deleted = true;
            return obCurrent.getNext();
        }

        if (nComp > 0)
        {
            return obCurrent;
        }


        obCurrent.setNext(recRemove(obCurrent.getNext(),obData));
        return obCurrent;
    }

    private String recToString(Node<T>obCurrent)
    {
        if (obCurrent ==null)
        {
            return "";
        }
        return obCurrent.getData().toString()+": " + recToString(obCurrent.getNext());
    }


    public boolean isEmpty() {return head == null;}

    public void add(T obData)
    {
        head = recAdd(head,obData);
    }

    private Node<T>recAdd(Node<T>obCurrent, T obData)
    {
        if (obCurrent == null) {return new Node<>(obData);}

        if (obCurrent.getData().compareTo(obData) > 0)
        {
            //this is the insertion point
            Node<T>newNode = new Node<>(obData);
            newNode.setNext(obCurrent);
            return newNode;
        }

        obCurrent.setNext(recAdd(obCurrent.getNext(),obData));
        return obCurrent;
    }

    /**
     * Get the number of elements in the list
     * @return
     */
    public int size()
    {
        int total = 0;
        total = recSize(head);
        return total;
    }

    /**
     * main loop for size()
     * @param obCurrent
     * @return
     */
    private int recSize(Node<T> obCurrent)
    {
        // first case end
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

        T[] aVals = (T[]) Array.newInstance(head.getData().getClass(),size());

        recToArray(head,aVals,0);
        return aVals;
    }

    private void recToArray(Node<T> obCurrent,T[] aVals, int nCurPos)
    {
        if (obCurrent == null)
        {
            return;
        }
        //
        aVals[nCurPos++] = obCurrent.getData();
        recToArray(obCurrent.getNext(),aVals,nCurPos);
        return;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new OLLIt<>(head);
    }
}
