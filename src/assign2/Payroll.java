package assign2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class Payroll
{
    //Jackson Kolenosky
    //2025-03-10


    String FirstName, LastName;
    Double salary;
    Position position;


    public enum Position
    {
        ASSOCIATE("associate"),
        FULL("full"),
        ASSISTANT("assistant"),
        FACULTY("faculty");

        private final String sValue;

        Position(String sValue)
        {
            this.sValue = sValue;
        }

        /**
         * Function to get enum based off string, Errors out if wrong String is inputed
         * @param sValue
         * @return
         */
        static Position getValue(String sValue) {
            return switch (sValue)
            {
                case "associate" -> ASSOCIATE;
                case "full" -> FULL;
                case "assistant" -> ASSISTANT;
                case "faculty" -> FACULTY;
                default -> throw new IllegalArgumentException();
            };
        }
    }

    /**
     * THIS reads that file in and determines the high, low, and average salary for each of the following positions assistant professor,
     * associate professor, full professor, and faculty. In addition, provide counts that indicate the number of people in each of those positions
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<Payroll> lstPayRoll = new ArrayList<>();

        try
        {
            URL obSite = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt ");

            InputStream obInput  = obSite.openStream();
            Scanner obScanner = new Scanner(obInput);

            while (obScanner.hasNextLine())
            {
                lstPayRoll.add(new Payroll(
                        obScanner.next(), obScanner.next(), obScanner.next(), obScanner.nextDouble()

                ));
            }
            obScanner.close();

            //Start math
            for (Position POSITION : Position.values())
            {
                //vars for calculations

                double dHigh = 0;
                double dLow = Double.MAX_VALUE;
                double dAverage = 0;
                int nCount = 0;

                for (Payroll obPerson : lstPayRoll)
                {
                    if (obPerson.position == POSITION)
                    {
                        if (obPerson.salary < dLow)
                        {
                            dLow = obPerson.salary;
                        }

                        if (obPerson.salary > dHigh)
                        {
                            dHigh = obPerson.salary;
                        }
                        nCount++;
                        dAverage += obPerson.salary;
                    }
                }
                dAverage /= nCount;

                System.out.println("The Calculations for " + POSITION.sValue + " are:");
                if (dLow == Double.MAX_VALUE)
                {
                    dLow = 0;
                }
                System.out.printf("Low: %.2f, High: %.2f, Average: %.2f\n", dLow, dHigh, dAverage);
            }

        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }


    }

    /**
     * Constructor for Payroll
     * @param sFirstName First name
     * @param sLastName Last Name
     * @param sPosition String for position
     * @param dSalary Their salary
     */
    Payroll(String sFirstName, String sLastName, String sPosition, Double dSalary)
    {
        FirstName = sFirstName;
        LastName = sLastName;
        position = Position.getValue(sPosition);
        salary = dSalary;
    }

    @Override
    public String toString()
    {
        return FirstName + " " + LastName + " " + position.sValue + " " + salary;
    }
}
