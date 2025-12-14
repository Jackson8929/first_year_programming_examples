package Chap17;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class readTest
{
    public static void main(String[] args)
    {
        ArrayList<String> lstString = new ArrayList<>();
        try(RandomAccessFile obRaf = new RandomAccessFile("files/names.raf","r"))
        {
            while (obRaf.getFilePointer() < obRaf.length())
            {
                String sVal = Utils.readStringFromRaf(obRaf,5);
                lstString.add(sVal);
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

        for (String sName : lstString)
        {
            System.out.println(sName);
        }
    }
}
