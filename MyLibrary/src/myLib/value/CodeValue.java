package myLib.value;

/**
 * TODO description
 *
 * @author knerd.knitter
 */
public class CodeValue
{
    private CodeXXXValue   ones;
    private CodeXXXxXValue tenths;

    @Override
    public String toString()
    {
        return tenths == null ? ones.getFullCode() : tenths.getFullCode();
    }
}
