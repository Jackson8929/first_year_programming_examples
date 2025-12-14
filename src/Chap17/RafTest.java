package Chap17;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RafTest
{
    public static void main(String[] args)
    {
        try(RandomAccessFile obRaf = new RandomAccessFile("files/inits.raf", "rw"))
        {
//            obRaf.setLength(100);
            obRaf.seek(40);
//            obRaf.writeInt(64);
            System.out.println("the Value is " + obRaf.readInt());

            obRaf.seek(40);
            obRaf.writeInt(80);

            obRaf.seek(200);
            obRaf.writeInt(15);
            obRaf.seek(200);
            obRaf.writeShort(10);
            obRaf.seek(200);
            int nVal = obRaf.readInt();

            System.out.println("the value is " + nVal);


        }
        catch (IOException exp)
        {
            exp.printStackTrace();;
        }
    }
}
