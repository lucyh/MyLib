package myLib.value;

import myLib.Util;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class SystemValue
{
    /**
     * TODO remove eventually - these should be configured in the database
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

    private System                system;
    private VideoGameCompanyValue company;
    private String                releaseYear;

    public VideoGameCompanyValue getCompany()
    {
        return company;
    }

    public String getReleaseYear()
    {
        return releaseYear;
    }

    public System getSystem()
    {
        return system;
    }

    public void setCompany( VideoGameCompanyValue company )
    {
        this.company = company;
    }

    public void setReleaseYear( String releaseYear )
    {
        this.releaseYear = releaseYear;
    }

    public void setSystem( System system )
    {
        this.system = system;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "System:[%s]", system.text() ) );
        sb.append( String.format( ", Company:[%s]", company == null ? "unknown" : company.toString() ) );
        sb.append( Util.isEmpty( releaseYear ) ? "" : String.format( ", Released:[%s]", releaseYear ) );
        return sb.toString();
    }
}
