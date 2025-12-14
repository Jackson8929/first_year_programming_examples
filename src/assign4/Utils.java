package assign4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils
{

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

}
