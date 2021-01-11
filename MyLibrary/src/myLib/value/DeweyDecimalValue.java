package myLib.value;

import myLib.Util;

/**
 * A value object representing the Dewey Decimal code for a book (up to 4 lines)
 * <ul>
 * <li>Field(s):</li>
 * <ul>
 * <li>{@code line1}: a value object that implements {@link IDeweyDecimalCodeNumeric} representing the first line of the code</li>
 * <li>{@code line2}: a String representing the second line of the code</li>
 * <li>{@code line3}: a String representing the third line of the code (optional)</li>
 * <li>{@code line4}: a String representing the fourth line of the code (optional)</li>
 * </ul>
 * <li>Database Table Name: <b>{@code LIBDD}</b></li>
 * </ul>
 *
 * @author knerd.knitter
 */
public class DeweyDecimalValue
{
    private IDeweyDecimalCodeNumeric line1;
    private String                   line2;
    private String                   line3;
    private String                   line4;

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "%s / %s", line1.toString(), line2 ) );
        sb.append( Util.isBlank( line3 ) ? "" : ( " / " + line3 ) );
        sb.append( Util.isBlank( line4 ) ? "" : ( " / " + line4 ) );
        return sb.toString();
    }
}
