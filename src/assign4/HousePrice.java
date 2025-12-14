package assign4;

import java.io.FileWriter;
import java.io.IOException;

public class HousePrice
{
    //Jackson Kolenosky

    //Fields
    private double price;
    private int area,bedrooms,bathrooms,stories;
    public boolean guestRoom;
    private boolean airCondition;
    private String style;

    private final static char CSV_CHAR = ',';

    /**
     * Constructor, Takes array of strings.
     * @param saVals Strings containing all params
     */
    public HousePrice(String[] saVals)
    {
        price = Double.parseDouble(saVals[0]);
        area = Integer.parseInt(saVals[1]);
        bedrooms = Integer.parseInt(saVals[2]);
        bathrooms = Integer.parseInt(saVals[3]);
        stories = Integer.parseInt(saVals[4]);
        guestRoom = saVals[5].equalsIgnoreCase("yes");
        airCondition = saVals[6].equalsIgnoreCase("yes");;
        style = saVals[7];
    }

    //Auto Generated getters
    public double getPrice()
    {
        return price;
    }

    public int getArea()
    {
        return area;
    }

    public int getBedrooms()
    {
        return bedrooms;
    }

    public int getBathrooms()
    {
        return bathrooms;
    }

    public int getStories()
    {
        return stories;
    }

    public boolean isGuestRoom()
    {
        return guestRoom;
    }

    public boolean isAirCondition()
    {
        return airCondition;
    }

    public String getStyle()
    {
        return style;
    }

    /**
     * Method that is responsible for writing its own object out to a csv file with updated prices
     * @param obWriter
     * @throws IOException
     */
    public void writeToCSVUpdate(FileWriter obWriter) throws IOException
    {
        String sWrite = "";
        if (style.equalsIgnoreCase("Tudor") && bathrooms >= 3)
        {
            sWrite += String.format("%.0f%c", price * 1.3, CSV_CHAR);
        }
        else
        {
            sWrite += String.format("%.0f%c", price * 1.1, CSV_CHAR);
        }
        sWrite += "" + area + CSV_CHAR;
        sWrite += String.format("%d%c", bedrooms, CSV_CHAR);
        sWrite += String.format("%d%c", bathrooms, CSV_CHAR);
        sWrite += String.format("%d%c", stories, CSV_CHAR);
        sWrite += guestRoom ? "yes" + CSV_CHAR : "no" + CSV_CHAR;
        sWrite += airCondition ? "yes" + CSV_CHAR: "no" + CSV_CHAR;
        sWrite += style + "\n";

        obWriter.write(sWrite);
    }

    public void writeToCSV(FileWriter obWriter) throws IOException
    {
        String sWrite = "";

        sWrite += String.format("%.0f%c", price, CSV_CHAR);
        sWrite += "" + area + CSV_CHAR;
        sWrite += String.format("%d%c", bedrooms, CSV_CHAR);
        sWrite += String.format("%d%c", bathrooms, CSV_CHAR);
        sWrite += String.format("%d%c", stories, CSV_CHAR);
        sWrite += guestRoom ? "yes" + CSV_CHAR : "no" + CSV_CHAR;
        sWrite += airCondition ? "yes" + CSV_CHAR: "no" + CSV_CHAR;
        sWrite += style + "\n";

        obWriter.write(sWrite);
    }

    @Override
    public String toString()
    {
        return String.format("Price: %.2f, Area: %d, Bedrooms: %d, Bathrooms: %d, Stories %d, Guest Room: %b, Air Condition: %b, Style: %s",
                price,area,bedrooms,bathrooms,stories,guestRoom,airCondition,style);
    }
}
