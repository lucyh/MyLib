package myLib.value;

import java.util.ArrayList;
import java.util.List;

import myLib.Util;

/**
 * An abstract value object representing an item in the library
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code name}: a String representing the name of the item (Title in {@link BookValue} and Album Title in {@link MusicValue})</li>
 * <li>{@code itemType}: an {@link ItemType} enum value representing the type of item</li>
 * <li>{@code language}: a {@link LanguageValue} value object representing the language of the item (optional)</li>
 * <li>{@code copyrightYear}: a String representing the copyright year for the item (optional)</li>
 * <li>{@code tags}: a {@link List} of {@link TagValue} value objects representing tag(s) for the item (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code DBITEM}</b></li>
 * <li>Uses a join table <b>{@code DBITEMTAG}</b> to link {@link TagValue} and this</li>
 * </ul>
 *
 * @author knerd.knitter
 */
public abstract class ItemValue
{
    /**
     * An enum representing the type of the item
     * <ul>
     * <li>Value(s):</li>
     * <ul>
     * <li>{@link ItemType#BG}: {@code "Board game"}</li>
     * <li>{@link ItemType#BOOK}: {@code "Book"}</li>
     * <li>{@link ItemType#MOV}: {@code "Movie"}</li>
     * <li>{@link ItemType#MUS}: {@code "Music"}</li>
     * <li>{@link ItemType#TV}: {@code "Television"}</li>
     * <li>{@link ItemType#VG}: {@code "Video Game"}</li>
     * </ul>
     * <li>Field(s):</li>
     * <ul>
     * <li>{@code text}: a String representing the text of the item type</li>
     * </ul>
     * </ul>
     *
     * @author knerd.knitter
     */
    public enum ItemType
    {
     BG( "Board game" ),
     BOOK( "Book" ),
     MOV( "Movie" ),
     MUS( "Music" ),
     TV( "Television" ),
     VG( "Video Game" );

        private String text;

        ItemType( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private String         uniqueKey;
    private String         name;
    private ItemType       itemType;
    private LanguageValue  language;
    private String         copyrightYear;
    private List<TagValue> tags;

    public ItemValue( String uniqueKey, String name, ItemType itemType )
    {
        this.uniqueKey = uniqueKey;
        this.name = name;
        this.itemType = itemType;
    }

    public ItemValue( String uniqueKey,
                      String name,
                      ItemType itemType,
                      LanguageValue language,
                      String copyrightYear,
                      List<TagValue> tags )
    {
        this.uniqueKey = uniqueKey;
        this.name = name;
        this.itemType = itemType;
        this.language = language;
        this.copyrightYear = copyrightYear;
        this.tags = tags;
    }

    public void addTag( TagValue tag )
    {
        if( tags == null )
        {
            tags = new ArrayList<TagValue>();
        }
        tags.add( tag );
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public LanguageValue getLanguage()
    {
        return language;
    }

    public String getName()
    {
        return name;
    }

    public String getNameDscr()
    {
        return "Name";
    }

    public List<TagValue> getTags()
    {
        return tags;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setCopyrightYear( String copyrightYear )
    {
        this.copyrightYear = copyrightYear;
    }

    public void setItemType( ItemType itemType )
    {
        this.itemType = itemType;
    }

    public void setLanguage( LanguageValue language )
    {
        this.language = language;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setTags( List<TagValue> tags )
    {
        this.tags = tags;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "Key:[%s], Item Type:[%s]", uniqueKey, itemType.text() ) )
          .append( String.format( ", %s:[%s]", getNameDscr(), name ) )
          .append( language == null ? "" : String.format( ", Language:[%s]" + language.toString() ) )
          .append( Util.isBlank( copyrightYear ) ? "" : String.format( ", Year:[%s]", copyrightYear ) )
          .append( Util.isEmpty( tags ) ? "" : String.format( ", Tags:[%s]", Util.print( tags ) ) );
        return sb.toString();
    }
}
