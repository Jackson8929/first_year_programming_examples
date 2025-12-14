package assign1;
import assign1.*;

public class Tools
{

    /**
     * Method that will keep will check if a number is inbetween two numbers,
     * if not it will put it to the nearest max or min.
     * @param nVal
     * @param min
     * @param max
     * @return
     */
    public static int inBetween(int nVal,int min, int max)
    {
        if (nVal < min)
        {
            return min;
        }
        else
        {
            if (nVal > max)
            {
                return max;
            }
            else return nVal;
        }
    }




}
