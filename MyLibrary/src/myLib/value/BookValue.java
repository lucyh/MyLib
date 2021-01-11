package myLib.value;

import myLib.Util;

/**
 * A value object representing a book
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code author}: a String representing the name of the author (optional)</li>
 * <li>{@code dd}: a {@link DeweyDecimalValue} value object representing the Dewey Decimal code for the book</li>
 * <li>{@code publisher}: a String representing the name of the publisher (optional)</li>
 * <li>{@code pages}: an {@link Integer} representing the number of pages in the book (optional)</li>
 * <li>{@code series}: a {@link BookSeriesValue} value object representing the book series (optional)</li>
 * <li>{@code vol}: an {@link Integer} representing the volume number of the book (optional)</li>
 * </ul>
 * <li>Method(s):</li>
 * <ul>
 * <li>{@link BookValue#getNameDscr()}</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBBOOK}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class BookValue extends ItemValue
{
    private String            author;
    private DeweyDecimalValue dd;
    private String            publisher;
    private Integer           pages;
    private BookSeriesValue   series;
    private Integer           volume;

    public BookValue( String uniqueKey,
                      String name,
                      String author,
                      DeweyDecimalValue dd,
                      String publisher,
                      Integer pages,
                      BookSeriesValue series,
                      Integer volume )
    {
        super( uniqueKey, name, ItemType.BOOK );
        this.author = author;
        this.dd = dd;
        this.publisher = publisher;
        this.pages = pages;
        this.series = series;
        this.volume = volume;
    }

    public String getAuthor()
    {
        return author;
    }

    public DeweyDecimalValue getDd()
    {
        return dd;
    }

    /** Returns {@code "Title"} */
    @Override
    public String getNameDscr()
    {
        return "Title";
    }

    public Integer getPages()
    {
        return pages;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public BookSeriesValue getSeries()
    {
        return series;
    }

    public Integer getVolume()
    {
        return volume;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public void setDd( DeweyDecimalValue dd )
    {
        this.dd = dd;
    }

    public void setPages( Integer pages )
    {
        this.pages = pages;
    }

    public void setPublisher( String publisher )
    {
        this.publisher = publisher;
    }

    public void setSeries( BookSeriesValue series )
    {
        this.series = series;
    }

    public void setVolume( Integer volume )
    {
        this.volume = volume;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( Util.isBlank( author ) ? "" : String.format( ", Author:[%s]", author ) )
          .append( String.format( ", Dewey Decimal Code:[%s]", dd.toString() ) )
          .append( Util.isBlank( publisher ) ? "" : String.format( ", Publisher:[%s]", publisher ) )
          .append( pages == null ? "" : String.format( ", Pages:[%d]", pages.intValue() ) )
          .append( series == null ? "" : ( String.format( ", Series:[%s]", series.toString() ) ) )
          .append( volume == null ? "" : String.format( ", Volume #%d", volume.toString() ) );
        return sb.toString();
    }
}
