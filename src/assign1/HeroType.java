package assign1;

import javax.crypto.interfaces.DHKey;
import java.util.Random;

public enum HeroType {
    Mage("Mage"),
    Thief("Thief"),
    Fighter("Fighter");


    //No documentation to write this method. ??????
    HeroType(String string) {

    }

    public int getHitPoints()
    {
        Random obRand = new Random();
        return switch (this)
        {
            case Mage -> obRand.nextInt(51,71);
            case Thief -> obRand.nextInt(71,86);
            case Fighter -> obRand.nextInt(86,101);
        };
    }

    public int getInitiative() {
        Random obRand = new Random();
        return switch (this)
        {
            case Mage -> obRand.nextInt(20,41);
            case Thief -> obRand.nextInt(50,61);
            case Fighter -> obRand.nextInt(25,41);
        };
    }
    public int getAttackRank() {
        Random obRand = new Random();
        return switch (this)
        {
            case Mage -> obRand.nextInt(95,121);
            case Thief -> obRand.nextInt(30,46);
            case Fighter -> obRand.nextInt(40,56);
        };
    }
    public int getDefenseRank() {
        Random obRand = new Random();
        return switch (this)
        {
            case Mage -> obRand.nextInt(10,20);
            case Thief -> obRand.nextInt(20,30);
            case Fighter -> obRand.nextInt(29,36);
        };
    }

    public int getNumAttacks() {
        Random obRand = new Random();
        return switch (this)
        {
            case Mage -> obRand.nextInt();
            case Thief -> obRand.nextInt();
            case Fighter -> obRand.nextInt();
        };
    }


}




