package myLib.value;

import java.util.List;

import myLib.Util;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class MovieTVValue extends ItemValue
{
    /**
     * TODO description
     *
     * @author knerd.knitter
     */
    public enum Format
    {
     DVD( "DVD" ),
     DIG( "Digital" ),
     VHS( "VHS" );

        private String text;

        Format( String text )
        {
            this.text = text;
        }

        String text()
        {
            return text;
        }
    }

    private Format        format;
    private Integer       lengthMinutes; // if movie
    private List<Integer> seasons;       // if tv
    private Integer       episodeCnt;    // if tv
    private List<String>  performerList;

    public Integer getEpisodeCnt()
    {
        return episodeCnt;
    }

    public Format getFormat()
    {
        return format;
    }

    public Integer getLengthMinutes()
    {
        return lengthMinutes;
    }

    public List<String> getPerformerList()
    {
        return performerList;
    }

    public List<Integer> getSeasons()
    {
        return seasons;
    }

    public void setEpisodeCnt( Integer episodeCnt )
    {
        this.episodeCnt = episodeCnt;
    }

    public void setFormat( Format format )
    {
        this.format = format;
    }

    public void setLengthMinutes( Integer lengthMinutes )
    {
        this.lengthMinutes = lengthMinutes;
    }

    public void setPerformerList( List<String> performerList )
    {
        this.performerList = performerList;
    }

    public void setSeasons( List<Integer> seasons )
    {
        this.seasons = seasons;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( String.format( ", Format:[%s]", format.text() ) )
          .append( lengthMinutes == null ? "" : String.format( ", Length:[%d minutes]", lengthMinutes.intValue() ) )
          .append( Util.isEmpty( seasons ) ? "" : String.format( ", Season(s):[%s]", Util.print( seasons ) ) )
          .append( episodeCnt == null ? "" : String.format( ", Episode Count:[%d]", episodeCnt.intValue() ) )
          .append( Util.isEmpty( performerList ) ? "" : String.format( ", Performers:[%s]",
                                                                       Util.print( performerList ) ) );
        return sb.toString();
    }
}
