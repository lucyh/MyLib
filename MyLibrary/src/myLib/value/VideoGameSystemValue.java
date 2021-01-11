package myLib.value;

import myLib.Util;

/**
 * A value object representing a video game system
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code systemName}: a String representing the name of the system</li>
 * <li>{@code company}: a {@link VideoGameCompanyValue} value object representing the company that makes the system</li>
 * <li>{@code releaseYear}: a String representing the year the system was released</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVGSYS}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class VideoGameSystemValue
{
    /**
     * FIXME remove eventually - these should be configured in the database
     *
     * @author knerd.knitter
     */
    public enum System
    {
     _3DS( "Nintendo 3DS" ),
     DS( "Nintendo DS" ),
     GB( "Nintento Gameboy" ),
     GBA( "Nintendo Gameboy Advance" ),
     GBC( "Nintento Gameboy Color" ),
     GC( "Nintendo Gamecube" ),
     GEN( "Sega Genesis" ),
     GG( "Sega Game Gear" ),
     LYNX( "Atari Lynx" ),
     MBL( "Mobile" ),
     N64( "Nintendo 64" ),
     NES( "Nintendo (NES)" ),
     PC( "PC" ),
     PS( "Sony Playstation" ),
     PS2( "Sony Playstation 2" ),
     PS3( "Sony Playstation 3" ),
     PS4( "Sony Playstation 4" ),
     PSP( "Sony Playstation Portable (PSP)" ),
     SNES( "Super Nintendo" ),
     VITA( "Sony Playstation Vita" ),
     WII( "Nintendo Wii" ),
     WIIU( "Nintendo Wii U" ),
     XBOX( "Microsoft Xbox" ),
     XBOX_360( "Microsoft Xbox 360" );

        private String text;

        System( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private String                uniqueKey;
    private String                systemName;
    private VideoGameCompanyValue company;
    private String                releaseYear;

    public VideoGameSystemValue( String uniqueKey, System system, VideoGameCompanyValue company, String releaseYear )
    {
        this.uniqueKey = uniqueKey;
        this.systemName = system.text();
        this.company = company;
        this.releaseYear = releaseYear;
    }

    public VideoGameCompanyValue getCompany()
    {
        return company;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

    public String getSystemName()
    {
        return systemName;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setCompany( VideoGameCompanyValue company )
    {
        this.company = company;
    }

    public void setReleaseYear( String releaseYear )
    {
        this.releaseYear = releaseYear;
    }

    public void setSystemName( String systemName )
    {
        this.systemName = systemName;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "Key: [%s]", uniqueKey ) )
          .append( String.format( ", Name:[%s]", systemName ) )
          .append( String.format( ", Company:[%s]", company == null ? "unknown" : company.toString() ) )
          .append( Util.isBlank( releaseYear ) ? "" : String.format( ", Released:[%s]", releaseYear ) );
        return sb.toString();
    }
}
