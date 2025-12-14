package Chap13;

import Horses.*;

import java.util.Comparator;

public class CompSpeed implements Comparator<Horse> {

    @Override
    public int compare(Horse o1, Horse o2) {
        return o1.getSpeedFactor() - o2.getSpeedFactor();
    }
}

