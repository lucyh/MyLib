package myLib.value;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class BookSeriesValue
{
    private String seriesTitle;
    private String seriesAuthor;

    public String getSeriesAuthor()
    {
        return seriesAuthor;
    }

    public String getSeriesTitle()
    {
        return seriesTitle;
    }

    public void setSeriesAuthor( String seriesAuthor )
    {
        this.seriesAuthor = seriesAuthor;
    }

    public void setSeriesTitle( String seriesTitle )
    {
        this.seriesTitle = seriesTitle;
    }

    @Override
    public String toString()
    {
        return String.format( "Series Title:[%s], Series Author:[%s]", seriesTitle, seriesAuthor );
    }
}
