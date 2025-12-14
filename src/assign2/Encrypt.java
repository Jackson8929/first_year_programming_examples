package assign2;

import java.io.*;
import java.util.Scanner;

public class Encrypt
{
    //Jackson Kolenosky
    //2025-03-10

    //Wanted the file to be enc.txt with no directory mentioned. Put here for easy modification
    private static final String KEYPAD_LOCATION = "enc.txt";


    public static void main(String[] args) throws IOException
    {
        if (!args[0].endsWith(".txt"))
        {
            System.out.println("not a text file");
            System.exit(1);
        }

        File obOriginal = new File(args[0]);
        String sOutput = "";


        if (!obOriginal.exists())
        {
            System.out.println("File not found");
            System.exit(1);
        }
        String sKeyPad = genKeyPad();

        //Write keypad out to file
        FileOutputStream obEnc = new FileOutputStream(KEYPAD_LOCATION);
        obEnc.write(sKeyPad.getBytes());
        obEnc.close();

        Scanner obIn = new Scanner(obOriginal);


        //read in file to encrypt
        System.out.println(obIn.hasNext());
        while(obIn.hasNext())
        {
            String sInput = obIn.nextLine().toLowerCase().trim();
            sOutput += (encryptLine(sInput, sKeyPad)) + "\n";
        }

        obIn.close();

        //Write out encrypted data to same file
        FileWriter obWriter = new FileWriter(obOriginal);
        obWriter.write(sOutput);
        obWriter.close();
    }

    /**
     * This method will generate a random
     * ordering of all lower case characters
     * @return the string of lower case characters.
     */
    public static String genKeyPad()
    {
        final int bACAR = 97;
        final int bZCAR = 122;

        return keyPadLoop(bACAR,bZCAR);
    }

    /**
     * Helper class to generate the keypad.
     * @param nMin
     * @param nMax
     * @return
     */
    private static String keyPadLoop(int nMin, int nMax)
    {
        //First case, No more chars to generate
        if (nMin == nMax)
        {
            return "" + ((char) (nMax));
        }

        int nRandom = (int) (Math.random() * (nMax - nMin)) + nMin;

        String sVal1 = "";
        String sVal2 = "";

        if (nRandom < nMax)
        {
            sVal1 = keyPadLoop(nRandom +1,nMax);
        }

        if (nRandom > nMin)
        {
            sVal2 = keyPadLoop(nMin,nRandom - 1);
        }

        return "" + (char) (nRandom)+ sVal1 + sVal2;

    }

    /**
     *This method will take a String and encrypt it with the sKeyPad String
     * @param sPlainText
     * @param sKeyPad
     */
    public static String encryptLine(String sPlainText, String sKeyPad)
    {
        String nEncryptedText = "";

        for (int i = 0; i < sPlainText.length(); i++)
        {
            char cChar = sPlainText.charAt(i);
            if (cChar > 'A' && cChar < 'Z')
            {
                nEncryptedText += cChar;
            }
            else
            {
                if (cChar != ' ' && cChar != '\n')
                {
                    int nCharIndex = (int)cChar - 97;
                    nEncryptedText += sKeyPad.charAt(nCharIndex);
                }
                else
                {
                    nEncryptedText += cChar;
                }
            }

        }
        return nEncryptedText;
    }

}
