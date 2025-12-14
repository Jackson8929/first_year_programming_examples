package assign2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class countWords
{
    //Jackson Kolenosky
    //2025-03-10

    public static void main(String[] args) throws IOException
    {
        if (args == null) {
            System.out.println("Please enter a file path/s");
            System.exit(-1);
        }


        for (String sFile : args)
        {
            File obTemp = new File(sFile);
            System.out.println(obTemp.getAbsoluteFile());

            if (obTemp.exists() && !obTemp.isDirectory()) {
                Scanner obIn = new Scanner(obTemp);
                System.out.printf("%s, %d characters, %d words, %d lines",
                        obTemp.getName(), countChar(obIn), wordCount(obIn), Files.lines(obTemp.toPath()).count());
                obIn.close();
            }
            else
            {
                System.out.println(obTemp.getAbsolutePath() + " Is not a file, Ignoring");
            }


        }


    }

    /**
     * method to count Characters in textfile
     * @param obIn
     * @return
     */
    private static int countChar(Scanner obIn)
    {
        int nTempCount = 0;
        while (obIn.hasNext("\\w{1}")) {
            nTempCount++;
            obIn.next("\\w{1}");
        }
        return nTempCount;
    }

    /**
     * Method to count words in txt file
     * @param obIn
     * @return
     */
    private static int wordCount(Scanner obIn)
    {
        int nWords = 0;

        while (obIn.hasNext()) {
            nWords++;
            obIn.next();
        }
        return nWords;
    }


    /**
     * Method to count lines in a text file.
     * @param obIn
     * @return
     */
    private static int countLines(Scanner obIn)
    {
        int nLines = 0;
        while (obIn.hasNext("\\n")) {
            nLines++;
            obIn.next("\\n");
        }
        return nLines;
    }

    /**
     * In countWords write a method findTextfiles take a String  argument representing a directory
     * and go through and find all files with a .txt suffix and then proceed return a List of File to these files.
     * The method signature for this method is
     *
     * @param sDir
     * @return
     */
    public static ArrayList<File> findTextFiles(String sDir)
    {
        File obDir = new File(sDir);
        ArrayList<File> lstFiles = new ArrayList<>();

        if (obDir.isDirectory()) {
            for (File obFile : obDir.listFiles()) {
                if (obFile.getName().contains(".txt")) {
                    lstFiles.add(obFile);
                }
            }
        } else {
            System.out.println("Not a valid directory");
            System.exit(-1);
        }
        return lstFiles;
    }


    /**
     * This method will go through all files and files in subdirectories
     * It will print out the number of lines in the text file and how the total size of text files in directories
     * @param sDir path to Directory
     */
    public static void reportOnText(String sDir)
    {
        File obDir = new File(sDir);

        if  (obDir.isDirectory()) {
            reportOnTextLoop(obDir);
        }
        else
        {
            System.out.println("Not a valid directory");
            System.exit(-1);
        }

    }

    /**
     * Recursive helper class for reportOnText.
     *
     * @param obDir Directory reference
     */
    private static void reportOnTextLoop(File obDir)
    {
        System.out.println(obDir.getAbsolutePath());
        long lTotalSize = 0;
        for (File obFile : obDir.listFiles())
        {
            if (obFile.getName().contains(".txt"))
            {
                lTotalSize += obFile.length();
                try
                {
                    Scanner obIn = new Scanner(obFile);
                    int nLines = countLines(obIn);

                    System.out.printf("     %s lines: %d \n",obFile.getAbsolutePath(), nLines);
                    obIn.close();

                } catch (IOException exp)
                {
                    System.out.println("Error reading file " + obFile.getAbsolutePath());
                    exp.printStackTrace();
                }
            }
            else
            {
                if (obFile.isDirectory())
                {
                    reportOnTextLoop(obFile);
                }
            }

        }
        System.out.printf("%s: Directory size: %d bytes\n",obDir.getAbsolutePath(), lTotalSize);
    }



}
