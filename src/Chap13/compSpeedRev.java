package Chap13;
import Horses.*;

import java.util.Comparator;

public class compSpeedRev implements Comparator<Horse> {
    @Override
    public int compare(Horse o1, Horse o2) {
        return o2.getSpeedFactor() - o1.getSpeedFactor();
    }
}
