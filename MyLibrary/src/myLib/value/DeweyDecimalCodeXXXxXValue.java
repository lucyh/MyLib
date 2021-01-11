package myLib.value;

/**
 * A value object representing the tenths place of the Dewey Decimal code (extends {@link AbstractDeweyDecimalCodeValue} and implements
 * {@link IDeweyDecimalCodeNumeric})
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code parent}: a {@link DeweyDecimalCodeXXXValue} value object representing the tens place of the Dewey Decimal code</li>
 * </ul>
 * <li>Method(s):</li>
 * <ul>
 * <li>{@link DeweyDecimalCodeXXXxXValue#getFullCode()}</li>
 * <li>{@link DeweyDecimalCodeXXXxXValue#getGrandparent()}</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBDDXXX_X}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class DeweyDecimalCodeXXXxXValue extends AbstractDeweyDecimalCodeValue implements IDeweyDecimalCodeNumeric
{
    private DeweyDecimalCodeXXXValue parent;

    public DeweyDecimalCodeXXXxXValue( String code, String description, DeweyDecimalCodeXXXValue parent )
    {
        super( code, description );
        this.parent = parent;
    }

    /**
     * Return the full code: [great-grandparent(grandparent of the parent){@link #getGrandparent()}][{@link #getParent()}][{@link #getCode()}]
     *
     * @return a String representing the full code
     * @return
     */
    @Override
    public String getFullCode()
    {
        return String.format( "%s%s%s.%s",
                              parent.getGrandparent().getCode(),
                              getGrandparent().getCode(),
                              parent.getCode(),
                              getCode() );
    }

    /**
     * Return the {@link DeweyDecimalCodeXX0Value} value object that is the parent of {@link #parent}
     * 
     * @return a {@link DeweyDecimalCodeXX0Value} value object that represents the grandparent of this object
     */
    public DeweyDecimalCodeXX0Value getGrandparent()
    {
        return parent.getParent();
    }

    public DeweyDecimalCodeXXXValue getParent()
    {
        return parent;
    }

    public void setParent( DeweyDecimalCodeXXXValue parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
