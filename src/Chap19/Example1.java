package Chap19;

import Chap17.Car;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Example1
{

    public static void main(String[] args)
    {
        //Test
        Integer[] naVals = {17,22,19,33,44};
        String[] saVals = {"Bryce","Coralee","Ben","Wade"};

        writeInfo(naVals, new File("files/intdump.txt"));
        writeInfo(saVals, new File("files/stringdump.txt"));

        //This will not work

        //int[] naVals2 = {19,33,17};
        //writeInfo(naVals2, new File("Bad.txt"));

        Double[] daVals = {17.2,19.3,8.7};
        writeInfo(daVals, new File("files/doubleDump.txt"));

        Car[] aCars = {
                new Car("Daytona",27.2,(byte)4, (short) 145, (short) 1500,"US/Canada"),
                new Car("Fusion",33.1, (byte) 6, (short) 180, (short) 1800,"US")
        };

        writeInfo(aCars,new File("files/altCar.txt"));

        System.out.printf("The Biggest int is %d\n", Biggest(naVals));
        System.out.printf("The Biggest string is %s\n",Biggest(saVals));
        System.out.printf("The Biggest double is %.2f\n",Biggest(daVals));
        System.out.printf("The Biggest Car is %s\n",Biggest(aCars));

        selSort(naVals);

        for (Integer aVal : naVals)
        {
            System.out.println(aVal);
        }

        selSort(daVals);
        writeInfo(daVals, new File("files/doubleDump.txt"));

    }
    /**
     * Generic method which allows us to print a generic type to a file
     * @param aVals
     * @param obFile
     * @param <T>
     */
    public static <T> void writeInfo(T[] aVals, File obFile)
    {
        try (PrintWriter obWriter = new PrintWriter(obFile))
        {
            for (T obVal : aVals)
            {
                obWriter.println(obVal);
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

    }


    public static <T extends Comparable<T>> T Biggest(T[] aVals)
    {
        T obBig = aVals[0];
        for (int i = 1; i < aVals.length; i++)
        {
            if (aVals[i].compareTo(obBig) > 0)
            {
                obBig = aVals[i];
            }
        }

        return obBig;
    }

    /**
     * Generic Implementation of selSort.
     * @param aVals
     * @param <T>
     */
    public static <T extends Comparable<T>> void selSort(T[] aVals)
    {
        for(int nEnd = aVals.length-1; nEnd > 0; nEnd--)
        {
            T nCurrent = aVals[0];
            int nPos = 0;

            for (int i = 1; i<=nEnd; i++)
            {
                if (aVals[i].compareTo(nCurrent) > 0)
                {
                    nCurrent = aVals[i];
                    nPos = i;
                }
            }

            swap(aVals, nPos, nEnd);
        }
    }

    public static <T> void swap(T[] aVals, int nPos1,int nPos2)
    {
        T obTemp = aVals[nPos1];
        aVals[nPos1] = aVals[nPos2];
        aVals[nPos2] = obTemp;
    }


}
