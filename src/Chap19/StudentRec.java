package Chap19;

public class StudentRec implements CopyIt<StudentRec>,Comparable<StudentRec>
{
    private double math_grade,history_grade,average_grade;
    private String grade_level,name;

    private final static int MATH_POS = 0;
    private final static int HISTORY_POS = 1;
    private final static int AVERAGE_POS = 2;
    private final static int LEVEL_POS = 3;
    private final static int NAME_POS = 4;

    StudentRec(double dMathGrade, double dHistoryGrade,
               double dAverageGrade, String sGradeLevel,String sName) {
        this.math_grade = dMathGrade;
        this.history_grade = dHistoryGrade;
        this.average_grade = dAverageGrade;
        this.grade_level = sGradeLevel;
        this.name = sName;
    }

    public double getMath_grade()
    {
        return math_grade;
    }

    public double getHistory_grade()
    {
        return history_grade;
    }

    public double getAverage_grade()
    {
        return average_grade;
    }

    public String getGrade_level()
    {
        return grade_level;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void setVals(String[] saVals)
    {
        this.math_grade = Double.parseDouble(saVals[MATH_POS]);
        this.history_grade = Double.parseDouble(saVals[HISTORY_POS]);
        this.average_grade = Double.parseDouble(saVals[AVERAGE_POS]);
        this.grade_level = saVals[LEVEL_POS];
        this.name = saVals[NAME_POS];
    }

    @Override
    public StudentRec copy()
    {
        return new StudentRec(math_grade,history_grade,
                average_grade,grade_level,name);
    }

    @Override
    public String toString()
    {
        return String.format("Math: %.2f,History: %.2f,Average: %.2f,Grade Level: %s,Name: %s",
                this.math_grade,this.history_grade,
                this.average_grade,this.grade_level,this.name);
    }

    @Override
    public int compareTo(StudentRec o)
    {
        return (int)(getAverage_grade() - o.getAverage_grade());
    }
}
