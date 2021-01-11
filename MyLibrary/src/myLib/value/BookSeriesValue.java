package myLib.value;

/**
 * A value object representing a book series
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code seriesTitle}: a String representing the title of the series</li>
 * <li>{@code seriesAuthor}: a String representing the author of the series (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBBKSRS}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class BookSeriesValue
{
    private String uniqueKey;
    private String seriesTitle;
    private String seriesAuthor;

    public BookSeriesValue( String uniqueKey, String seriesTitle, String seriesAuthor )
    {
        this.uniqueKey = uniqueKey;
        this.seriesTitle = seriesTitle;
        this.seriesAuthor = seriesAuthor;
    }

    public String getSeriesAuthor()
    {
        return seriesAuthor;
    }

    public String getSeriesTitle()
    {
        return seriesTitle;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setSeriesAuthor( String seriesAuthor )
    {
        this.seriesAuthor = seriesAuthor;
    }

    public void setSeriesTitle( String seriesTitle )
    {
        this.seriesTitle = seriesTitle;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        return String.format( "Key:[%s], Series Title:[%s], Series Author:[%s]", uniqueKey, seriesTitle, seriesAuthor );
    }
}
