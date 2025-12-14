package assign3.Tests;

import assign3.Keyword;
import assign3.KeywordFunc;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KeywordFuncTest
{

    @Test
    void getArrayListKeyword()
    {
        ArrayList<Keyword> lstKeywords = KeywordFunc.getArrayListKeyword("src/assign3/keywords.csv");

        for (Keyword k : lstKeywords)
        {
            System.out.println(k);
        }
    }
}