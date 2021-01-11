package myLib.value;

import java.util.HashMap;

import myLib.Util;

/**
 * A value object representing a music item (album)
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code artist}: a String representing the artist for the album</li>
 * <li>{@code format}: a {@link Format} enum value representing the format of the album</li>
 * <li>{@code trackMap}: a {@link HashMap} of {@link Integer}-String (track number-title) pairs representing the track listing for the album</li>
 * </ul>
 * <li>Database Table Name: <b>{@code DBMUS}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class MusicValue extends ItemValue
{
    /**
     * An enum representing the format of the album
     * <ul>
     * <li>Value(s):</li>
     * <ul>
     * <li>{@link Format#CD}: {@code "CD"}</li>
     * <li>{@link Format#DIG}: {@code "Digital"}</li>
     * </ul>
     * <li>Field(s):</li>
     * <ul>
     * <li>{@code text}: a String representing the text of teh format</li>
     * </ul>
     * </ul>
     * 
     * @author knerd.knitter
     */
    public enum Format
    {
     CD( "CD" ),
     DIG( "Digital" );

        private String text;

        Format( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private String                   artist;
    private Format                   format;
    private HashMap<Integer, String> trackMap;

    public MusicValue( String uniqueKey, String name, String artist, Format format, HashMap<Integer, String> trackMap )
    {
        super( uniqueKey, name, ItemType.MUS );
        this.artist = artist;
        this.format = format;
        this.trackMap = trackMap;
    }

    public void addTrack( int trackNumber, String title )
    {
        if( trackMap == null )
        {
            trackMap = new HashMap<Integer, String>();
        }
        trackMap.put( trackNumber, title );
    }

    public String getArtist()
    {
        return artist;
    }

    public Format getFormat()
    {
        return format;
    }

    @Override
    public String getNameDscr()
    {
        return "Album Name";
    }

    public HashMap<Integer, String> getTrackMap()
    {
        return trackMap;
    }

    public void setArtist( String artist )
    {
        this.artist = artist;
    }

    public void setFormat( Format format )
    {
        this.format = format;
    }

    public void setTrackMap( HashMap<Integer, String> trackMap )
    {
        this.trackMap = trackMap;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( super.toString() )
          .append( Util.isBlank( artist ) ? "" : String.format( ", Artist:[%s]", artist ) )
          .append( String.format( ", Format:[%s]", format.text() ) )
          .append( Util.isEmpty( trackMap ) ? "" : String.format( ", Track List:[%s]", Util.print( trackMap ) ) );
        return sb.toString();
    }
}
