package Chap17;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Carstuff
{
    public static void main(String[] args)
    {
        ArrayList<Car> lstCar = readInfo("files/cars.csv");
        for (Car obCar : lstCar)
        {
            System.out.println(obCar);
        }
        writeDataInfo("files/cars.dat", lstCar);
        for (Car obCar : readFromDatFile("files/cars.dat"))
        {
            System.out.println(obCar);
        }

        dumpRecs("files/cars.raf",lstCar);

        int sNameMax = 0;
        int sOriginMax = 0;
/*
        for (Car obCar : lstCar)
        {
            if (obCar.getName().length() > sNameMax)
            {
                sNameMax = obCar.getName().length();

            }
            if (obCar.getOrigin().length() > sOriginMax)
            {
                sOriginMax = obCar.getOrigin().length();
            }
        }
        System.out.println(sNameMax);
        System.out.println(sOriginMax);*/

    }



    /**
     * Standerdized method for reading from a csv File.  Boy it sure would be nice if we
     * didn't have to do this every time.....
     * @param sFile
     * @return
     */
    public static ArrayList<Car> readInfo(String sFile)
    {
        ArrayList<Car> lstReturn = new ArrayList<>();

        try (Scanner obIn = new Scanner(new File(sFile)))
        {
            obIn.nextLine();  //Get rid of the header line
            while (obIn.hasNextLine())
            {
                lstReturn.add(new Car(Utils.parseCSVLine(obIn.nextLine())));
            }

        }
        catch (IOException exp)
        {
            exp.printStackTrace();

        }

        return lstReturn;
    }

    public static void writeDataInfo(String sFileName, ArrayList<Car> lstCar)
    {
        try (DataOutputStream obOut = new DataOutputStream(new FileOutputStream(sFileName)))
        {
            for (Car obCar : lstCar)
            {
                obCar.writeToDatFile(obOut);
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();;
        }
    }

    public static ArrayList<Car> readFromDatFile(String sFileName)
    {

        ArrayList<Car> lstReturn = new ArrayList<>();

        try (DataInputStream obIn = new DataInputStream(new FileInputStream(sFileName)))
        {
            while (obIn.available() > 0)
            {
                lstReturn.add(Car.readFromDataFile(obIn));
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

        return lstReturn;

    }

    public static void dumpRecs(String sName, ArrayList<Car>lstCar)
    {
        try(RandomAccessFile obRaf = new RandomAccessFile(sName,"rw"))
        {
            for (Car obCar : lstCar)
            {
                obCar.writeRecToRaf(obRaf);
            }

        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

    }
}
