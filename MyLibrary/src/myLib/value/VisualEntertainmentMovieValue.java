package myLib.value;

import java.util.List;

/**
 * A value object representing a movie item (extends {@link VisualEntertainmentValue})
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code lengthMinutes}: an {@link Integer} representing the length of the movie in minutes (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVISMOV}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class VisualEntertainmentMovieValue extends VisualEntertainmentValue
{
    private Integer lengthMinutes;

    public VisualEntertainmentMovieValue( String uniqueKey,
                                          String name,
                                          Format format,
                                          String director,
                                          List<String> performerList,
                                          Integer lengthMinutes )
    {
        super( uniqueKey, name, ItemType.MOV, format, director, performerList );
        this.setLengthMinutes( lengthMinutes );
    }

    public Integer getLengthMinutes()
    {
        return lengthMinutes;
    }

    public void setLengthMinutes( Integer lengthMinutes )
    {
        this.lengthMinutes = lengthMinutes;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( getLengthMinutes() == null ? "" : String.format( ", Length:[%d minutes]",
                                                                    getLengthMinutes().intValue() ) );
        return sb.toString();
    }
}
