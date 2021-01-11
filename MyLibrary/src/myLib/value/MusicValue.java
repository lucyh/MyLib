package myLib.value;

import java.util.List;

import myLib.Util;

/**
 * TODO descriptin
 * 
 * @author knerd.knitter
 */
public class MusicValue extends ItemValue
{
    /**
     * TODO description
     * 
     * @author knerd.knitter
     */
    public enum Format
    {
     CD( "CD" ), DIG( "Digital" );
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

    private String       artist;
    private Format       format;
    private List<String> trackList;

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

    public List<String> getTrackList()
    {
        return trackList;
    }

    public void setArtist( String artist )
    {
        this.artist = artist;
    }

    public void setFormat( Format format )
    {
        this.format = format;
    }

    public void setTrackList( List<String> trackList )
    {
        this.trackList = trackList;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( super.toString() )
          .append( Util.isEmpty( artist ) ? "" : String.format( ", Artist:[%s]", artist ) )
          .append( String.format( ", Format:[%s]", format.text() ) )
          .append( Util.isEmpty( trackList ) ? "" : String.format( ", Track List:[%s]", Util.print( trackList ) ) );
        return sb.toString();
    }
}
