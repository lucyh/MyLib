package myLib.value;

import java.util.List;

import myLib.Util;

/**
 * TODO description
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
    private Integer           vol;
    private LanguageValue     language;
    private List<String>      tags;

    public String getAuthor()
    {
        return author;
    }

    public DeweyDecimalValue getDd()
    {
        return dd;
    }

    public LanguageValue getLanguage()
    {
        return language;
    }

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

    public List<String> getTags()
    {
        return tags;
    }

    public Integer getVol()
    {
        return vol;
    }

    public void setAuthor( String author )
    {
        this.author = author;
    }

    public void setDd( DeweyDecimalValue dd )
    {
        this.dd = dd;
    }

    public void setLanguage( LanguageValue language )
    {
        this.language = language;
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

    public void setTags( List<String> tags )
    {
        this.tags = tags;
    }

    public void setVol( Integer vol )
    {
        this.vol = vol;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( Util.isEmpty( author ) ? "" : String.format( ", Author:[%s]", author ) )
          .append( String.format( ", Dewey Decimal Code:[%s]", dd.toString() ) )
          .append( Util.isEmpty( publisher ) ? "" : String.format( ", Publisher:[%s]", publisher ) )
          .append( pages == null ? "" : String.format( ", Pages:[%d]", pages.intValue() ) )
          .append( series == null ? "" : ( String.format( ", Series:[%s]", series.toString() ) ) )
          .append( vol == null ? "" : String.format( ", Volume #%d", vol.toString() ) )
          .append( language == null ? "" : ( ", " + language.toString() ) )
          .append( Util.isEmpty( tags ) ? "" : String.format( ", Tag(s):[%s]", Util.print( tags ) ) );
        return sb.toString();
    }
}
