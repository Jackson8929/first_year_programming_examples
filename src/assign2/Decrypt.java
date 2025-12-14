package assign2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Decrypt
{
    //Jackson Kolenosky
    //2025-03-10

    /**
     * Static String for mapping
     */
    private static String sALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException
    {
        String sOutput = "";
        String sKeyMap = "";

        //Checks for encrypted file
        if (!args[0].endsWith(".txt"))
        {
            System.out.println("not a text file");
            System.exit(1);
        }
        File obEncrypted = new File(args[0]);


        if (!obEncrypted.exists())
        {
            System.out.println("File not found");
            System.exit(1);
        }

        File obKeyPad = new File(args[1]);

        //checks for keypad file
        if (!obKeyPad.exists())
        {
            System.out.println("KeyPad not found");
            System.exit(1);
        }

        if (!args[1].endsWith(".txt"))
        {
            System.out.println("Keypad is not a text file");
            System.exit(1);
        }


        Scanner obIn = new Scanner(obEncrypted);
        Scanner obKeyIn = new Scanner(obKeyPad);

        sKeyMap = obKeyIn.nextLine();

        while(obIn.hasNext())
        {
            sOutput += decryptLines(obIn.nextLine(), sKeyMap);
        }

        obIn.close();

        //Write out
        FileWriter obWriter = new FileWriter(obEncrypted);
        obWriter.write(sOutput);
        obWriter.close();

    }

    /**
     *This method will decrypt one line of the encrypted file
     * @param sLine
     * @param keyPad
     * @return
     */
    private static String decryptLines(String sLine, String keyPad)
    {
        String sOutput = "";

        for (int i = 0; i < sLine.length(); i++)
        {
            char cChar = sLine.charAt(i);
            int nIndex = keyPad.indexOf(cChar);
            cChar = sALPHA.charAt(nIndex);

            sOutput += cChar;
        }
        return sOutput + "\n";
    }

}
