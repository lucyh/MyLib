package myLib.value;

import myLib.Util;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public abstract class AbstractCodeValue
{
    private String code;
    private String description;

    public String getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return code + ( Util.isEmpty( description ) ? "" : String.format( " (%s)", description ) );
    }
}
