package assign2;

import java.io.*;


public class Backup
{
    /**
     * Will go through directories given and create a backup subdirectory.
     * Will proceed to go through every .txt and .java file and copy it to the directory.
     * If a given arg isn't a valid directory, move on to next arg.
     * @param args
     */
    public static void main(String[] args)
    {
        //Jackson Kolenosky
        //2025-03-10

        for (String sDir : args)
        {
            File obDir = new File(sDir);

            if (obDir.isDirectory())
            {
                //Checking if the Backup dir needs to be created
                File backupDir = new File(obDir, "Backup");

                boolean isBackup = true;

                //Create backup dir
                if (!backupDir.exists())
                {
                    backupDir.mkdir();
                }

                //Back .txt, .java files up

                for (File obFile : obDir.listFiles())
                {
                    if (!obFile.isDirectory())
                    {


                        //Check which file type it is
                        if (obFile.getName().endsWith(".txt") | obFile.getName().endsWith(".java"))
                        {

                            File obDestFile = new File(String.format("%s/%s", backupDir.getAbsolutePath(), obFile.getName()));
                            try
                            {
                                FileInputStream obOrig = new FileInputStream(obFile);
                                FileOutputStream obDest = new FileOutputStream(obDestFile);

                                System.out.printf("Copying %s to %s%n", obFile.getAbsolutePath(), obDestFile.getAbsolutePath());

                                while (obOrig.available() > 0)
                                {
                                    obDest.write(obOrig.read());
                                }

                                obOrig.close();
                                obDest.close();

                            } catch (FileNotFoundException exp)
                            {
                                exp.printStackTrace();

                            } catch (IOException exp)
                            {
                                exp.printStackTrace();
                            }
                        }
                        else
                        {
                            System.out.println("No files to backup.");
                        }

                    }
                }

            }
        }

    }
}
