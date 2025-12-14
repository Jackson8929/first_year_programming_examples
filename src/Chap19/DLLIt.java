package Chap19;

import java.util.Iterator;

public class DLLIt <T> implements Iterator<T>
{
    DNode<T> current;

    public DLLIt(DNode<T> obCurrent)
    {
        this.current = obCurrent;
    }
    @Override
    public boolean hasNext()
    {
        return current != null;
    }

    @Override
    public T next()
    {
        T obRet = current.getData();
        current = current.getNext();

        return obRet;
    }
}
