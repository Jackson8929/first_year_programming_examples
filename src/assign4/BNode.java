package assign4;

public class BNode <T>
{

    private T data;
    private BNode<T> left,right;

    public BNode(T data)
    {
        this.data = data;
    }

    public void setLeft(BNode<T> left)
    {
        this.left = left;
    }

    public void setRight(BNode<T> right)
    {
        this.right = right;
    }

    public T getData()
    {
        return data;
    }

    public BNode<T> getLeft()
    {
        return left;
    }

    public BNode<T> getRight()
    {
        return right;
    }
}
