package Chap19;

public class LLTest
{
    public static void main(String[] args)
    {
        LList<String>lstName = new LList<>();
        lstName.add("Bryce");
        lstName.add("Ron");
        lstName.add("Rick");
        lstName.add("Coralee");

        if (lstName.remove("Coralee"))
        {
            System.out.println("Successfull");
        }
        else
        {
            System.out.println("could not find element to remove");
        }


    }
}
