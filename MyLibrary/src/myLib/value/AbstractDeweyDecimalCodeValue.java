package myLib.value;

import myLib.Util;

/**
 * An abstract value object to extend in the Dewey Decimal Code value objects
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code code}: a String representing the numeric code</li>
 * <li>{@code description}: a String representing a description of this particular code</li>
 * </ul>
 * <li><b><i>No database table</b></i></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public abstract class AbstractDeweyDecimalCodeValue
{
    private String code;
    private String description;

    public AbstractDeweyDecimalCodeValue( String code, String description )
    {
        this.code = code;
        this.description = description;
    }

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
        return code + ( Util.isBlank( description ) ? "" : String.format( " (%s)", description ) );
    }
}
