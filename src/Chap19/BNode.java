package Chap19;

public class BNode<T>
{
    private T Data;
    private BNode<T>left,right;

    public BNode(T data)
    {
        this.Data = data;
        this.left = null;
        this.right = null;
    }

    public T getData()
    {
        return Data;
    }

    public void setData(T data)
    {
        Data = data;
    }

    public BNode<T> getLeft()
    {
        return left;
    }

    public void setLeft(BNode<T> left)
    {
        this.left = left;
    }

    public BNode<T> getRight()
    {
        return right;
    }

    public void setRight(BNode<T> right)
    {
        this.right = right;
    }
}
