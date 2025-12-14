package Chap17;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShowUTFWrite
{
    public static void main(String[] args) throws FileNotFoundException
    {
        try (DataOutputStream obOut = new DataOutputStream(new FileOutputStream("files/utfStrings.dat",true)))
        {
            obOut.writeUTF("Hello");
            obOut.writeUTF("Based");
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
