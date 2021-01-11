package myLib.value;

import myLib.Util;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class DeweyDecimalValue
{
    private CodeValue line1;
    private String    line2;
    private String    line3;
    private String    line4;

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append( String.format( "%s / %s", line1.toString(), line2 ) );
        sb.append( Util.isEmpty( line3 ) ? "" : ( " / " + line3 ) );
        sb.append( Util.isEmpty( line4 ) ? "" : ( " / " + line4 ) );
        return sb.toString();
    }
}
