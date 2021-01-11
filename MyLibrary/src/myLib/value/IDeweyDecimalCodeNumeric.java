package myLib.value;

/**
 * An interface representing the full numeric value of the Dewey Decimal code
 * <ul>
 * <li>Method(s):</li>
 * <ul>
 * <li>{@link IDeweyDecimalCodeNumeric#getFullCode()}</li>
 * </ul>
 * <li><b><i>No database table</b></i></li>
 * </ul>
 * 
 * @author knerd.knitter
 */
public interface IDeweyDecimalCodeNumeric
{
    /**
     * Returns a String representing the full numeric Dewey Decimal code (may or may not contain a decimal point value)
     * 
     * @return a String representing the full numeric Dewey Decimal code
     */
    public abstract String getFullCode();
}
