package myLib.value;

import java.util.ArrayList;
import java.util.List;

import myLib.Util;

/**
 * A value object representing a visual entertainment item (could be movie or television show)
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code format}: a {@link Format} enum value representing the format of the movie or television show</li>
 * <li>{@code director}: a String representing the name of the director (optional)</li>
 * <li>{@code performerList}: a {@link List} of Strings representing the name of the performer(s) (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBVIS}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public abstract class VisualEntertainmentValue extends ItemValue
{
    /**
     * An enum representing the format of the visual entertainment
     * <ul>
     * <li>Value(s):</li>
     * <ul>
     * <li>{@link Format#DIG}: {@code "Digital"}</li>
     * <li>{@link Format#DVD}: {@code "DVD"}</li>
     * <li>{@link Format#VHS}: {@code "VHS"}</li>
     * </ul>
     * <li>Field(s):</li>
     * <ul>
     * <li>{@code text}: a String representing the text of the format</li>
     * </ul>
     * </ul>
     *
     * @author knerd.knitter
     */
    public enum Format
    {
     DIG( "Digital" ),
     DVD( "DVD" ),
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

    private Format       format;
    private String       director;
    private List<String> performerList;

    public VisualEntertainmentValue( String uniqueKey,
                                     String name,
                                     ItemType itemType,
                                     Format format,
                                     String director,
                                     List<String> performerList )
    {
        super( uniqueKey, name, itemType );
        this.format = format;
        this.director = director;
        this.performerList = performerList;
    }

    public void addPerformer( String performer )
    {
        if( performerList == null )
        {
            performerList = new ArrayList<String>();
        }
        performerList.add( performer );
    }

    public String getDirector()
    {
        return director;
    }

    public Format getFormat()
    {
        return format;
    }

    public List<String> getPerformerList()
    {
        return performerList;
    }

    public void setDirector( String director )
    {
        this.director = director;
    }

    public void setFormat( Format format )
    {
        this.format = format;
    }

    public void setPerformerList( List<String> performerList )
    {
        this.performerList = performerList;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( String.format( ", Format:[%s]", format.text() ) )
          .append( Util.isBlank( director ) ? "" : String.format( ", Director:[%s]", director ) )
          .append( Util.isEmpty( performerList ) ? "" : String.format( ", Performers:[%s]",
                                                                       Util.print( performerList ) ) );
        return sb.toString();
    }
}
