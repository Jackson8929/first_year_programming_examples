package Chap19;


import java.util.ArrayList;

public class GenericStack<E>
{
    private ArrayList<E> list;

    public GenericStack()
    {
        list = new ArrayList<>();
    }

    /**
     * Returns number of elements in class.
     * @return
     */
    public int getSize()
    {
        return this.list.size();
    }

    /**
     * Peeks at element
     * @return
     */
    public E peek()
    {
        if (isEmpty())
        {
            return null;
        }

        return list.get(list.size()-1);
    }

    /**
     * Adds new element
     * @param obNew
     */
    public void push(E obNew)
    {
        list.add(obNew);
    }

    /**
     * pops element and returns it
     * @return
     */
    public E pop()
    {
        if(isEmpty())
        {
            return null;
        }

        E obTemp = list.get(list.size()-1);
        list.remove(list.size() -1);
        return obTemp;
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}
