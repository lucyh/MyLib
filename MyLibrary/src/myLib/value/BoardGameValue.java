package myLib.value;

import java.util.HashMap;
import java.util.List;

import myLib.Util;

/**
 * TODO description
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
    private List<String>             tags;

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
     * TODO description
     * 
     * @return
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

    public List<String> getTags()
    {
        return tags;
    }

    /**
     * TODO description
     * 
     * @return
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

    public void setTags( List<String> tags )
    {
        this.tags = tags;
    }

    public void setTimeToPlayMinutes( Integer timeToPlayMin )
    {
        this.timeToPlayMinutes = timeToPlayMin;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer( super.toString() );
        sb.append( Util.isEmpty( description ) ? "" : String.format( ", Description:[%s]", description ) )
          .append( String.format( ", Category:[%s]", category.toString() ) )
          .append( subcategory == null ? "" : String.format( ", Subcategory:[%s]", subcategory.toString() ) )
          .append( minPlayers == null && maxPlayers == null ? "" : String.format( ", Players:[%s]", getPlayers() ) )
          .append( Util.isEmpty( ages ) ? "" : String.format( ", Age:[%s]", ages ) )
          .append( timeToPlayMinutes == null ? "" : String.format( ", Time To Play:[%s]", getTimeToPlay() ) )
          .append( Util.isEmpty( contentsMap ) ? "" : String.format( ", Contents:[%s]", Util.print( contentsMap ) ) )
          .append( Util.isEmpty( tags ) ? "" : String.format( ", Tags:[%s]", Util.print( tags ) ) );
        return sb.toString();
    }
}
