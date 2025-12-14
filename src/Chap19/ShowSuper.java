package Chap19;

import Chap13.EvilEye;
import Chap13.Greek;

public class ShowSuper
{
    public static void main(String[] args)
    {
        GenericStack<Chap13.Monster> stMonsters = new GenericStack<>();

        stMonsters.push(new Greek("Minotaur",3,3));
        stMonsters.push(new Greek("Cyclops",4,4));

        GenericStack<Chap13.EvilEye> Evil = new GenericStack<>();
        Evil.push(new EvilEye("BeHolder",9,2,12));
        Evil.push(new EvilEye("Medusa",3,9,12));

        add(Evil,stMonsters);
        //add(stMonsters,Evil) will not work because evil is not a superclass of monsters;

        System.out.printf("is Evil empty %b\n",Evil.isEmpty());

        while (!stMonsters.isEmpty())
        {
            System.out.println(stMonsters.pop());
        }

    }

    public static <T> void add(GenericStack<T> obStack1, GenericStack<? super T> obStack2)
    {
        while(!obStack1.isEmpty())
        {
            obStack2.push(obStack1.pop());
        }
    }

    public static <T>void add2(GenericStack <? extends T>obStack1, GenericStack<T> obStack2)
    {
        while (!obStack1.isEmpty())
        {
            obStack2.push(obStack1.pop());
        }
    }
}
