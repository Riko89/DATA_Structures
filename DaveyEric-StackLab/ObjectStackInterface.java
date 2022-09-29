
/**
 * ObjectStackInterface is a prototype for the ObjectStack class
 * also implemented by the ObjectStack class.
 * 
 * @author Eric Davey 
 * @version 03/06/2018 version Final
 */
public interface ObjectStackInterface
{
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public void push(Object o);
    public Object pop();
    public Object top();
}
