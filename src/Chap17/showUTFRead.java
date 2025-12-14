package Chap17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class showUTFRead
{
    public static void main(String[] args)
    {
        try(DataInputStream obIn = new DataInputStream(new FileInputStream("files/utfStrings.dat")))
        {
            String sVal1 = obIn.readUTF();
            System.out.printf("The first string read was %s", sVal1);
            System.out.printf("The second string read was %s", obIn.readUTF());

        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
