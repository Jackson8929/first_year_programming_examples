package Chap19;

import java.util.Comparator;

public class CompHeight implements Comparator<TreeSpecies>
{
    @Override
    public int compare(TreeSpecies o1, TreeSpecies o2)
    {
        return Double.compare(o1.getHeight(),o2.getHeight());
    }
}
