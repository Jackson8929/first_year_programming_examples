package Chap19;

public class TreeSpecies implements CopyIt<TreeSpecies>,Comparable<TreeSpecies>
{
    private String species, leafShape;
    private double height;

    TreeSpecies(String[] sVals)
    {
        this.species = sVals[0];
        this.leafShape = sVals[2];
        this.height = Double.parseDouble(sVals[1]);
    }

    public TreeSpecies(String species, double height, String leafShape)
    {
        this.species = species;
        this.leafShape = leafShape;
        this.height = height;
    }

    public String getSpecies()
    {
        return species;
    }

    public String getLeafShape()
    {
        return leafShape;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %.2f",this.getSpecies(),this.getLeafShape(),this.getHeight());
    }

    @Override
    public void setVals(String[] saVals)
    {
        species = saVals[0];
        height = Double.parseDouble(saVals[1]);
        leafShape = saVals[2];
    }

    @Override
    public TreeSpecies copy()
    {
        return new TreeSpecies(this.species, this.height, this.leafShape);
    }

    @Override
    public int compareTo(TreeSpecies o)
    {
        return Double.compare(this.getHeight(),o.getHeight());
    }
}
