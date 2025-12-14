package assign4;

import java.util.Comparator;

public class CompStyle implements Comparator<HousePrice>
{
    @Override
    public int compare(HousePrice o1, HousePrice o2)
    {
        return o1.getStyle().compareTo(o2.getStyle());
    }
}