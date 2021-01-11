package myLib.value;

import java.util.List;

/**
 * A value object representing a television show item (extends {@link VisualEntertainmentValue})
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code season}: an {@link Integer} representing the season number of the television show (optional)</li>
 * <li>{@code episodeCount}: an {@link Integer} representing the number of episodes in the season of the television show (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVISTV}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class VisualEntertainmentTVValue extends VisualEntertainmentValue
{
    private Integer season;
    private Integer episodeCount;

    public VisualEntertainmentTVValue( String uniqueKey,
                                       String name,
                                       Format format,
                                       String director,
                                       List<String> performerList,
                                       Integer season,
                                       Integer episodeCount )
    {
        super( uniqueKey, name, ItemType.TV, format, director, performerList );
        this.season = season;
        this.episodeCount = episodeCount;
    }

    public Integer getEpisodeCount()
    {
        return episodeCount;
    }

    public Integer getSeason()
    {
        return season;
    }

    public void setEpisodeCount( Integer episodeCount )
    {
        this.episodeCount = episodeCount;
    }

    public void setSeason( Integer season )
    {
        this.season = season;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( season == null ? "" : String.format( ", Season:[%d]", season.intValue() ) );
        sb.append( episodeCount == null ? "" : String.format( ", Episode Count:[%d]", episodeCount.intValue() ) );
        return sb.toString();
    }
}
