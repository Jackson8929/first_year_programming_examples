package Chap13;
import Horses.*;


import java.util.ArrayList;
import java.util.Collections;

public class TestHorses
{
    public static void main(String[] args)
    {
        ArrayList<Horse> lstTrack = HorseInfo.getInfo();
//
//        for(Horse obHorse : lstTrack)
//        {
//            System.out.println(obHorse);
//        }
//
//        //Let us sort this by speed
//        Collections.sort(lstTrack);
//
//        showTrack("Sorted by Age", lstTrack);
//
//        // Use the defined COmparator to sort by speed
//        Collections.sort(lstTrack, new CompSpeed());
//        showTrack("Sorted by Speed", lstTrack);
//
//        //Do another sort this time by speed in descending fashion
//        // Step 1: create another comparator
//        //Reverse the sense of the previous comparison
//        //Sort this using collections.sort
//
//        Collections.sort(lstTrack, new compSpeedRev());
//
//        showTrack("Sorted by Speed reversed",lstTrack);
//
//        //Age ascending
//        Collections.sort(lstTrack, new compAge());
//
//        showTrack("Sorted by Speed reversed",lstTrack);

        ArrayList<Horse> obFiltered = getBreedList(lstTrack, "Mustang");
        System.out.printf("\nOnly Mustangs\n");

        //get speed

        int nFastSpeed = getFastestSpeed(lstTrack);
        System.out.println(nFastSpeed);

        //Get fastSpeed list
        System.out.println();
        System.out.println();
        System.out.println("Fastest speed list");

        ArrayList<Horse> Fastest = getFastList(lstTrack);
        for (Horse obHorse : Fastest)
        {
            System.out.println(obHorse);
        }


    }

    public static void showTrack(String sTitle, ArrayList<Horse> lstHorse)
    {
        System.out.printf("\n\n%s\n",sTitle);
        for (Horse obHorse : lstHorse)
        {
            System.out.println(obHorse);
        }
    }


    /**
     * Method will return an Array list of horses based upon the breed provided
     * @param obList Original horse list.
     * @param sBreed String of breed to search for.
     * @return
     */
    public static ArrayList<Horse> getBreedList(ArrayList<Horse> obList, String sBreed)
    {
        ArrayList<Horse> lstReturn = new ArrayList<>();
        for (Horse obHorse : obList) {
            if (obHorse.getBreed().equals(sBreed))
            {
                lstReturn.add(obHorse);
            }
        }
        return lstReturn;
    }

    public static int getFastestSpeed(ArrayList<Horse> obList)
    {
        int nReturn = 0;
        //Sort array by greatest speed.
        Collections.sort(obList, new compSpeedRev());
        // return first val
        nReturn = obList.get(0).getSpeedFactor();

        return nReturn;
    }

    public static ArrayList<Horse> getFastList(ArrayList<Horse> obList)
    {
        ArrayList<Horse> obReturn= new ArrayList<>();
        int nFastest = getFastestSpeed(obList);

        for (Horse obHorse : obList) {
            if (obHorse.getSpeedFactor() == nFastest)
            {
                obReturn.add(obHorse);
            }
        }
        return obReturn;
    }

}
