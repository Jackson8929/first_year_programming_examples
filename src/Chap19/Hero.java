package Chap19;

public class Hero implements CopyIt<Hero>
{
    private String name,power,team;

    private static int NAME_POS = 0;
    private static int SUPER_POS = 1;
    private static int TEAM_POS = 2;

    public Hero(String sName, String sPower, String sTeam)
    {
        this.name = sName;
        this.power = sPower;
        this.team = sTeam;
    }

    public String getName()
    {
        return name;
    }

    public String getPower()
    {
        return power;
    }

    public String getTeam()
    {
        return team;
    }


    @Override
    public void setVals(String[] saVals)
    {
        this.name = saVals[NAME_POS];
        this.power = saVals[SUPER_POS];
        this.team = saVals[TEAM_POS];
    }

    @Override
    public Hero copy()
    {
        return new Hero(name,power,team);
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s %s",this.name,this.power,this.team);
    }
}
