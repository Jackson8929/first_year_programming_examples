package Chap13;

public class EvilEye extends Monster{

    private int range;
    public EvilEye (String sName, int nScare, int nSpeed, int nRange) {
        super(sName,nSpeed >= 0 && nSpeed <=2 ? nSpeed: 0,nScare);
        this.range = nRange;

    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public String consumes() {
        return "minds";
    }

    @Override
    public String toString() {
        return String.format("Evil Eye: %s",super.toString());
    }
}
