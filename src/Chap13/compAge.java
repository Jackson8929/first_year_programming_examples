package Chap13;

import Horses.*;
import java.util.Comparator;


public class compAge implements Comparator<Horse>{
    @Override
    public int compare(Horse o1, Horse o2) {
        return o1.getAge() - o2.getAge();
    }
}
