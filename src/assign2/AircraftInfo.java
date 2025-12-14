package assign2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static assign2.Aircraft.writeRAFAircraft;

public class AircraftInfo
{
    //Jackson Kolenosky
    //2025-03-10

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<Aircraft> aircrafts = loadInfo("src/assign2/Aircraft.csv");

        writeRAFAircraft(aircrafts, "files/aircrafts.raf");

    }

    /**
     * This method should take in the name of the file that stores our aircraft information (Aircraft.cvs)
     * and return an ArrayList of Aircraft as defined above.
     *
     * @param sFileName
     * @return
     */
    public static ArrayList<Aircraft> loadInfo(String sFileName) throws IOException
    {
        ArrayList<Aircraft> lstReturn = new ArrayList<>();
        Scanner obIn = new Scanner(new File(sFileName));
        obIn.nextLine();

        while (obIn.hasNext())
        {
            String[] sAircraftInfo = parseCSVLine(obIn.nextLine());
            lstReturn.add(new Aircraft(sAircraftInfo));
        }
        obIn.close();

        return lstReturn;
    }





    private static String[] parseCSVLine(String sLine)
    {
        String sPattern = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";

        String[]  sFields = sLine.split(sPattern);
        for (int i = 0; i < sFields.length; i++) {
            // Get rid of residual double quotes
            sFields[i] = sFields[i].replace("\"", "");
        }
        return sFields;
    }


}
