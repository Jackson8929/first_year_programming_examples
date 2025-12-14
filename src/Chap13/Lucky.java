package Chap13;

public class Lucky extends Monster{

    private String benefit;

    public Lucky (String Name,int nScare, int nSpeed,String sBenefit) {
        super(Name,nSpeed>=7 && nSpeed <= 10 ? nSpeed : 7,nScare);
        this.benefit = sBenefit;

    }

    public Lucky (String Name, int nScare, int nSpeed)
    {
        this(Name,nScare, nSpeed,"No Benefit");
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public String consumes() {
        return "Lucky Charms";
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    @Override
    public String toString() {
        return String.format("Lucky %s Benefit: %s,",super.toString(), benefit);
    }

    @Override
    public boolean isFast() {
        return this.getSpeed() > 8;
    }
}
