package Chap13;

import java.util.ArrayList;

import java.util.Collections;

public class Beastiry {
    public static void main(String[] args) {
        Monster obRef = new Greek("Medusa",77,12);

        ArrayList<Monster>lstMonsters = new ArrayList<>();
        lstMonsters.add(obRef);
        //lstMonsters.add(new Greek("Octupus",48,6));
        lstMonsters.add(new Greek("Minotaur",55,5));
        lstMonsters.add(new Greek("Kraken",75,4));
        lstMonsters.add(new Greek("Chimera",45,7));

        lstMonsters.add(new EvilEye("Beholder",99,1,50));
        lstMonsters.add(new EvilEye("Gorgon",93,2,25));
        lstMonsters.add(new EvilEye("Mind Flayer",72,2,45));

        lstMonsters.add(new Lucky("Leprechaun",0,9,"Gives Gold"));
        lstMonsters.add(new Lucky("Genie",5,8,"Grants Wishes"));
        lstMonsters.add(new Lucky("Fairy Queen",10,7,"Give Advice"));

        lstMonsters.add(new UnDead("Vampire",99,8,true));
        lstMonsters.add(new UnDead("Zombies",33,2,false));
        lstMonsters.add(new UnDead("Wraith",89,7,true));

        for (Monster obMon : lstMonsters)
        {
            System.out.println(obMon);
        }

        System.out.println("Filter nScare");
        System.out.println();
        for (Monster obMon : getScariest(lstMonsters, 66))
        {
            System.out.println(obMon);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        //Convert this Arraylist into an Array and then use the arrays to sort that
        Collections.sort(lstMonsters);

//        Monster[] aMonsters = lstMonsters.toArray(Monster[]::new);
//        Arrays.sort(aMonsters);

        for (Monster obMon : lstMonsters) {
            System.out.println(obMon);
        }

        System.out.println("\n\nList of Fast Monsters");


        for (Fast obMon : getFastMonsters(lstMonsters))
        {
            System.out.println(obMon);
        }



    }

    /**
     * This method given a list of monsters will be responsible for returning a new list of monsters with a
     * scare factor greater than others
     * @param obList Monster list
     * @param nScareFactor Int to check
     * @return The new Monster list.
     */
    public static ArrayList<Monster>getScariest(ArrayList<Monster> obList, int nScareFactor) {
        ArrayList<Monster> obRet= new ArrayList<>();

        for (Monster obMon : obList)
        {
            if (obMon.getScareFactor() > nScareFactor)
            {
                obRet.add(obMon);
            }
        }

        return obRet;
    }

    /**
     * This method will return an Array list of fast monsters
     * @param obList the monster list
     * @return the return list
     */
    public static ArrayList<Fast> getFastMonsters(ArrayList<Monster> obList) {
        ArrayList<Fast> lstReturn = new ArrayList<>();

        for (Fast Mon : obList) {
            if (Mon.isFast())
            {
                lstReturn.add(Mon);
            }
        }
        return lstReturn;
    }
}
