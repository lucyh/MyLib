package myLib.value;

import java.util.HashMap;

import myLib.Util;

/**
 * A value object representing a board game
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code description}: a String representing a description of the board game</li>
 * <li>{@code category}: a {@link BoardGameCategoryValue} value object representing the type of board game</li>
 * <li>{@code subcategory}: a {@link BoardGameCategoryValue} value object representing a subcategory for the board game (optional)</li>
 * <li>{@code minPlayers}: an {@link Integer} representing the minimum number of players required (optional)</li>
 * <li>{@code maxPlayers}: an {@link Integer} representing the maximum number of players (optional)</li>
 * <li>{@code ages}: a String representing the suggested age for the game (optional)</li>
 * <li>{@code timeToPlayMinutes}: an {@link Integer} representing the amount of time in minutes the game takes to play (optional)</li>
 * <li>{@code contentsMap}: a {@link HashMap} of String-{@link Integer} (item-number of items) pairs representing the contents of the game (optional)</li>
 * </ul>
 * <li>Method(s):</li>
 * <ul>
 * <li>{@link BoardGameValue#getPlayers()}</li>
 * <li>{@link BoardGameValue#getTimeToPlay()}</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBBG}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class BoardGameValue extends ItemValue
{
    private String                   description;
    private BoardGameCategoryValue   category;
    private BoardGameCategoryValue   subcategory;
    private Integer                  minPlayers;
    private Integer                  maxPlayers;
    private String                   ages;
    private Integer                  timeToPlayMinutes;
    private HashMap<String, Integer> contentsMap;

    public BoardGameValue( String uniqueKey,
                           String name,
                           String description,
                           BoardGameCategoryValue category,
                           BoardGameCategoryValue subcategory,
                           Integer minPlayers,
                           Integer maxPlayers,
                           String ages,
                           Integer timeToPlayMinutes )
    {
        super( uniqueKey, name, ItemType.BG );
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.minPlayers = minPlayers;
        this.ages = ages;
        this.timeToPlayMinutes = timeToPlayMinutes;
    }

    public void addContents( String item, int count )
    {
        if( contentsMap == null )
        {
            contentsMap = new HashMap<String, Integer>();
        }
        contentsMap.put( item, count );
    }

    public String getAges()
    {
        return ages;
    }

    public BoardGameCategoryValue getCategory()
    {
        return category;
    }

    public HashMap<String, Integer> getContentsMap()
    {
        return contentsMap;
    }

    public String getDescription()
    {
        return description;
    }

    public Integer getMaxPlayers()
    {
        return maxPlayers;
    }

    public Integer getMinPlayers()
    {
        return minPlayers;
    }

    /**
     * <ul>
     * <li>If {@link #minPlayers} is not <b>{@code null}</b> or {@link #maxPlayers} is not <b>{@code null}</b>:</li>
     * <ul>
     * <li>If {@link #minPlayers} is <b>{@code null}</b> (which means {@link #maxPlayers} is not <b>{@code null}</b>), return a String indicating [{@code up to}
     * {@link #maxPlayers} {@code players}]</li>
     * <li>Otherwise, if {@link #maxPlayers} is <b>{@code null}</b> (which means {@link #minPlayers} is not <b>{@code null}</b>), return a String indicating
     * [{@code at least} {@link #minPlayers} {@code players}]</li>
     * <li>Otherwise (which means {@link #minPlayers} and {@link #maxPlayers} are not <b>{@code null}</b>), return a String indicating
     * [{@link #minPlayers}-{@link #maxPlayers}]</li>
     * </ul>
     * <li>Otherwise, return <b>{@code null}</b></li>
     * </ul>
     * 
     * @return a String representing a description of the number of players
     */
    private String getPlayers()
    {
        String retVal = null;
        if( minPlayers != null || maxPlayers != null )
        {
            if( minPlayers == null ) // maxPlayers is not null
            {
                retVal = String.format( "up to %d players", maxPlayers.intValue() );
            }
            else if( maxPlayers == null ) // minPlayers is not null
            {
                retVal = String.format( "at least %d players", minPlayers.intValue() );
            }
            else // minPlayers and maxPlayers are not null
            {
                retVal = String.format( "%d-%d", minPlayers.intValue(), maxPlayers.intValue() );
            }
        }
        return retVal;
    }

    public BoardGameCategoryValue getSubcategory()
    {
        return subcategory;
    }

    /**
     * <ul>
     * <li>If {@link #timeToPlayMinutes} is not <b>{@code null}</b>:</li>
     * <ul>
     * <li>If {@link #timeToPlayMinutes} is less than <b>{@code 60}</b>, return a String indicating [{@link #timeToPlayMinutes} {@code minutes}]</li>
     * <li>Otherwise, return a String representing the number of hours and minutes (minutes equals {@link #timeToPlayMinutes} modulus <b>{@code 60}</b>; hours
     * equals {@link #timeToPlayMinutes} divided by <b>{@code 60}</b> rounded down)</li>
     * </ul>
     * <li>Otherwise, return <b>{@code null}</b>
     * </ul>
     * 
     * @return a String representing the amount of time to play
     */
    private String getTimeToPlay()
    {
        String retVal = null;
        if( timeToPlayMinutes != null )
        {
            if( timeToPlayMinutes.intValue() < 60 )
            {
                retVal = String.format( "%d minutes", timeToPlayMinutes.intValue() );
            }
            else
            {
                int min = timeToPlayMinutes.intValue() % 60;
                int hour = Math.floorDiv( timeToPlayMinutes.intValue(), 60 );
                retVal = String.format( "%d hours%s", hour, min == 0 ? "" : String.format( ", %d minutes", min ) );
            }
        }
        return retVal;
    }

    public Integer getTimeToPlayMinutes()
    {
        return timeToPlayMinutes;
    }

    public void setAges( String ages )
    {
        this.ages = ages;
    }

    public void setCategory( BoardGameCategoryValue category )
    {
        this.category = category;
    }

    public void setContentsMap( HashMap<String, Integer> contentsMap )
    {
        this.contentsMap = contentsMap;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public void setMaxPlayers( Integer maxPlayers )
    {
        this.maxPlayers = maxPlayers;
    }

    public void setMinPlayers( Integer minPlayers )
    {
        this.minPlayers = minPlayers;
    }

    public void setSubcategory( BoardGameCategoryValue subcategory )
    {
        this.subcategory = subcategory;
    }

    public void setTimeToPlayMinutes( Integer timeToPlayMin )
    {
        this.timeToPlayMinutes = timeToPlayMin;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( Util.isBlank( description ) ? "" : String.format( ", Description:[%s]", description ) )
          .append( String.format( ", Category:[%s]", category.toString() ) )
          .append( subcategory == null ? "" : String.format( ", Subcategory:[%s]", subcategory.toString() ) )
          .append( minPlayers == null && maxPlayers == null ? "" : String.format( ", Players:[%s]", getPlayers() ) )
          .append( Util.isBlank( ages ) ? "" : String.format( ", Age:[%s]", ages ) )
          .append( timeToPlayMinutes == null ? "" : String.format( ", Time To Play:[%s]", getTimeToPlay() ) )
          .append( Util.isEmpty( contentsMap ) ? "" : String.format( ", Contents:[%s]", Util.print( contentsMap ) ) );
        return sb.toString();
    }
}
