package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class LanguageValue
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format( "Language:[%s]", name );
    }
}
