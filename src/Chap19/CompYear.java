package Chap19;

import java.util.Comparator;

public class CompYear implements Comparator<StudentRec>
{

    @Override
    public int compare(StudentRec o1, StudentRec o2)
    {
        return o1.getGrade_level().compareTo(o2.getGrade_level());
    }
}
