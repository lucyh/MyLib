package myLib.value;

/**
 * A value object representing a category for the {@link BoardGameValue} value object
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code uniqueKey}: a String representing the unique key of the object</li>
 * <li>{@code categoryName}: a String representing the name of the category</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBBGCATG}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class BoardGameCategoryValue
{
    /**
     * FIXME remove eventually - these should be configured in the database
     *
     * @author knerd.knitter
     */
    public enum Category
    {
     Q_20( "20 questions" ),
     BRD( "Board" ),
     CARD( "Card" ),
     CLAS( "Classic" ),
     CHAR( "Charades" ),
     CO_OP( "Cooperative" ),
     DICE( "Dice" ),
     DOM( "Dominoes" ),
     DRAW( "Drawing" ),
     ELE( "Electronic" ),
     FAM( "Family" ),
     KID( "Kids" ),
     LEGO( "Lego" ),
     MANC( "Mancala" ),
     MONO( "Monopoly" ),
     MATH( "Math" ),
     MYS( "Mystery" ),
     PRTY( "Party" ),
     PUZ( "Puzzle" ),
     RIDL( "Riddles" ),
     STAK( "Stacking" ),
     STGY( "Strategy" ),
     TILE( "Tiles" ),
     TRIV( "Trivia" ),
     WORD( "Word" );

        private String text;

        Category( String text )
        {
            this.text = text;
        }

        public String text()
        {
            return text;
        }
    }

    private String uniqueKey;
    private String categoryName;

    public BoardGameCategoryValue( Category category )
    {
        this.categoryName = category.text();
    }

    public BoardGameCategoryValue( String categoryName )
    {
        this.categoryName = categoryName;
    }

    public String getUniqueKey()
    {
        return uniqueKey;
    }

    public void setUniqueKey( String uniqueKey )
    {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString()
    {
        return String.format( "Key: [%s], Name:[%s]", uniqueKey, categoryName );
    }
}
