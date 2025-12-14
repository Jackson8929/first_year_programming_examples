package Chap17;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class WriteInts
{
    public static void main(String[] args)
    {
        Random obRandom = new Random();

        int[] naVals = new int[10];

        for (int i=0; i< naVals.length;i++)
        {
            naVals[i] = obRandom.nextInt(0,100);

        }

        try (DataOutputStream obOut = new DataOutputStream(new FileOutputStream("files/ints.dat")))
        {
            for (int nVal : naVals)
            {
                System.out.println(nVal);
                obOut.writeInt(nVal);
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
