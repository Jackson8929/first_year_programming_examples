package Chap17;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils
{
    private static final char TERM_CHAR = '\0';

    public static  <T> List<T> genCSVLoad2(String sPath, Function<String, T> funcRef)
    {
        List<T> olReturn = null;

        try (BufferedReader br = new BufferedReader(new FileReader(sPath)))
        {
            olReturn = br.lines().skip(1).map(funcRef).collect(Collectors.toList());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return olReturn;
    }


    public static String[] parseCSVLine(String sLine)
    {
        String sPattern = ",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))";

        String[]  sFields = sLine.split(sPattern);
        for (int i = 0; i < sFields.length; i++) {
            // Get rid of residual double quotes
            sFields[i] = sFields[i].replace("\"", "");
        }
        return sFields;
    }

    /**
     * Method for writing a string out in a particular frame size. Buffer chars are added as needed
     * @param sVal String value to be written
     * @param obRaf RandomAccessFile reference
     * @param nFrameSize the size of the section we are writing.
     * @throws IOException
     */
    public static void writeStringToRaf(String sVal, RandomAccessFile obRaf, int nFrameSize) throws IOException
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
    public static String readStringFromRaf(RandomAccessFile obRaf, int nFrameSize) throws IOException
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
