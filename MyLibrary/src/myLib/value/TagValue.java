package myLib.value;

/**
 * A value object representing a tag for an item
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code text}: a String representing the text of the tag</li>
 * </ul>
 * <li>Database Table Name: <b>{@code DBTAG}</b></li>
 * <li>Uses a join table <b>{@code DBITEMTAG}</b> to link {@link ItemValue} and this</li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class TagValue
{
    private String uniqueKey;
    private String text;

    public TagValue( String uniqueKey, String text )
    {
        this.uniqueKey = uniqueKey;
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setText( String text )
    {
        this.text = text;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        return String.format( "Key:[%s], Text:[%s]", uniqueKey, text );
    }
}
