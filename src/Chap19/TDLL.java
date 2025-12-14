package Chap19;

public class TDLL
{
    //THIS SHIT IS FUCKED!
    public static void main(String[] args)
    {
        DLList<String>lstNames = new DLList<>();

        lstNames.add("Bryce");
        lstNames.add("Coralee");
        lstNames.add("Ben");
        lstNames.add("a");
        lstNames.add("C");

        for (String sVal : lstNames)
        {
            System.out.println(sVal);
        }
    }
}
