package Chap19;

public class Exercise1
{
    public static void main(String[] args)
    {
        LList<String> lstNames = new LList<>();

        lstNames.add("Bob");
        lstNames.add("Sheldon");
        lstNames.add("Jane");
        lstNames.add("Paul");

        System.out.println(lstNames.gatherReverse());
    }
}
