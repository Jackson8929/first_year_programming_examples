package assign1;

public class Elf extends Hero
{
   private String name;
   private HeroType type;

    /**
     * Constructor for Hero class
     *
     * @param sName    String for name
     * @param nType     HeroType for the type of hero
     */
    public Elf(String sName, HeroType nType)
    {
        super((int) (nType.getAttackRank() * .95), (int) (nType.getDefenseRank() * 1.05),
                (int) (nType.getInitiative() *1.05),(int) (nType.getHitPoints() * .9) );

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
        int HalfHP = super.getHitPoints() / 2;
        if (getHitPoints() >= HalfHP)
        {
            return (int) (getDefense() * 1.20);
        }
        else
        {
            return (int) (getDefense() * .8);
        }
    }

    @Override
    public String toString()
    {
      return String.format("Name: %s, Race: Elf, Type: %s, %s",
              name, type, super.toString());
    }

    @Override
    public String dataString() {
        return String.format("%s,%s,%s,%s", name,"Elf",type, super.dataString());
    }

}
