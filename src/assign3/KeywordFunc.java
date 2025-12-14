package assign3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static assign3.Utils.parseCSVLine;

public class KeywordFunc
{
    /**
     * This method gets an arraylist of Keywords from a csv file, with help from the Utils class.
     * @param sFilename
     * @return
     */
    public static ArrayList<Keyword> getArrayListKeyword(String sFilename)
    {
        ArrayList<Keyword> lstReturn = new ArrayList<>();
        try
        {
            Scanner obScanner = new Scanner(new File(sFilename));
            while(obScanner.hasNext())
            {
                String[] sLine = parseCSVLine(obScanner.nextLine());
                lstReturn.add(new Keyword(sLine));
            }

        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }

        return lstReturn;
    }

    /**
     * This method  will return a map of all the Keywords and their meanings list in the file.
     * @param sFileName
     * @return
     */
    public static Map<String, String> getMapKeyWord(String sFileName)
    {
        ArrayList<Keyword> lstWords = getArrayListKeyword(sFileName);
        Map<String, String> mapReturn = new HashMap<>();

        for (Keyword obWord : lstWords)
        {
            mapReturn.put(obWord.word,obWord.description);
        }
        return mapReturn;
    }


}
