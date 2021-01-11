package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class VideoGameSeriesValue
{
    private String name;

    @Override
    public String toString()
    {
        return String.format( "Name:[%s]", name );
    }
}
