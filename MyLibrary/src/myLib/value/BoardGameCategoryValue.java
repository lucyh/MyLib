package myLib.value;

public class BoardGameCategoryValue
{
    /**
     * TODO remove eventually - these should be configured in the database
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

    private Category category;

    @Override
    public String toString()
    {
        return category.text();
    }
}
