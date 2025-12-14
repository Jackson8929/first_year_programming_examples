package Chap19;

import java.util.Iterator;

public class OLLIt <T> implements Iterator<T>
{
    Node<T>current;

    public OLLIt(Node<T>head)
    {
        current = head;
    }
    @Override
    public boolean hasNext()
    {
        return current != null;
    }

    @Override
    public T next()
    {
        T obReturn = current.getData();
        current = current.getNext();
        return obReturn;
    }
}
