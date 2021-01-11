package myLib.value;

import myLib.Util;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class ItemValue
{
    /**
     * TODO description
     *
     * @author knerd.knitter
     */
    public enum ItemType
    {
     BG( "Board game", BoardGameValue.class ),
     BOOK( "Book", BookValue.class ),
     MOV( "Movie", MovieTVValue.class ),
     MUS( "Music", MusicValue.class ),
     TV( "Television", MovieTVValue.class ),
     VG( "Video Game", VideoGameValue.class );
        private String   text;
        private Class<?> valueClass;

        ItemType( String text, Class<?> valueClass )
        {
            this.text = text;
            this.valueClass = valueClass;
        }

        public String text()
        {
            return text;
        }

        public Class<?> valueClass()
        {
            return valueClass;
        }
    }

    private String   unqeKey;
    private String   name;
    private ItemType itemType;
    private String   copyrightYear;

    public ItemType getItemType()
    {
        return itemType;
    }

    public String getName()
    {
        return name;
    }

    public String getNameDscr()
    {
        return "Name";
    }

    public String getUnqeKey()
    {
        return unqeKey;
    }

    public void setItemType( ItemType itemType )
    {
        this.itemType = itemType;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setUnqeKey( String unqeKey )
    {
        this.unqeKey = unqeKey;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "Unique Key:[%s], Item Type:[%s]", unqeKey, itemType.text() ) )
          .append( String.format( ", %s:[%s]", getNameDscr(), name ) )
          .append( Util.isEmpty( copyrightYear ) ? "" : String.format( ", Year:[%s]", copyrightYear ) );
        return sb.toString();
    }
}
