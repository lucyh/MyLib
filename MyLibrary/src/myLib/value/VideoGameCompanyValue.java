package myLib.value;

/**
 * A value object representing the company that made the video game
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code name}: a String representing the name of the company</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVGCO}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class VideoGameCompanyValue
{
    /**
     * FIXME remove eventually - these should be configured in the database
     *
     * @author knerd.knitter
     */
    public enum Company
    {
     MICR( "Microsoft" ),
     NIN( "Nintendo" ),
     PC( "PC" ),
     PS( "PlayStation" ),
     SEGA( "Sega" );

        private String text;

        Company( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private String uniqueKey;
    private String name;

    public VideoGameCompanyValue( String uniqueKey, Company company )
    {
        this.uniqueKey = uniqueKey;
        this.name = company.text();
    }

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
