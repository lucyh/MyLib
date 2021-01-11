package myLib.value;

/**
 * A value object representing the language of an item
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code name}: a String representing the name of the language</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBLANG}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class LanguageValue
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
