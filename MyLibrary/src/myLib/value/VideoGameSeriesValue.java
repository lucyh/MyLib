package myLib.value;

/**
 * A value object representing the series of a video game
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code name}: a String representing the name of the series</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVGSRS}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class VideoGameSeriesValue
{
    private String uniqueKey;
    private String name;

    public String getName()
    {
        return name;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        return String.format( "Key:[%s], Name:[%s]", uniqueKey, name );
    }
}
