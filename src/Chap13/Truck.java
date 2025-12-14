package Chap13;

public class Truck implements Vehicle{
    private String model;
    private String color;

    public Truck (String sModel)
    {
        this.model = sModel;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String speedUp() {
        return "Pressing the accelerator";
    }

    @Override
    public String SlowDown() {
        return "Pressing the Brake";
    }

    @Override
    public String turnAlarmOn()
    {
        return "KAKAKAKAKA";
    }


}
