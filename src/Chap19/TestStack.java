package Chap19;

public class TestStack
{
    public static void main(String[] args)
    {
        ///Create a Stack of Integers
        GenericStack<Integer> intStack = new GenericStack<>();

        intStack.push(19);
        intStack.push(23);
        System.out.println(intStack.peek());

        System.out.println(intStack.pop());
        System.out.println(intStack.peek());

        //Create a stack of Strings and place 3 entries on to it

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("hi");
        stringStack.push("bye");
        stringStack.push("here");

        while(!stringStack.isEmpty())
        {
            System.out.println(stringStack.pop());
        }
    }
}
