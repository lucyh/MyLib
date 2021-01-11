package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class VideoGameCompanyValue
{
    /**
     * TODO remove eventually - these should be configured in the database
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

    private Company company;

    @Override
    public String toString()
    {
        return company.text();
    }
}
