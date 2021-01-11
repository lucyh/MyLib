package myLib.value;

/**
 * A value object representing the ones place of the Dewey Decimal code (extends {@link AbstractDeweyDecimalCodeValue} and implements
 * {@link IDeweyDecimalCodeNumeric})
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code parent}: a {@link DeweyDecimalCodeXX0Value} value object representing the tens place of the Dewey Decimal code</li>
 * </ul>
 * <li>Method(s):</li>
 * <ul>
 * <li>{@link DeweyDecimalCodeXXXValue#getFullCode()}</li>
 * <li>{@link DeweyDecimalCodeXXXValue#getGrandparent()}</li>
 * <li>
 * <li>Database Table Name: <b>{@code LIBDDXXX}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class DeweyDecimalCodeXXXValue extends AbstractDeweyDecimalCodeValue implements IDeweyDecimalCodeNumeric
{
    private DeweyDecimalCodeXX0Value parent;

    public DeweyDecimalCodeXXXValue( String code, String description, DeweyDecimalCodeXX0Value parent )
    {
        super( code, description );
        this.parent = parent;
    }

    /**
     * Return the full code: [{@link #getGrandparent()}][{@link #getParent()}][{@link #getCode()}]
     *
     * @return a String representing the full code
     */
    @Override
    public String getFullCode()
    {
        return String.format( "%s%s%s", getGrandparent().getCode(), parent.getCode(), getCode() );
    }

    /**
     * Return the {@link DeweyDecimalCodeX00Value} value object that is the parent of {@link #parent}
     * 
     * @return a {@link DeweyDecimalCodeX00Value} value object that represents the grandparent of this object
     */
    public DeweyDecimalCodeX00Value getGrandparent()
    {
        return parent.getParent();
    }

    public DeweyDecimalCodeXX0Value getParent()
    {
        return parent;
    }

    public void setParent( DeweyDecimalCodeXX0Value parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
