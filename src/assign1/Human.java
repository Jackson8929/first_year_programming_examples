package assign1;

public class Human extends Hero
{
    private String name;
    private HeroType type;

    /**
     * Constructor for Hero class
     *
     * @param sName    String for name
     * @param nType     HeroType for the type of hero
     */
    public Human(String sName, HeroType nType)
    {
        super(nType.getAttackRank(), nType.getDefenseRank(),
                nType.getInitiative(),nType.getHitPoints());

        this.type = nType;
        this.name = sName;
    }


    @Override
    public HeroType getType()
    {
        return this.type;
    }

    @Override
    public int getDefenseMod()
    {
        return getDefense();
    }

    @Override
    public String toString()
    {
      return String.format("Name: %s, Race: Human, Type: %s, %s",
              name, type.toString(), super.toString());
    }

    @Override
    public String dataString() {
        return String.format("%s,%s,%s,%s", name,"Human",type, super.dataString());
    }
}
