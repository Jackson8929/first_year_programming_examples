package Chap17;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class SearchForCars
{
    public static void main(String[] args)
    {
        try(RandomAccessFile obRaf = new RandomAccessFile("files/cars.raf","rw"))
        {
            Scanner obIn = new Scanner(System.in);
            System.out.println("What record number do you wish to access");
            int nIndex = obIn.nextInt();

            Long nRecSize = obRaf.length() / Car.REC_SIZE;

            while (nIndex != -1)
            {
                if (nIndex >= nRecSize)
                {
                    System.out.println("Index out of range");
                    System.out.println("What record do you wish to access");
                    nIndex = obIn.nextInt();
                    continue;
                }
                obRaf.seek(Car.REC_SIZE * nIndex);
                Car obRef = Car.readRecFromRaf(obRaf);
                System.out.printf("Car: %s\n",obRef);
                System.out.println("What record do you wish to access");
                nIndex = obIn.nextInt();
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
