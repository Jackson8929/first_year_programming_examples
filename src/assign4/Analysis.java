package assign4;

import static assign4.Pricing.*;

import java.io.IOException;
import java.util.List;

public class Analysis
{
    //Jackson Kolenosky

    public static void main(String[] args) throws IOException
    {
        List<HousePrice> lstHouse = LoadListings("Housing.csv");

        //Get data
        List<HousePrice> lstHouse3Bed = get3BedroomsAirCon(lstHouse);

        List<HousePrice> lst2BathroomGuestRoom = get2BathroomGuestRoom(lstHouse);

        //Write data out to respective csv's to be used later

    }


    //Methods to get Lists of the filtered data

    /**
     * average price of the house with 3 Bedrooms and Airconditioning
     */
    public static List<HousePrice> get3BedroomsAirCon(List<HousePrice> obList)
    {
        return obList.stream()
                .filter(x -> x.getBedrooms() ==3 && x.isAirCondition())
                .toList();

    }


    /**
     * average Price of the house 2 Baths and a guestroom.
     * @param obList
     * @return
     */
    public static List<HousePrice> get2BathroomGuestRoom(List<HousePrice> obList)
    {
        return obList.stream()
                .filter(x -> x.getBathrooms() ==2 && x.isGuestRoom())
                .toList();
    }


}
