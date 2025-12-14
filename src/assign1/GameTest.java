package assign1;
import assign1.*;

public class GameTest
{
    public Hero Hero;
    public int fightsWon = 0;


    /**
     *
     * @param obHero
     * @param fightsWon
     */
    public GameTest(Hero obHero, int fightsWon)
    {
        this.Hero = obHero;
        this.fightsWon = fightsWon;
    }

    public assign1.Hero getHero()
    {
        return Hero;
    }

    public int getFightsWon()
    {
        return fightsWon;
    }




//    @Override
//    public String toString()
//    {
//        return String.format("Name: %s, Hero: %s, Type %s", Hero.getName(), Hero.get);
//    }

    /**
     * Enum used to loop through to create table of heros
     */
     private enum eHeros {
        HUMAN,
        ELF,
        DWARF,
        HOBBIT;
}

    /**
     * This method will dynamically create a table of 36 GameTest objects.
     * @return
     */
    public static GameTest[] createHero()
    {
    GameTest[] obHeroes = new GameTest[36];
    for (int i = 0; i < obHeroes.length;)
    {
        for(eHeros e : eHeros.values())
        {
            for(HeroType nType : HeroType.values() )
            {
                if (i < obHeroes.length)
                {
                    switch(e)
                    {
                        case HUMAN:
                            obHeroes[i] = new GameTest(new Human("Hero" + i++, nType),0);
                            break;
                        case DWARF:
                            obHeroes[i]= new GameTest(new Dwarf("Hero" + i++, nType), 0);
                            break;
                        case HOBBIT:
                            obHeroes[i] = new GameTest(new Hobbit("Hero" + i++, nType), 0);
                            break;
                        case ELF:
                            obHeroes[i] = new GameTest(new Elf("Hero" + i++, nType), 0);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    return obHeroes;
    }

    /**
     * This method will simulate a battle between two heros
     * @param obHero1
     * @param obHero2
     * @return
     */
    public static Hero battleRound(Hero obHero1, Hero obHero2)
    {
        Hero obAttack;
        Hero obDefense;

        //Decide who is going first based on which initiative is higher.
        // If they are both the same pick one of them at random
        if (obHero1.getInitiative() > obHero2.getInitiative())
        {
            obAttack = obHero1;
            obDefense = obHero2;
        }
        else
        {
            if (obHero2.getInitiative() > obHero1.getInitiative())
            {
                obAttack = obHero2;
                obDefense = obHero1;
            }
            else
            {
                // 1 is for hero 1, 2 is for hero 2
                int nRandom = (int) (Math.random() *2) +1;
                if (nRandom == 1)
                {
                    obAttack = obHero1;
                    obDefense = obHero2;
                }
                else
                {
                    obAttack = obHero2;
                    obDefense = obHero1;
                }
            }
        }

        // Start battleloop
        while(obAttack.getHitPoints() > 0 && obDefense.getHitPoints() > 0)
        {
            battleTurn(obAttack, obDefense);
        }

        if (obAttack.getHitPoints() > 0)
        {
            return obAttack;
        }
        else
        {
            return obDefense;
        }
    }

    /**
     * Method that simulates one turn of a battle round.
     * @param obAttack Attacking Hero
     * @param obDefense Defending Hero
     */
    private static void battleTurn (Hero obAttack, Hero obDefense)
    {
        //Numbers used to track if a Thief has turns left to attack
        byte bThiefAttack = 0;
        byte bThiefDefense = 0;

        // Booleans to track if any of the 2 heroes are thieves.
        boolean isObAttackThief = obAttack.getType().equals(HeroType.Thief);
        boolean isObDefenseThief = obDefense.getType().equals(HeroType.Thief);

        if (isObAttackThief) {
            bThiefAttack = 3;
        }
        if (isObDefenseThief) {
            bThiefAttack = 3;
        }

        obDefense.defend(obAttack);
        if (obDefense.getHitPoints() <= 0)
        {
            return;
        }
        if (isObAttackThief)
        {
            bThiefAttack--;
        }
        obAttack.defend(obDefense);
        if (obAttack.getHitPoints() <= 0)
        {
            return;
        }
        if (isObDefenseThief)
        {
            bThiefDefense--;
        }
        // Loop if there is thieves until they are all out of attacks.

        if (isObAttackThief || isObDefenseThief)
        {
            while(bThiefAttack > 0 || bThiefDefense > 0)
            {
                if (bThiefAttack > 0)
                {
                    obDefense.defend(obAttack);
                    if (obDefense.getHitPoints() <= 0)
                    {
                        return;
                    }
                    bThiefAttack--;
                }

                if (bThiefDefense > 0)
                {
                    obAttack.defend(obDefense);
                    if (obAttack.getHitPoints() <= 0)
                    {
                        return;
                    }
                    bThiefAttack--;
                }
            }
        }

    }

    /**
     * Main method. Simulates one round of the game.
     * @param args
     */
    public static void main(String[] args)
    {
        GameTest[] obHeroes = createHero();


        for (int i = 0; i < obHeroes.length; i++)
        {
            for (int j = i + 1; j < obHeroes.length ; j++)
            {
               Hero obWon = battleRound(obHeroes[i].Hero, obHeroes[j].Hero);
               if (obWon.equals(obHeroes[i].Hero))
               {
                   obHeroes[i].fightsWon++;
               }
               else
               {
                   obHeroes[j].fightsWon++;
               }
               obHeroes[i].Hero.resurrect();
               obHeroes[j].Hero.resurrect();

            }
        }

        //Sort
        bubbleSort(obHeroes);
//        for (GameTest ob : obHeroes)
//        {
//            System.out.println(ob);
//        }

        printParsable(obHeroes);


    }

    @Override
    public String toString() {
        return String.format("%s, Wins: %d",Hero.toString(), fightsWon);
    }

    public String dataString()
    {
        return String.format("%s,%s",Hero.dataString(),fightsWon);
    }

    /**
     * This method will print a tab delimited output that will be able to be copy and pasted into
     * any program that supports csv data.
     */
    public static void printParsable(GameTest[] gameTests) {
        System.out.println("name,Race,type,attack,defense,hitPoints,initiative,Wins");
        for (int i = 0; i < gameTests.length; i++)
        {
            System.out.printf("%s\n",gameTests[i].dataString());
        }
    }


    /**
     * This method will perform a bubble sort on the given array
     * @param obHero
     */
    public static void bubbleSort(GameTest[] obHero)
    {
        for (int nEnd = obHero.length-1; nEnd > 0; nEnd--)
        {
            for (int i=0; i < nEnd; i++)
            {

                if (obHero[i].fightsWon < obHero[i+1].fightsWon)
                {
                    swap(obHero, i, i+1);
                }
            }
        }
    }

    /**
     * This method will swap two arrays around.
     * @param obHero
     * @param nPos1
     * @param nPos2
     */
    public static void swap(GameTest[] obHero, int nPos1, int nPos2)
    {
        GameTest nTemp = obHero[nPos1];
        obHero[nPos1] = obHero[nPos2];
        obHero[nPos2] = nTemp;
    }

}
