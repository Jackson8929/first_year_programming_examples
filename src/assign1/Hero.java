package assign1;


import java.util.Random;

import static assign1.Tools.inBetween;

public abstract class Hero {

    //Declaring Attributes, names are self-explanatory
    private int attack;
    private int defense;
    private int hitPoints;
    private int initiative;
    protected int originalHitPoints;

    /**
     * Constructor for Hero class
     *
     * @param attack    int for attack
     * @param defense   int for defense
     * @param hitPoints int for HP
     * @param initRank  int for init
     */
    public Hero(int attack, int defense, int initRank, int hitPoints)
    {

        this.attack = inBetween(attack, 25, 100);
        //this.attack = attack >= 25 && attack <= 100 ? attack : 25; //Limits Attack to between 25 and 100

        //this.defense = defense >= 10 && defense <= 35 ? defense : 10; //Limits Defense between 10 and 35
        this.defense = inBetween(defense, 10, 35);

        //this.hitPoints = hitPoints >= 51 && hitPoints <= 100 ? hitPoints : 51; //Limits hp between 51 and 100
        this.hitPoints = inBetween(hitPoints, 51, 100);

        //this.initiative = initRank >= 0 && initRank <= 60 ? initRank : 0; //Limits initiative between 0 and 60
        this.initiative = inBetween(initRank, 0, 60);

        this.originalHitPoints = hitPoints;
    }

    //Getters for Attributes
    public int getAttack()
    {
        return attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getHitPoints()
    {
        return hitPoints;
    }

    public int getInitiative()
    {
        return initiative;
    }


    /**
     * Resurrects a hero by setting hp to original value
     */
    public void resurrect()
    {
        this.hitPoints = this.originalHitPoints;
    }

    /**
     * Checks if hero is dead, returns true if the health is equal to or less than 0.
     *
     * @return
     */
    public boolean isDead()
    {
        return hitPoints <= 0;
    }

    /**
     * This will simulate a hero attacking the current hero (current instance)
     *
     * @param obOther the attacking hero.
     */
    public void defend(Hero obOther)
    {
        //Take the attack rating from obOther and subtract from current hero defense ranking
        //The difference will be the amount of damage the current hero takes
        Random obHitChance = new Random();
        int nHitChance = obHitChance.nextInt(0, 101);
        int nFail = 0;

        switch (obOther.getType())
        {
            case Mage:
                nFail = 15;
                break;

            case Thief:
                nFail = 30;
                break;

            case Fighter:
                nFail = 0;
                break;

            default:
                break;
        }

        if (nHitChance > nFail)
        {
            //Attack successful

            int nDamage = obOther.attack - this.getDefenseMod();
            if (nDamage <= 0)
            {
                this.hitPoints -= 1;
            } else
            {
                this.hitPoints -= nDamage;
            }

        }

    }

    /**
     * This is an abstract method that returns the modified Defense Modifier based upon the remaining hit points.
     *
     * @return modified Defense modifier
     */
    public int getDefenseMod()
    {
        return -1;
    }

    public HeroType getType()
    {
        return null;
    }


    /**
     * To string override
     *
     * @return returns a data in a string format
     */
    @Override
    public String toString()
    {
        return String.format("Attack: %s Defense: %s Hit Points: %s initiative: %s",
                this.attack, this.defense, this.hitPoints, this.initiative);
    }

    /**
     * A method like toString prints out data to console but without the prefixes to information. Data is seperated by comma
     *
     * @return
     */
    public String dataString()
    {
        return String.format("%s,%s,%s,%s", this.attack, this.defense, this.hitPoints, this.initiative);
    }
}
