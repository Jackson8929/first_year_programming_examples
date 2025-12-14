package assign4;

public record StylePrice(double price, String style)
{
    //Jackson Kolenosky

    @Override
    public String toString()
    {
        return String.format("$%.2f, %s", price,style);
    }
}
