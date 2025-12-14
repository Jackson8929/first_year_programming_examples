package Chap19;

import java.util.Iterator;

public class DLList<T extends Comparable<T>> implements Iterable<T>
{
    //THIS SHIT IS FUCKED!
    DNode<T>head;
    DNode<T>tail;

    public DLList()
    {
        this.head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public T getLast()
    {
        if (tail != null)
        {
            return tail.getData();
        }
        else
            return null;
    }

    public void add(T obNew)
    {
        if (head == null)
        {
            head = new DNode<>(obNew);
        }
        DNode<T> obReturn= recAdd(head,obNew);

        if (head != obReturn)
        {
            //head changed
            head.setPrev(obReturn);
        }
        head = obReturn;

//        this.head= recAdd(head,obNew);

    }

    private DNode<T> recAdd(DNode<T> current, T obData)
    {
        if (current == null)
        {
            tail= new DNode<>(obData);
            return tail;
        }

        if (current.getData().compareTo(obData) > 0)
        {
            DNode<T> obNewNode = new DNode<T>(obData);

            if (current.getNext() != null)
            {
                obNewNode.setNext(current.getNext());
                current.getNext().setPrev(obNewNode);


            }
            return obNewNode;
        }

            current.setNext(recAdd(current.getNext(),obData));
            if (current.getNext() != null)
            {
                current.getNext().setPrev(current);
            }
            return current;
        }

    @Override
    public Iterator<T> iterator()
    {
        return new DLLIt<>(head);
    }
}
