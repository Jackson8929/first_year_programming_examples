package Chap19;

import java.util.ArrayList;
import java.util.Collections;

public class GradeBook
{
    public static void main(String[] args)
    {
        ArrayList<StudentRec> lstStudents=Utils.genCSVRead1("files/Grades.csv",new StudentRec(0,0,
                0,"",""));

        //Sort by average
        Collections.sort(lstStudents);

        for (StudentRec Student : lstStudents)
        {
            System.out.println(Student);
        }
        System.out.println("\n\n\n");
        //???????

    }
}
