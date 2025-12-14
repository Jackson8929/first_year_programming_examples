package assign4;

public class Quick
{
    private enum FavColor {
        RED,BLUE,GREEN,YELLOW
    };

    public static void main(String[] args)
    {
        FavColor myColor = FavColor.BLUE;

        String SDec = switch (myColor)
        {
            case RED -> "Yea for Red";
            case BLUE -> "Yea for Red";
            case GREEN -> "Yea for Red";
            case YELLOW -> "Yea for Red";
        };
    }
}
