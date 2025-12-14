package assign1;

public class Dwarf extends Hero
{
    private String name;
    private HeroType type;

    /**
     * Constructor for Hero class
     *
     * @param sName    String for name
     * @param nType     HeroType for the type of hero
     */
    public Dwarf(String sName, HeroType nType)
    {
        super((int) (nType.getAttackRank() * 1.1), (int) (nType.getDefenseRank() * 0.95),
                (int) (nType.getInitiative() *0.85),(int) (nType.getHitPoints() * 1.1) );

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
            return (int) (getDefense() * 1.15);
        }
        else
        {
            return (int) (getDefense() * .85);
        }
    }

    @Override
    public String toString()
    {
      return String.format("Name: %s, Race: Dwarf, Type: %s, %s",
              name, type.toString(), super.toString());
    }

    @Override
    public String dataString() {
        return String.format("%s,%s,%s,%s", name,"Dwarf", type, super.dataString());
    }
}
