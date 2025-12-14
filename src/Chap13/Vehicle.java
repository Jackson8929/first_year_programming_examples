package Chap13;

public interface Vehicle
{
    public String getModel();
    public String speedUp();
    public String SlowDown();

    public default String turnAlarmOn()
    {
        return "Turning vehicle alarm on";
    }

    public default String turnAlarmOff()
    {
        return "Turning the alarm Off";
    }
}
