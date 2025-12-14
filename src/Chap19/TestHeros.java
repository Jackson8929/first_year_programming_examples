package Chap19;

import java.util.ArrayList;

public class TestHeros
{
    public static void main(String[] args)
    {
        ArrayList<Hero> lstHero = Utils.genCSVRead1("files/heros.csv", new Hero("","",""));
    }
}
