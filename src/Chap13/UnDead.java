package Chap13;

public class UnDead extends Monster {
    private boolean bCanFly;

    public UnDead(String sName,int nScare, int nSpeed, boolean bCanFly) {
        super(sName,nSpeed,nScare);
        this.bCanFly = bCanFly;
    }

    public boolean canFly() {
        return this.bCanFly;
    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public String consumes() {
        return "Blood/Brains";
    }

    @Override
    public String toString() {
        return String.format("UnDead %s Can Fly: %b",super.toString(),bCanFly);
    }
}
