package myLib.value;

/**
 * A value object representing the tens place of the Dewey Decimal code (extends {@link AbstractDeweyDecimalCodeValue})
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code parent}: a {@link DeweyDecimalCodeX00Value} value object representing the hundreds place of the Dewey Decimal code</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBDDXX}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class DeweyDecimalCodeXX0Value extends AbstractDeweyDecimalCodeValue
{
    private DeweyDecimalCodeX00Value parent;

    public DeweyDecimalCodeXX0Value( String code, String description, DeweyDecimalCodeX00Value parent )
    {
        super( code, description );
        this.parent = parent;
    }

    public DeweyDecimalCodeX00Value getParent()
    {
        return parent;
    }

    public void setParent( DeweyDecimalCodeX00Value parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
