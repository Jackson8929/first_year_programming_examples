package Chap13;

public class TestVehicle
{
    public static void main(String[] args) {
        Truck obTruck = new Truck("F150");

        System.out.println("Model is " +obTruck.getModel());
        System.out.println(obTruck.turnAlarmOn());
        System.out.println(obTruck.turnAlarmOff());

        Vehicle vec = obTruck;

        System.out.println(vec.getModel());
        System.out.println(vec.turnAlarmOn());

//        System.out.println("Color is " + vec.getColor());
//        Can't do this because it is in a sub class.
    }


}
