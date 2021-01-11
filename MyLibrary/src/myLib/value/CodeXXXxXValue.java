package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class CodeXXXxXValue extends AbstractCodeValue
{
    private CodeXXXValue parent;

    /**
     * TODO description
     * 
     * @return
     */
    public String getFullCode()
    {
        return String.format( "%s%s%s.%s",
                              parent.getGrandparent().getCode(),
                              getGrandparent().getCode(),
                              parent.getCode(),
                              getCode() );
    }

    /**
     * TODO description
     * 
     * @return
     */
    public CodeXX0Value getGrandparent()
    {
        return parent.getParent();
    }

    public CodeXXXValue getParent()
    {
        return parent;
    }

    public void setParent( CodeXXXValue parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
