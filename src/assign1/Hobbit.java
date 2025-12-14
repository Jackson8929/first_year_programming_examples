package assign1;

public class Hobbit extends Hero
{
    private String name;
    private HeroType type;

    /**
     * Constructor for Hero class
     *
     * @param sName    String for name
     * @param nType     HeroType for the type of hero
     */
    public Hobbit(String sName, HeroType nType)
    {
        super((int) (nType.getAttackRank() * .8), (int) (nType.getDefenseRank() * 1.15),
                (int) (nType.getInitiative() *1.2),(int) (nType.getHitPoints() * .85) );

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
            return (int) (getDefense() * 1.1);
        }
        else
        {
            return (int) (getDefense() * .90);
        }
    }

    @Override
    public String toString()
    {
      return String.format("Name: %s, Race: Hobbit, Type: %s, %s",
              name, type.toString(), super.toString());
    }

    @Override
    public String dataString() {
        return String.format("%s,%s,%s,%s", name, "Hobbit",type, super.dataString());
    }
}
