package assign3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericFunc
{
    /**
     * Method that will return the mode of all values in the given array.
     * @param aVals
     * @return
     * @param <T>
     */
    public static <T>ArrayList<T>Mode(T[]aVals)
    {
        ArrayList<T> lstReturn = new ArrayList<>();
        ArrayList<Integer> lstCount = new ArrayList<>();
        Arrays.sort(aVals);

        T[] obAUnique = getUnique(aVals);

        for (int i = 0; i < obAUnique.length; i++)
        {
            boolean bFound = false;
            int nCount = 0;

            for (int j = 0; j < aVals.length; j++)
            {
                if (obAUnique[i].equals(aVals[j]))
                {
                    bFound = true;
                    nCount++;
                }
                else
                {
                    if (bFound)
                    {
                        break;
                    }
                }
            }
            //TODO: Post count logic
            lstCount.add(nCount);

        }

        //TODO: Grab largest count vals.
        for (int i = 0; i < lstCount.size(); i++)
        {
            boolean isLargest = false;
            for (int j = i+1 ; j < lstCount.size() ; j++)
            {
                if (lstCount.get(i) > lstCount.get(j))
                {
                    isLargest = true;
                }
                else
                {
                    isLargest = false;
                }
            }
            if (isLargest)
            {
                lstReturn.add(obAUnique[i]);
            }
        }

        return lstReturn;
    }

    public static <T extends Comparable<T>> T[] rowWithMaxValue(T[][] aVals)
    {
        ArrayList<T> lstMax = new ArrayList<>();

        for (int i = 0; i < aVals.length; i++)
        {
            Arrays.sort(aVals[i]);

            lstMax.add(aVals[i][aVals[i].length-1]);
        }

        T[] aMax = (T[]) lstMax.toArray();


        //find max out of that array
        Arrays.sort(aMax);

        return aMax;
    }

    /**
     *Write a generic method  intersection that will take in two generic arrays of the same type
     *and return a new array whose conents consist of those generic elements that exist in both arrays.
     * @param aFirst
     * @param aSecond
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> T[]  intersection (T[] aFirst, T[] aSecond)
    {
        ArrayList<T> lstInter = new ArrayList<>();

        for (int i = 0; i < aFirst.length; i++)
        {
            for (int j = 0; j < aSecond.length; j++)
            {
                if (aFirst[i].equals(aSecond[j]))
                {
                    lstInter.add(aFirst[i]);
                    break;
                }
            }
        }

        T[] obReturn = (T[]) lstInter.toArray();

        return obReturn;
    }


    /**
     * This method will take in an Array and split it into a list of 2 arrays.
     * The arrays will contain both halfs of the original array.
     * @param aVals
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T[] > split(T[] aVals)
    {
        //TODO: TEST!!!!
        ArrayList<T> lstReturn = new ArrayList<>();
        int nHalfPoint = (aVals.length/2) -1;
        //Make arrays
        T[] obAFirst = (T[]) Array.newInstance(aVals[0].getClass(),nHalfPoint+1);
        T[] obASecond = (T[]) Array.newInstance(aVals[0].getClass(), aVals.length-(nHalfPoint+1));

        //Add to array and return
        for (int i = 0; i < nHalfPoint+1; i++)
        {
            obAFirst[i] = aVals[i];
        }

        for (int i = nHalfPoint; i < aVals.length; i++)
        {
            obASecond[i] = aVals[i];
        }


        ArrayList<T[]> obReturn = new ArrayList<>();
        obReturn.add(obAFirst);
        obReturn.add(obASecond);

        return obReturn;
    }

    /**
     * This Method will take in a generic array and return an array of unique values.
     * @param aVals
     * @return
     * @param <T>
     */
    public static <T> T[] getUnique(T[] aVals)
    {
        ArrayList<T> lstUnique = new ArrayList<>();

        for (int i = 0; i < aVals.length; i++)
        {
            if (!lstUnique.contains(aVals[i]))
            {
                lstUnique.add(aVals[i]);
            }
        }

        return (T[]) lstUnique.toArray();
    }

    /**
     *This method will join two arrays together. It only includes unique values
     *
     * @param aFirst
     * @param aSecond
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] union(T[] aFirst, T[] aSecond)
    {
        int nLengthTotal = aFirst.length + aSecond.length;
        T[] obANotUnique = (T[]) Array.newInstance(aFirst[0].getClass(),nLengthTotal);
        int nCount = 0;

        for (nCount = 0; nCount < aFirst.length; nCount++)
        {
            obANotUnique[nCount] = aFirst[nCount];
        }
        for (int i = 0; i < aSecond.length; i++,nCount++)
        {
            obANotUnique[nCount] = aSecond[i];
        }

        T[] obaAReturn = getUnique(obANotUnique);

        return obaAReturn;
    }
}
