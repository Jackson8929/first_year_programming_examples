package Chap17;

import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteTest
{
    public static void main(String[] args)
    {
        String[] saNames = {"Bryce","Ron","William","Doug"};

        try(RandomAccessFile obRaf = new RandomAccessFile("files/names.raf","rw"))
        {
            for (String sVal : saNames)
            {
                Utils.writeStringToRaf(sVal,obRaf,5);
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }

}
