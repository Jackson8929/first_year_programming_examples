package assign2;

import java.io.*;
import java.util.ArrayList;

public class Aircraft implements Serializable
{
    //Jackson Kolenosky
    //2025-03-10

    String Name ,CountryOfOrigin;
    int Year;

    //Set max size for randomAccessFile Writing
    private static final int NAME_MAX_SIZE = 40;
    private static final int COUNTRY_MAX_SIZE = 15;

    private static final char TERM_CHAR = '\0';

    private final int
            NAME_POS=0,
            YEAR_POS=1,
            COUNTRY=2;

    Aircraft(String[] args)
    {
        this.Name = args[0];
        this.Year = Integer.parseInt(args[1]);
        this.CountryOfOrigin = args[2];
    }

    Aircraft(String sName, String sCountryOfOrigin, int nYear)
    {
        this.Name = sName;
        this.CountryOfOrigin = sCountryOfOrigin;
        this.Year = nYear;
    }

    public String getName()
    {
        return Name;
    }

    public String getCountryOfOrigin()
    {
        return CountryOfOrigin;
    }

    public int getYear()
    {
        return Year;
    }

    /**
     * Serialize Arraylist of Aircrafts to file
     * @param obList
     * @param sFile
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void writeAircraftObjects(ArrayList<Aircraft> obList, String sFile) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(sFile));

        for (Aircraft obAircraft : obList)
        {
            obOut.writeObject(obAircraft);
        }
    }

    /**
     * Writes aircraft object to randomAccessFile
     * @param obList
     * @param sFileName
     * @throws IOException
     */
    public static void writeRAFAircraft(ArrayList<Aircraft> obList, String sFileName) throws IOException
    {
        RandomAccessFile obRafIn = new RandomAccessFile(new File(sFileName), "rw");

        obRafIn.seek(0);
        for (Aircraft obAircraft : obList)
        {
            writeStringToRaf(obAircraft.getName(), obRafIn , NAME_MAX_SIZE);
            obRafIn.writeInt(obAircraft.getYear());
            writeStringToRaf(obAircraft.getCountryOfOrigin(), obRafIn, COUNTRY_MAX_SIZE);

        }
    }

    /**
     * Method for Getting an entry from Random Access File
     * @param sFile File to Read
     * @param nPosition Pointer to look in file
     * @return Aircraft object
     * @throws IOException
     */
    public static Aircraft getRAFRec(String sFile, int nPosition) throws IOException
    {
        int nPos = (Integer.SIZE + 40 + 15) * nPosition ;

        RandomAccessFile obRafIn = new RandomAccessFile(new File(sFile), "rw");
        obRafIn.seek(nPos);

        String nName = readStringFromRaf(obRafIn,NAME_MAX_SIZE);
        int nYear = obRafIn.readInt();
        String sCountry = readStringFromRaf(obRafIn,COUNTRY_MAX_SIZE);

        return new Aircraft(nName,sCountry,nYear);
    }

    /**
     * Method for writing a string out in a particular frame size. Buffer chars are added as needed
     * @param sVal String value to be written
     * @param obRaf RandomAccessFile reference
     * @param nFrameSize the size of the section we are writing.
     * @throws IOException
     */
    private static void writeStringToRaf(String sVal, RandomAccessFile obRaf, int nFrameSize) throws IOException
    {
        byte[] aWriteBytes = sVal.getBytes();
        int i = 0;
        for (; i <Math.min(nFrameSize,aWriteBytes.length); i++)
        {
            obRaf.writeByte(aWriteBytes[i]);
        }

        // add buffer chars as necessary
        for (; i < nFrameSize; i++)
        {
            obRaf.writeByte(TERM_CHAR);
        }
    }

    /**
     * Method for reading a fixed size string (or Less) from the given Random access file.
     * @param obRaf Random Access file.
     * @param nFrameSize The length of text to read.
     * @return String
     */
    private static String readStringFromRaf(RandomAccessFile obRaf, int nFrameSize) throws IOException
    {
        byte[] aReadBytes = new byte[nFrameSize];

        obRaf.read(aReadBytes);

        String sReturn = new String(aReadBytes);

        int nPos = sReturn.indexOf(TERM_CHAR);
        if (nPos != -1)
        {
            return sReturn.substring(0, nPos);
        }
        else
        {
            return sReturn;
        }
    }


}
