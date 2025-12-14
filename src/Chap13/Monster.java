package Chap13;

public abstract class Monster implements Comparable<Monster>,Fast{
    private int speed,scareFactor;
    private String name;
    private static final int DEFAULT_SPEED = 5;

    public Monster(String sName, int nSpeed, int nScareFactor) {
        this.name = sName;
        this.speed = nSpeed >= 0 && nSpeed <10 ? nSpeed : DEFAULT_SPEED;
        this.scareFactor = nScareFactor;
    }

    public int getSpeed() {
        return speed;
    }

    public int getScareFactor() {
        return scareFactor;
    }

    public String getName() {
        return name;
    }

    public void setScareFactor(int scareFactor) {
        this.scareFactor = scareFactor;
    }
    //abstract methods to be defined in subclasses
    public abstract boolean isDead();
    public abstract String consumes();


    @Override
    public String toString()
    {
        return String.format("Name: %s Speed: %d Scare Factor: %d consumes: %s Deadly monster: %b"
                ,name,speed,scareFactor,consumes(),isDead());
    }

    @Override
    public int compareTo(Monster obOther) {
        return this.speed - obOther.speed;
    }

    @Override
    public boolean isFast() {
        return this.speed > 5;
    }


}
