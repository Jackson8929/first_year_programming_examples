package Chap13;

public class Greek extends Monster{

    public Greek(String sName, int nScare, int nSpeed)
    {
        super(sName.matches("[A-EG-KM-NP-Z][a-zA-Z]{4,}") ? sName: "NONAME",nSpeed,nScare);

    }
    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public String consumes() {
        return "Greeks";
    }

    @Override
    public String toString() {
        return String.format("Greek Monster: %s",super.toString());
    }
}
