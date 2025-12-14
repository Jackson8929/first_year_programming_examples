package assign3;

public class Keyword
{
    public String word,description;

    Keyword(String[] saVals)
    {
       word = saVals[0];
       description = saVals[1];
    }

    Keyword(String sWord, String sDescription)
    {
        word = sWord;
        description = sDescription;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return String.format("Keyword: %s, Description: %s",this.word,this.description);
    }
}
