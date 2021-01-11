package myLib.value;

/**
 * TODO description
 * 
 * @author knerd.knitter
 */
public class CodeXX0Value extends AbstractCodeValue
{
    private CodeX00Value parent;

    public CodeX00Value getParent()
    {
        return parent;
    }

    public void setParent( CodeX00Value parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return String.format( "%s, Parent:[%s]", super.toString(), parent.toString() );
    }
}
