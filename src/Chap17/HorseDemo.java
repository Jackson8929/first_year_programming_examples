package Chap17;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HorseDemo
{
    public static void main(String[] args)
    {
        /*ArrayList<FileHorse> lstHorse = getInfo("files/Horses.csv");

        for (FileHorse obHorse : lstHorse)
        {
            System.out.println(obHorse);
        }

        writeSerializedHorse("files/horses.obj",lstHorse);*/

        ArrayList<FileHorse> lstHorse = readSerializedHorse("files/horses.obj");

        for (FileHorse obHorse : lstHorse)
        {
            System.out.println(obHorse);
        }
    }

    /**
     * Reads csv info of horses.
     *
     * @param sFileName
     * @return
     */
    public static ArrayList<FileHorse> getInfo(String sFileName)
    {
        ArrayList<FileHorse> horseList = new ArrayList<>();

        try (Scanner obIn = new Scanner(new File(sFileName)))
        {
            obIn.nextLine();
            while (obIn.hasNextLine())
            {
                horseList.add(new FileHorse(Utils.parseCSVLine(obIn.nextLine())));
            }
        } catch (IOException exp)
        {
            exp.printStackTrace();
        }

        return horseList;
    }
    // TODO: missing code for this class 2025-04-04

    public static void writeSerializedHorse(String sFilePath, ArrayList<FileHorse> obInfo)
    {
        try(ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(sFilePath)))
        {
            for (FileHorse obHorse : obInfo)
            {
                obOut.writeObject(obHorse);
            }

        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

    }

    public static ArrayList<FileHorse> readSerializedHorse(String sFilePath)
    {
        ArrayList<FileHorse> obInfo = new ArrayList<>();
        try(ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(sFilePath)))
        {

            FileHorse obHorse = (FileHorse)  obIn.readObject();
            obInfo.add(obHorse);

        }
        catch(IOException | ClassNotFoundException exp)
        {
            exp.printStackTrace();
        }

        return obInfo;
    }
}
