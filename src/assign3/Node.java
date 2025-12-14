package assign3;

public class Node<T>
{
    private T data;
    private Node<T> next;
    public Node(T obData)
    {
        this.data = obData;
        this.next = null;
    }

    public T getData()
    {
        return data;
    }
    public Node<T> getNext()
    {
        return next;
    }

    public void setNext(Node<T> obNext)
    {
        next = obNext;

    }



}
