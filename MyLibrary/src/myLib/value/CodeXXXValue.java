package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class CodeXXXValue extends AbstractCodeValue
{
    private CodeXX0Value parent;

    /**
     * TODO description
     *
     * @return
     */
    public String getFullCode()
    {
        return String.format( "%s%s%s", getGrandparent().getCode(), parent.getCode(), getCode() );
    }

    /**
     * TODO description
     * 
     * @return
     */
    public CodeX00Value getGrandparent()
    {
        return parent.getParent();
    }

    public CodeXX0Value getParent()
    {
        return parent;
    }

    public void setParent( CodeXX0Value parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
