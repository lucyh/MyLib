package myLib.value;

/**
 * A value object representing the hundreds place of the Dewey Decimal code (extends {@link AbstractDeweyDecimalCodeValue})
 * <ul>
 * <li>Database Table Name: <b>{@code LIBDDX}</b></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public class DeweyDecimalCodeX00Value extends AbstractDeweyDecimalCodeValue
{
    public DeweyDecimalCodeX00Value( String code, String description )
    {
        super( code, description );
    }
}
