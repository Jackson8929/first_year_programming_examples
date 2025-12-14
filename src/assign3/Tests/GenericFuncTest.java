package assign3.Tests;

import assign3.GenericFunc;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GenericFuncTest
{

    @Test
    void mode()
    {
        Integer[] naExpected = {6};
        Integer[] obVals = {2,3,1,6};

        ArrayList<Integer> lstNVals = GenericFunc.Mode(obVals);
        Integer[] naActual = new Integer[lstNVals.size()];
        lstNVals.toArray(naActual);

        assertArrayEquals(naExpected,naActual);

    }

    @Test
    void intersection()
    {
        Integer[] naVals1 = {1,2,3,5,1};
        Integer[] naVals2 = {5,2,7,5,1};

        Integer[] naExpected = {1,2,5,1};

        assertArrayEquals(naExpected,GenericFunc.intersection(naVals1,naVals2));
    }

    @Test
    void getUnique()
    {
        Integer[] naVals1 = {1,5,2,1,6,6,1};
        Integer[] naExpected = {1,5,2,6};

        assertArrayEquals(naExpected,GenericFunc.getUnique(naVals1));

        String[] saVals1 = {"Hi","hello","world","Hi"};
        String[] saExpected = {"Hi","hello","world"};

        assertArrayEquals(saExpected,GenericFunc.getUnique(saVals1));
    }

    @Test
    void union()
    {
        String[] saVals1 = {"Hi","bob","hello","world","John"};
        String[] saVals2 = {"Hi","bill","bob"};
        String[] saExpected = {"Hi","bob","hello","world","John","bill"};

        assertArrayEquals(saExpected,GenericFunc.union(saVals1,saVals2));
    }

}